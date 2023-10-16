package com.biryulindevelop.pokemonlib.presentation.screens.list

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.biryulindevelop.pokemonlib.domain.model.PokemonListEntry
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.util.Constants.PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private var currentPage = 0

    var pokemonList by mutableStateOf<List<PokemonListEntry>>(emptyList())
        private set
    var loadError by mutableStateOf("")
        private set
    var isLoading by mutableStateOf(false)

    private var cachedPokemonList = listOf<PokemonListEntry>()
    private var isSearchStarting = true
    var isSearching by mutableStateOf(false)
        private set

    init {
        loadPokemonPaged()
    }

    fun searchPokemon(query: String) {
        val listToSearch = if (isSearchStarting) {
            pokemonList
        } else {
            cachedPokemonList
        }
        viewModelScope.launch {
            if (query.isEmpty()) {
                pokemonList = cachedPokemonList
                isSearching = false
                isSearchStarting = true
                return@launch
            }
            val results = listToSearch.filter {
                it.pokemonName.contains(
                    query.trim(),
                    ignoreCase = true
                ) || it.id.toString() == query.trim()
            }
            if (isSearchStarting) {
                cachedPokemonList = pokemonList
                isSearchStarting = false
            }
            pokemonList = results
            isSearching = true
        }
    }

    fun loadPokemonPaged() {
        viewModelScope.launch {
            isLoading = true
            val result = runCatching {
                repository.getPokemonList(PAGE_SIZE, currentPage * PAGE_SIZE)
            }
            result.onSuccess { response ->
                val pokemonEntries: List<PokemonListEntry?> =
                    response.getOrNull()?.results?.map { entry ->
                        try {
                            val number = entry.url.getNumberFromUrl()
                            val imageUrl = getImageUrlFromNumber(number)
                            PokemonListEntry(
                                pokemonName = entry.name.replaceFirstChar { it.uppercase() },
                                imageUrl = imageUrl,
                                id = number
                            )
                        } catch (e: Exception) {
                            null
                        }
                    } ?: emptyList()

                pokemonEntries.filterNotNull().let {
                    currentPage++
                    loadError = ""
                    isLoading = false
                    pokemonList += it
                }
            }

            result.onFailure { error ->
                loadError = error.message.orEmpty()
                isLoading = false
            }
        }
    }

    private fun String.getNumberFromUrl(): Int {
        val numberString = if (endsWith("/")) {
            dropLast(1).takeLastWhile { it.isDigit() }
        } else {
            takeLastWhile { it.isDigit() }
        }
        return numberString.toInt()
    }

    private fun getImageUrlFromNumber(number: Int): String {
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
}