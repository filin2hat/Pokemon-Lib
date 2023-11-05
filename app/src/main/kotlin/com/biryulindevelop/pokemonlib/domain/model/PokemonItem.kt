package com.biryulindevelop.pokemonlib.domain.model

data class PokemonItem(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val type: List<String>,
    val height: Int,
    val weight: Int,
    val stats: List<String>
)
