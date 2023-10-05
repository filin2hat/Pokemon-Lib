package com.biryulindevelop.pokemonlib.domain.dto.sprites

import com.google.gson.annotations.SerializedName

data class GenerationIv(
    @SerializedName("diamond-pearl")
    val diamondPearl: DiamondPearl = DiamondPearl(),
    @SerializedName("heartgold-soulsilver")
    val heartgoldSoulsilver: HeartgoldSoulsilver = HeartgoldSoulsilver(),
    val platinum: Platinum = Platinum()
)