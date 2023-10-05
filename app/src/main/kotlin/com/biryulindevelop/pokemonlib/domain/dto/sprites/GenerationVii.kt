package com.biryulindevelop.pokemonlib.domain.dto.sprites

import com.google.gson.annotations.SerializedName

data class GenerationVii(
    val icons: Icons = Icons(),
    @SerializedName("ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon = UltraSunUltraMoon()
)