package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class GenerationIDto(
    @SerializedName("red-blue")
    val redBlue: RedBlueDto = RedBlueDto(),
    val yellow: YellowDto = YellowDto()
)