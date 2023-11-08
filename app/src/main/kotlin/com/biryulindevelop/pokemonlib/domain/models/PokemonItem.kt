package com.biryulindevelop.pokemonlib.domain.models

data class PokemonItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val types: List<TypeItem>,
    val height: Int,
    val weight: Int,
    val stats: List<StatsItem>
)
