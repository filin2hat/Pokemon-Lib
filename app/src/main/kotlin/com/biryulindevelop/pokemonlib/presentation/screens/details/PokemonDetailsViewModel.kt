package com.biryulindevelop.pokemonlib.presentation.screens.details

import androidx.lifecycle.ViewModel
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Result<PokemonDto> {
        return repository.getPokemonInfo(pokemonName)
    }
}
