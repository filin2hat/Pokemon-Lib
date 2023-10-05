package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class GenerationViiDto(
    val icons: IconsDto = IconsDto(),
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoonDto = UltraSunUltraMoonDto()
)