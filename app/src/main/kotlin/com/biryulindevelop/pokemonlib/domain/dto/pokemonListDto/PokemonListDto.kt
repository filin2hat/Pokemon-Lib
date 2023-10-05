package com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto


data class PokemonListDto(
    val count: Int = 0,
    val next: String = "",
    val previous: Any = Any(),
    val results: List<ResultDto> = listOf()
)