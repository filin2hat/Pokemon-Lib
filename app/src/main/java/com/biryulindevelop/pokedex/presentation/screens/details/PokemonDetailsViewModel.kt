package com.biryulindevelop.pokedex.presentation.screens.details

import androidx.lifecycle.ViewModel
import com.biryulindevelop.pokedex.data.repository.PokemonRepository
import com.biryulindevelop.pokedex.domain.dto.PokemonDto
import com.biryulindevelop.pokedex.util.Resource
import javax.inject.Inject

class PokemonDetailsViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDto> {
        return repository.getPokemonInfo(pokemonName)
    }
}
