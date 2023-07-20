package com.biryulindevelop.pokemonlib.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.biryulindevelop.pokemonlib.R


val PoketMonk = FontFamily(
    Font(R.font.pocket_monk, FontWeight.Normal),
)

val PokemonHollow = FontFamily(
    Font(R.font.pokemon_hollow, FontWeight.Normal),
)
val PokemonSolid = FontFamily(
    Font(R.font.pokemon_solid, FontWeight.Normal),
)
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = PoketMonk,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)