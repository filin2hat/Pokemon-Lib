package com.biryulindevelop.pokemonlib.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.util.Constants.DOMINANT_COLOR_KEY
import com.biryulindevelop.pokemonlib.util.Constants.POKEMON_NAME_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val savedState: SavedStateHandle,
    private val repository: PokemonRepository
) : ViewModel() {

    private var _pokemonInfo: MutableState<PokemonDto?> = mutableStateOf(null)
    val pokemonInfo: MutableState<PokemonDto?> = _pokemonInfo

    private var _dominantColor: MutableState<Color?> = mutableStateOf(null)
    val dominantColor: MutableState<Color?> = _dominantColor

    private var _errorInfo: MutableState<String?> = mutableStateOf(null)
    val errorInfo: MutableState<String?> = _errorInfo

    private var _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: MutableState<Boolean> = _isLoading

    init {
        viewModelScope.launch {
            val color = savedState.get<Int>(DOMINANT_COLOR_KEY)
            color?.let {
                _dominantColor.value = Color(it)
            }

            val pokemonName = savedState.get<String>(POKEMON_NAME_KEY)?.lowercase()
            pokemonName?.let {
                loadPokemonInfo(pokemonName)
            }
        }
    }


    private fun loadPokemonInfo(pokemonName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val result = runCatching {
                repository.getPokemonInfo(pokemonName)
            }
            result.fold(
                onSuccess = { success ->
                    _pokemonInfo.value = success.getOrNull()
                    _isLoading.value = false
                },
                onFailure = { failure ->
                    _errorInfo.value = failure.message.toString()
                    _isLoading.value = false
                }
            )
        }
    }
}
