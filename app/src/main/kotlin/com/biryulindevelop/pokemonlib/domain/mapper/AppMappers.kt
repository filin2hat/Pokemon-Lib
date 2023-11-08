package com.biryulindevelop.pokemonlib.domain.mapper

import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto.PokemonListDto
import com.biryulindevelop.pokemonlib.domain.models.PokemonItem
import com.biryulindevelop.pokemonlib.domain.models.PokemonListItem
import com.biryulindevelop.pokemonlib.domain.models.StatXItem
import com.biryulindevelop.pokemonlib.domain.models.StatsItem
import com.biryulindevelop.pokemonlib.domain.models.TypeItem
import com.biryulindevelop.pokemonlib.util.getImageUrlFromNumber
import com.biryulindevelop.pokemonlib.util.getNumberFromUrl

fun PokemonDto.toItem(): PokemonItem {
    return PokemonItem(
        id = id,
        name = name,
        imageUrl = sprites.other.officialArtwork.frontDefault,
        types = types.map { type ->
            TypeItem(
                slot = type.slot,
                name = type.type.name
            )
        },
        height = height,
        weight = weight,
        stats = stats.map { stat ->
            StatsItem(
                baseStat = stat.baseStat,
                stat = StatXItem(stat.stat.name)
            )
        }
    )
}

fun PokemonListDto.toItemList(): List<PokemonListItem> {
    return results.map { dto ->
        val id = dto.url.getNumberFromUrl()
        val imageUrl = getImageUrlFromNumber(id)
        PokemonListItem(
            pokemonName = dto.name.replaceFirstChar { it.uppercase() },
            imageUrl = imageUrl,
            id = id
        )
    }
}
