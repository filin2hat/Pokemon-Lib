package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class OtherDto(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorldDto = DreamWorldDto(),
    val home: HomeDto = HomeDto(),
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtworkDto = OfficialArtworkDto()
)