package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

data class GenerationIiDto(
    val crystal: CrystalDto = CrystalDto(),
    val gold: GoldDto = GoldDto(),
    val silver: SilverDto = SilverDto()
)