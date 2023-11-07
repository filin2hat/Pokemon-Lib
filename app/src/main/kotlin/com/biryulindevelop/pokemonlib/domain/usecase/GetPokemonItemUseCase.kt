package com.biryulindevelop.pokemonlib.domain.usecase

import com.biryulindevelop.pokemonlib.domain.mapper.toItem
import com.biryulindevelop.pokemonlib.domain.models.PokemonItem
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonItemUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend fun execute(pokemonName: String): PokemonItem {
        return repository
            .getPokemonInfo(pokemonName)
            .getOrThrow()
            .toItem()
    }
}
