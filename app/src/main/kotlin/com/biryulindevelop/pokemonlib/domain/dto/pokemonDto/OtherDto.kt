package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class OtherDto(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorldDto,
    @SerializedName("home")
    val home: HomeDto,
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtworkDto
)