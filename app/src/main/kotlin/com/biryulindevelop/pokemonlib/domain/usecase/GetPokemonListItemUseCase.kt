package com.biryulindevelop.pokemonlib.domain.usecase

import com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto.PokemonListDto
import com.biryulindevelop.pokemonlib.domain.mapper.toItemList

class GetPokemonListItemUseCase {
    fun execute(pokemonListDto: PokemonListDto) = pokemonListDto.toItemList()
}
