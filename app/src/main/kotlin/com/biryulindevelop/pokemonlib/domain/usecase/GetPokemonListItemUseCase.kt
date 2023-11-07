package com.biryulindevelop.pokemonlib.domain.usecase

import com.biryulindevelop.pokemonlib.domain.mapper.toItemList
import com.biryulindevelop.pokemonlib.domain.models.PokemonListItem
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import javax.inject.Inject

class GetPokemonListItemUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    suspend fun execute(limit: Int, offset: Int): List<PokemonListItem> {
        return repository
            .getPokemonList(limit, offset)
            .getOrThrow()
            .toItemList()
    }
}
