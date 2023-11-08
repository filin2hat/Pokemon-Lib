package com.biryulindevelop.pokemonlib.domain.models


data class StatsItem(
    val baseStat: Int,
    val stat: StatXItem
)

data class StatXItem(
    val name: String
)
