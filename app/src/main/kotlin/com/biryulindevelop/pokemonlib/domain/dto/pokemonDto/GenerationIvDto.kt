package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class GenerationIvDto(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearlDto,
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilverDto,
    @SerializedName("platinum")
    val platinum: PlatinumDto
)