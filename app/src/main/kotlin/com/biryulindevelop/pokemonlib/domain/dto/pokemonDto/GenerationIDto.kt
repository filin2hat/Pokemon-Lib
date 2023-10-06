package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class GenerationIDto(
    @SerializedName("red-blue")
    val redBlue: RedBlueDto,
    @SerializedName("yellow")
    val yellow: YellowDto
)