package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class GenerationIiiDto(
    val emerald: EmeraldDto = EmeraldDto(),
    @SerializedName("firered-leafgreen")
    val fireredLeafgreen: FireredLeafgreenDto = FireredLeafgreenDto(),
    @SerializedName("ruby-sapphire")
    val rubySapphire: RubySapphireDto = RubySapphireDto()
)