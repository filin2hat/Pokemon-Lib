package com.biryulindevelop.pokedex.util

import androidx.compose.ui.graphics.Color
import com.biryulindevelop.pokedex.domain.dto.PokemonDto
import com.biryulindevelop.pokedex.ui.theme.AtkColor
import com.biryulindevelop.pokedex.ui.theme.DefColor
import com.biryulindevelop.pokedex.ui.theme.HPColor
import com.biryulindevelop.pokedex.ui.theme.SpAtkColor
import com.biryulindevelop.pokedex.ui.theme.SpDefColor
import com.biryulindevelop.pokedex.ui.theme.SpdColor
import com.biryulindevelop.pokedex.ui.theme.TypeBug
import com.biryulindevelop.pokedex.ui.theme.TypeDark
import com.biryulindevelop.pokedex.ui.theme.TypeDragon
import com.biryulindevelop.pokedex.ui.theme.TypeElectric
import com.biryulindevelop.pokedex.ui.theme.TypeFairy
import com.biryulindevelop.pokedex.ui.theme.TypeFighting
import com.biryulindevelop.pokedex.ui.theme.TypeFire
import com.biryulindevelop.pokedex.ui.theme.TypeFlying
import com.biryulindevelop.pokedex.ui.theme.TypeGhost
import com.biryulindevelop.pokedex.ui.theme.TypeGrass
import com.biryulindevelop.pokedex.ui.theme.TypeGround
import com.biryulindevelop.pokedex.ui.theme.TypeIce
import com.biryulindevelop.pokedex.ui.theme.TypeNormal
import com.biryulindevelop.pokedex.ui.theme.TypePoison
import com.biryulindevelop.pokedex.ui.theme.TypePsychic
import com.biryulindevelop.pokedex.ui.theme.TypeRock
import com.biryulindevelop.pokedex.ui.theme.TypeSteel
import com.biryulindevelop.pokedex.ui.theme.TypeWater

fun parseTypeToColor(type: PokemonDto.Type): Color {
    return when (type.type.name.lowercase()) {
        "normal" -> TypeNormal
        "fire" -> TypeFire
        "water" -> TypeWater
        "grass" -> TypeGrass
        "electric" -> TypeElectric
        "ice" -> TypeIce
        "fighting" -> TypeFighting
        "poison" -> TypePoison
        "ground" -> TypeGround
        "flying" -> TypeFlying
        "psychic" -> TypePsychic
        "bug" -> TypeBug
        "rock" -> TypeRock
        "ghost" -> TypeGhost
        "dragon" -> TypeDragon
        "dark" -> TypeDark
        "steel" -> TypeSteel
        "fairy" -> TypeFairy
        else -> Color.Black
    }
}

fun parseStatColor(stat: PokemonDto.Stat): Color {
    return when (stat.stat.name.lowercase()) {
        "hp" -> HPColor
        "attack" -> AtkColor
        "defense" -> DefColor
        "special-attack" -> SpAtkColor
        "special-defense" -> SpDefColor
        "speed" -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: PokemonDto.Stat): String {
    return when (stat.stat.name.lowercase()) {
        "hp" -> "HP"
        "attack" -> "Atk"
        "defense" -> "Def"
        "special-attack" -> "SpAtk"
        "special-defense" -> "SpDef"
        "speed" -> "Spd"
        else -> ""
    }
}