package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class GameIndice(
    @SerializedName("game_index")
    val gameIndex: Int = 0,
    val version: Version = Version()
)