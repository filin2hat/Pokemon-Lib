package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class TypeDto(
    @SerializedName("slot")
    val slot: Int,
    @SerializedName("type")
    val type: TypeXDto
)