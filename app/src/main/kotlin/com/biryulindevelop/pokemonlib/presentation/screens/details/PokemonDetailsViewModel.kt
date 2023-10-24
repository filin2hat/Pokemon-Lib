package com.biryulindevelop.pokemonlib.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.util.Constants.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private var _pokemonInfo: MutableState<PokemonDto?> = mutableStateOf(null)
    val pokemonInfo: MutableState<PokemonDto?> = _pokemonInfo

    private var _errorInfo: MutableState<String?> = mutableStateOf(null)
    val errorInfo: MutableState<String?> = _errorInfo

    private var _isLoading: MutableState<Boolean> = mutableStateOf(false)
    val isLoading: MutableState<Boolean> = _isLoading


    fun loadPokemonInfo(pokemonName: String) {
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
