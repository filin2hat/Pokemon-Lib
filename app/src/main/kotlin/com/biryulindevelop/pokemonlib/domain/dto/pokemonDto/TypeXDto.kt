package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class TypeXDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)