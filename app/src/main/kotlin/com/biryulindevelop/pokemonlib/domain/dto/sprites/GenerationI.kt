package com.biryulindevelop.pokemonlib.domain.dto.sprites

import com.google.gson.annotations.SerializedName

data class GenerationI(
    @SerializedName("red-blue")
    val redBlue: RedBlue = RedBlue(),
    val yellow: Yellow = Yellow()
)