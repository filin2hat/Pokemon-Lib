package com.biryulindevelop.pokemonlib.util

import android.content.Context
import androidx.compose.ui.graphics.Color
import com.biryulindevelop.pokemonlib.R
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.StatDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.TypeDto
import com.biryulindevelop.pokemonlib.domain.enums.PokemonStats
import com.biryulindevelop.pokemonlib.domain.enums.PokemonType
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
import com.biryulindevelop.pokemonlib.util.Constants.EMPTY_STRING

fun parseTypeToColor(type: TypeDto): Color {
    return when (type.type.name.lowercase()) {
        PokemonType.NORMAL.name.lowercase() -> TypeNormal
        PokemonType.FIRE.name.lowercase() -> TypeFire
        PokemonType.WATER.name.lowercase() -> TypeWater
        PokemonType.GRASS.name.lowercase() -> TypeGrass
        PokemonType.ELECTRIC.name.lowercase() -> TypeElectric
        PokemonType.ICE.name.lowercase() -> TypeIce
        PokemonType.FIGHTING.name.lowercase() -> TypeFighting
        PokemonType.POISON.name.lowercase() -> TypePoison
        PokemonType.GROUND.name.lowercase() -> TypeGround
        PokemonType.FLYING.name.lowercase() -> TypeFlying
        PokemonType.PSYCHIC.name.lowercase() -> TypePsychic
        PokemonType.BUG.name.lowercase() -> TypeBug
        PokemonType.ROCK.name.lowercase() -> TypeRock
        PokemonType.GHOST.name.lowercase() -> TypeGhost
        PokemonType.DRAGON.name.lowercase() -> TypeDragon
        PokemonType.DARK.name.lowercase() -> TypeDark
        PokemonType.STEEL.name.lowercase() -> TypeSteel
        PokemonType.FAIRY.name.lowercase() -> TypeFairy
        PokemonType.PRESSURE.name.lowercase() -> TypePressure
        else -> Color.Black
    }
}

fun changeTypeName(type: TypeDto, context: Context): String {
    return when (type.type.name.lowercase()) {
        PokemonType.NORMAL.name.lowercase() -> context.getString(R.string.normal)
        PokemonType.FIRE.name.lowercase() -> context.getString(R.string.fire)
        PokemonType.WATER.name.lowercase() -> context.getString(R.string.water)
        PokemonType.GRASS.name.lowercase() -> context.getString(R.string.grass)
        PokemonType.ELECTRIC.name.lowercase() -> context.getString(R.string.electric)
        PokemonType.ICE.name.lowercase() -> context.getString(R.string.ice)
        PokemonType.FIGHTING.name.lowercase() -> context.getString(R.string.fighting)
        PokemonType.POISON.name.lowercase() -> context.getString(R.string.poison)
        PokemonType.GROUND.name.lowercase() -> context.getString(R.string.ground)
        PokemonType.FLYING.name.lowercase() -> context.getString(R.string.flying)
        PokemonType.PSYCHIC.name.lowercase() -> context.getString(R.string.psychic)
        PokemonType.BUG.name.lowercase() -> context.getString(R.string.bug)
        PokemonType.ROCK.name.lowercase() -> context.getString(R.string.rock)
        PokemonType.GHOST.name.lowercase() -> context.getString(R.string.ghost)
        PokemonType.DRAGON.name.lowercase() -> context.getString(R.string.dragon)
        PokemonType.DARK.name.lowercase() -> context.getString(R.string.dark)
        PokemonType.STEEL.name.lowercase() -> context.getString(R.string.steel)
        PokemonType.FAIRY.name.lowercase() -> context.getString(R.string.fairy)
        PokemonType.PRESSURE.name.lowercase() -> context.getString(R.string.pressure)
        else -> EMPTY_STRING
    }
}

fun parseStatColor(stat: StatDto): Color {
    return when (stat.stat.name.lowercase()) {
        PokemonStats.HP.name.lowercase() -> HPColor
        PokemonStats.ATTACK.name.lowercase() -> AtkColor
        PokemonStats.DEFENSE.name.lowercase() -> DefColor
        PokemonStats.`SPECIAL-ATTACK`.name.lowercase() -> SpAtkColor
        PokemonStats.`SPECIAL-DEFENSE`.name.lowercase() -> SpDefColor
        PokemonStats.SPEED.name.lowercase() -> SpdColor
        else -> Color.White
    }
}

fun parseStatToAbbr(stat: StatDto, context: Context): String {
    return when (stat.stat.name.lowercase()) {
        PokemonStats.HP.name.lowercase() -> context.getString(R.string.hp)
        PokemonStats.ATTACK.name.lowercase() -> context.getString(R.string.atk)
        PokemonStats.DEFENSE.name.lowercase() -> context.getString(R.string.def)
        PokemonStats.`SPECIAL-ATTACK`.name.lowercase() -> context.getString(R.string.spatk)
        PokemonStats.`SPECIAL-DEFENSE`.name.lowercase() -> context.getString(R.string.spdef)
        PokemonStats.SPEED.name.lowercase() -> context.getString(R.string.spd)
        else -> EMPTY_STRING
    }
}