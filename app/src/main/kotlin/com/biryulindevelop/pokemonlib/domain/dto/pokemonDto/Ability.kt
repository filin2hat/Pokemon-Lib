package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class Ability(
    val ability: AbilityName = AbilityName(),
    @SerializedName("is_hidden")
    val isHidden: Boolean = false,
    val slot: Int = 0
)