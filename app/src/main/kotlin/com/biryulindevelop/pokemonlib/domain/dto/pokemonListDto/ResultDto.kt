package com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto


import com.google.gson.annotations.SerializedName

data class ResultDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)