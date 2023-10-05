package com.biryulindevelop.pokemonlib.util

import androidx.compose.ui.graphics.Color
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.StatDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.TypeDto
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
import com.biryulindevelop.pokemonlib.ui.theme.TypePressure
import com.biryulindevelop.pokemonlib.ui.theme.TypePsychic
import com.biryulindevelop.pokemonlib.ui.theme.TypeRock
import com.biryulindevelop.pokemonlib.ui.theme.TypeSteel
import com.biryulindevelop.pokemonlib.ui.theme.TypeWater

fun parseTypeToColor(type: TypeDto): Color {
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
        "pressure" -> TypePressure
        else -> Color.Black
    }
}

fun changeTypeEngToRus(type: TypeDto): String {
    return when (type.type.name.lowercase()) {
        "normal" -> "Физический"
        "fire" -> "Огненный"
        "water" -> "Водный"
        "grass" -> "Растение"
        "electric" -> "Электрический"
        "ice" -> "Ледяной"
        "fighting" -> "Боец"
        "poison" -> "Ядовитый"
        "ground" -> "Земляной"
        "flying" -> "Летающий"
        "psychic" -> "Психо"
        "bug" -> "Жук"
        "rock" -> "Каменный"
        "ghost" -> "Призрак"
        "dragon" -> "Дракон"
        "dark" -> "Тьма"
        "steel" -> "Стальной"
        "fairy" -> "Фея"
        "pressure" -> "Давление"
        else -> "Неизвестный"
    }
}

fun parseStatColor(stat: StatDto): Color {
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

fun parseStatToAbbr(stat: StatDto): String {
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