package com.biryulindevelop.pokemonlib.presentation.screens.details

import androidx.lifecycle.ViewModel
import com.biryulindevelop.pokemonlib.data.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDto> {
        return repository.getPokemonInfo(pokemonName)
    }
}
