package com.biryulindevelop.pokemonlib.util

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette

fun getImageUrlFromNumber(number: Int): String {
    return "https://raw.githubusercontent" +
            ".com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$number.png"
}

fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit) {
    val bmp = (drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true)
    Palette.from(bmp).generate { palette ->
        palette?.dominantSwatch?.rgb?.let { colorValue ->
            onFinish(Color(colorValue))
        }
    }
}

fun String.getNumberFromUrl(): Int {
    val numberString = if (endsWith("/")) {
        dropLast(1).takeLastWhile { it.isDigit() }
    } else {
        takeLastWhile { it.isDigit() }
    }
    return numberString.toInt()
}