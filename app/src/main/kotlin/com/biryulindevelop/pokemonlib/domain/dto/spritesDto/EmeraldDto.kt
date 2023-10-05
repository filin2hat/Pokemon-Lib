package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class EmeraldDto(
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = ""
)