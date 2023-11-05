package com.biryulindevelop.pokemonlib.domain.mapper

import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto.PokemonListDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto.ResultDto
import com.biryulindevelop.pokemonlib.domain.model.PokemonItem
import com.biryulindevelop.pokemonlib.domain.model.PokemonListItem
import com.biryulindevelop.pokemonlib.util.getImageUrlFromNumber
import com.biryulindevelop.pokemonlib.util.getNumberFromUrl

object PokemonMapper {
    private fun mapPokemonDtoToPokemonItem(dto: PokemonDto): PokemonItem {
        return PokemonItem(
            id = dto.id,
            name = dto.name,
            imageUrl = dto.sprites.other.officialArtwork.frontDefault,
            type = dto.types.map { it.type.name },
            height = dto.height,
            weight = dto.weight,
            stats = dto.stats.map { it.stat.name }
        )
    }

    private fun mapPokemonListDtoToPokemonItem(dto: ResultDto): PokemonListItem {
        val id = dto.url.getNumberFromUrl()
        val imageUrl = getImageUrlFromNumber(id)
        return PokemonListItem(
            pokemonName = dto.name.replaceFirstChar { it.uppercase() },
            imageUrl = imageUrl,
            id = id
        )
    }

    fun PokemonDto.toItem() = mapPokemonDtoToPokemonItem(this)

    fun PokemonListDto.toItemList() = results.map { mapPokemonListDtoToPokemonItem(it) }
}