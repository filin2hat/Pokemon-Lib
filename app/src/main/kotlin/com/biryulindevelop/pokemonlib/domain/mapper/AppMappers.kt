package com.biryulindevelop.pokemonlib.domain.mapper

import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto.PokemonListDto
import com.biryulindevelop.pokemonlib.domain.model.PokemonItem
import com.biryulindevelop.pokemonlib.domain.model.PokemonListItem
import com.biryulindevelop.pokemonlib.util.getImageUrlFromNumber
import com.biryulindevelop.pokemonlib.util.getNumberFromUrl

fun PokemonDto.toItem(): PokemonItem {
    return PokemonItem(
        id = id,
        name = name,
        imageUrl = sprites.other.officialArtwork.frontDefault,
        type = types.map { it.type.name },
        height = height,
        weight = weight,
        stats = stats.map { it.stat.name }
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