package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

data class Type(
    val slot: Int = 0,
    val type: Type = Type()
) {
    data class Type(
        val name: String = "",
        val url: String = ""
    )
}