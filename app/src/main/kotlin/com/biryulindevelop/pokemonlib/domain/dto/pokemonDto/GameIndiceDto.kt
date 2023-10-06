package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class GameIndiceDto(
    @SerializedName("game_index")
    val gameIndex: Int,
    @SerializedName("version")
    val version: VersionDto
)