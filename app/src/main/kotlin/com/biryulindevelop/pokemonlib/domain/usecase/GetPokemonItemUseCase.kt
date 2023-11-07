package com.biryulindevelop.pokemonlib.domain.usecase

import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.mapper.toItem

class GetPokemonItemUseCase {
    fun execute(pokemonDto: PokemonDto) = pokemonDto.toItem()
}
