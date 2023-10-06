package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class VersionDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)