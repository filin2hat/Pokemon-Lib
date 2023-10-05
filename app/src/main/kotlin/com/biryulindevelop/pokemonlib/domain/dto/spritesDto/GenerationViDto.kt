package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class GenerationViDto(
    @SerializedName("omegaruby-alphasapphire")
    val omegarubyAlphasapphire: OmegarubyAlphasapphireDto = OmegarubyAlphasapphireDto(),
    @SerializedName("x-y")
    val xY: XyDto = XyDto()
)