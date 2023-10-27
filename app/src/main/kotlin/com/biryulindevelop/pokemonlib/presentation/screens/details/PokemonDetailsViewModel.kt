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

    var pokemonInfo: MutableState<PokemonDto?> = mutableStateOf(null)
        private set
    var dominantColor: MutableState<Color?> = mutableStateOf(null)
        private set
    var errorInfo: MutableState<String?> = mutableStateOf(null)
        private set
    var isLoading: MutableState<Boolean> = mutableStateOf(false)
        private set

    init {
        viewModelScope.launch {
            val color = savedState.get<Int>(DOMINANT_COLOR_KEY)
            color?.let {
                dominantColor.value = Color(it)
            }

            val pokemonName = savedState.get<String>(POKEMON_NAME_KEY)?.lowercase()
            pokemonName?.let {
                loadPokemonInfo(pokemonName)
            }
        }
    }


    private fun loadPokemonInfo(pokemonName: String) {
        viewModelScope.launch {
            isLoading.value = true
            val result = runCatching {
                repository.getPokemonInfo(pokemonName)
            }
            result.fold(
                onSuccess = { success ->
                    pokemonInfo.value = success.getOrNull()
                    isLoading.value = false
                },
                onFailure = { failure ->
                    errorInfo.value = failure.message.toString()
                    isLoading.value = false
                }
            )
        }
    }
}
