package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.biryulindevelop.pokemonlib.domain.dto.spritesDto.SpritesDto
import com.google.gson.annotations.SerializedName

data class PokemonDto(
    val abilities: List<AbilityDto> = listOf(),
    @SerializedName("base_experience")
    val baseExperience: Int = 0,
    val forms: List<FormDto> = listOf(),
    @SerializedName("game_indices")
    val gameIndices: List<GameIndiceDto> = listOf(),
    val height: Int = 0,
    @SerializedName("held_items")
    val heldItems: List<Any> = listOf(),
    val id: Int = 0,
    @SerializedName("is_default")
    val isDefault: Boolean = false,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String = "",
    val moves: List<MoveDto> = listOf(),
    val name: String = "",
    val order: Int = 0,
    @SerializedName("past_types")
    val pastTypes: List<Any> = listOf(),
    val species: SpeciesDto = SpeciesDto(),
    val sprites: SpritesDto = SpritesDto(),
    val stats: List<StatDto> = listOf(),
    val types: List<TypeDto> = listOf(),
    val weight: Int = 0
)