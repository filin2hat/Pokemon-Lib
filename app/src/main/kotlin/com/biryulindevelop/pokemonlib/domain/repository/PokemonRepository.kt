package com.biryulindevelop.pokemonlib.domain.repository

import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto.PokemonListDto

interface PokemonRepository {

    suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDto>

    suspend fun getPokemonInfo(pokemonName: String): Result<PokemonDto>
}

