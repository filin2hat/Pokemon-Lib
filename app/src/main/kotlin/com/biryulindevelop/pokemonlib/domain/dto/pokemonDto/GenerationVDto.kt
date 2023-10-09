package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class GenerationVDto(
    @SerializedName("black-white")
    val blackWhite: BlackWhiteDto
)