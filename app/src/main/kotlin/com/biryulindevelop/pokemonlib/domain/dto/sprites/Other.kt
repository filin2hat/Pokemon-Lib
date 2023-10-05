package com.biryulindevelop.pokemonlib.domain.dto.sprites

import com.google.gson.annotations.SerializedName

data class Other(
    @SerializedName("dream_world")
    val dreamWorld: DreamWorld = DreamWorld(),
    val home: Home = Home(),
    @SerializedName("official-artwork")
    val officialArtwork: OfficialArtwork = OfficialArtwork()
)