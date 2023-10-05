package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class AbilityDto(
    val ability: AbilityNameDto = AbilityNameDto(),
    @SerializedName("is_hidden")
    val isHidden: Boolean = false,
    val slot: Int = 0
)