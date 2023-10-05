package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class Stat(
    @SerializedName("base_stat")
    val baseStat: Int = 0,
    val effort: Int = 0,
    val stat: StatName = StatName()
)