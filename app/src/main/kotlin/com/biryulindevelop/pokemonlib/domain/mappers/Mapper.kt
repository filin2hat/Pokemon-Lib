package com.biryulindevelop.pokemonlib.domain.mappers

import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.model.PokemonItem

object Mapper {
    fun dtoToItem(dto: PokemonDto): PokemonItem {
        return PokemonItem(
            id = dto.id,
            name = dto.name,
            image = dto.sprites.other.officialArtwork.frontDefault,
            weight = dto.weight,
            height = dto.height,
            abilityTypes = dto.types.map { type ->
                type.type.name
            },
            stats = dto.stats.map { stat ->
                stat.baseStat
            }
        )
    }
}
