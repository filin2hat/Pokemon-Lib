package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.biryulindevelop.pokemonlib.domain.dto.sprites.Sprites
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    val abilities: List<Ability> = listOf(),
    @SerializedName("base_experience")
    val baseExperience: Int = 0,
    val forms: List<Form> = listOf(),
    @SerializedName("game_indices")
    val gameIndices: List<GameIndice> = listOf(),
    val height: Int = 0,
    @SerializedName("held_items")
    val heldItems: List<Any> = listOf(),
    val id: Int = 0,
    @SerializedName("is_default")
    val isDefault: Boolean = false,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String = "",
    val moves: List<Move> = listOf(),
    val name: String = "",
    val order: Int = 0,
    @SerializedName("past_types")
    val pastTypes: List<Any> = listOf(),
    val species: Species = Species(),
    val sprites: Sprites = Sprites(),
    val stats: List<Stat> = listOf(),
    val types: List<Type> = listOf(),
    val weight: Int = 0
)