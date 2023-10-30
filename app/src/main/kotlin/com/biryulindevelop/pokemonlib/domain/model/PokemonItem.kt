package com.biryulindevelop.pokemonlib.domain.model

data class PokemonItem(
    val id: Int,
    val name: String,
    val image: String,
    val weight: Int,
    val height: Int,
    val abilityTypes: List<String>,
    val stats: List<Int>
)