package com.biryulindevelop.pokemonlib.util

import androidx.compose.ui.graphics.Color
import com.biryulindevelop.pokemonlib.domain.dto.PokemonDto
import com.biryulindevelop.pokemonlib.ui.theme.AtkColor
import com.biryulindevelop.pokemonlib.ui.theme.DefColor
import com.biryulindevelop.pokemonlib.ui.theme.HPColor
import com.biryulindevelop.pokemonlib.ui.theme.SpAtkColor
import com.biryulindevelop.pokemonlib.ui.theme.SpDefColor
import com.biryulindevelop.pokemonlib.ui.theme.SpdColor
import com.biryulindevelop.pokemonlib.ui.theme.TypeBug
import com.biryulindevelop.pokemonlib.ui.theme.TypeDark
import com.biryulindevelop.pokemonlib.ui.theme.TypeDragon
import com.biryulindevelop.pokemonlib.ui.theme.TypeElectric
import com.biryulindevelop.pokemonlib.ui.theme.TypeFairy
import com.biryulindevelop.pokemonlib.ui.theme.TypeFighting
import com.biryulindevelop.pokemonlib.ui.theme.TypeFire
import com.biryulindevelop.pokemonlib.ui.theme.TypeFlying
import com.biryulindevelop.pokemonlib.ui.theme.TypeGhost
import com.biryulindevelop.pokemonlib.ui.theme.TypeGrass
import com.biryulindevelop.pokemonlib.ui.theme.TypeGround
import com.biryulindevelop.pokemonlib.ui.theme.TypeIce
import com.biryulindevelop.pokemonlib.ui.theme.TypeNormal
import com.biryulindevelop.pokemonlib.ui.theme.TypePoison
import com.biryulindevelop.pokemonlib.ui.theme.TypePsychic
import com.biryulindevelop.pokemonlib.ui.theme.TypeRock
import com.biryulindevelop.pokemonlib.ui.theme.TypeSteel
import com.biryulindevelop.pokemonlib.ui.theme.TypeWater

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
fun changeTypeEngToRus(type: PokemonDto.Type): String {
    return when (type.type.name.lowercase()) {
        "normal" -> "Обычный"
        "fire" -> "Огненный"
        "water" -> "Водяной"
        "grass" -> "Растение"
        "electric" -> "Электрический"
        "ice" -> "Ледяной"
        "fighting" -> "Боец"
        "poison" -> "Ядовитый"
        "ground" -> "Земля"
        "flying" -> "Летающий"
        "psychic" -> "Психо"
        "bug" -> "Жук"
        "rock" -> "Каменный"
        "ghost" -> "Призрак"
        "dragon" -> "Дракон"
        "dark" -> "Тьма"
        "steel" -> "Стальной"
        "fairy" -> "Фея"
        else -> "Не известный"
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