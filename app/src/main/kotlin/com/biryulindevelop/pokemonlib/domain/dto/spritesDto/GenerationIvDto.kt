package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class GenerationIvDto(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearlDto = DiamondPearlDto(),
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilverDto = HeartgoldSoulsilverDto(),
    val platinum: PlatinumDto = PlatinumDto()
)