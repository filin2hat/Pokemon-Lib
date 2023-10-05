package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class Ability(
    val ability: Ability = Ability(),
    @SerializedName("is_hidden")
    val isHidden: Boolean = false,
    val slot: Int = 0
) {
    data class Ability(
        val name: String = "",
        val url: String = ""
    )
}