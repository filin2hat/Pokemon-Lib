package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class FireredLeafgreenDto(
    @SerializedName("back_default")
    val backDefault: String = "",
    @SerializedName("back_shiny")
    val backShiny: String = "",
    @SerializedName("front_default")
    val frontDefault: String = "",
    @SerializedName("front_shiny")
    val frontShiny: String = ""
)