package com.biryulindevelop.pokemonlib.presentation.screens.list

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.palette.graphics.Palette
import com.biryulindevelop.pokemonlib.data.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.domain.model.PokemonLibListEntry
import com.biryulindevelop.pokemonlib.util.Constants.PAGE_SIZE
import com.biryulindevelop.pokemonlib.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private var currentPage = 0

    var pokemonList = mutableStateOf<List<PokemonLibListEntry>>(listOf())
    var loadError = mutableStateOf("")
    var isLoading = mutableStateOf(false)
    var endReached = mutableStateOf(false)

    private var cachedPokemonList = listOf<PokemonLibListEntry>()
    private var isSearchStarting = true
    var isSearching = mutableStateOf(false)

    init {
        loadPokemonPaged()
    }

    fun searchPokemon(query: String) {
        val listToSearch = if (isSearchStarting) {
            pokemonList.value
        } else {
            cachedPokemonList
        }
        viewModelScope.launch(Dispatchers.Default) {
            if (query.isEmpty()) {
                pokemonList.value = cachedPokemonList
                isSearching.value = false
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
                cachedPokemonList = pokemonList.value
                isSearchStarting = false
            }
            pokemonList.value = results
            isSearching.value = true

        }
    }


    fun loadPokemonPaged() {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = repository.getPokemonList(PAGE_SIZE, currentPage * PAGE_SIZE)) {
                is Resource.Success -> {
                    endReached.value = currentPage * PAGE_SIZE >= result.data!!.count
                    val pokemonEntries = result.data.results.mapNotNull { entry ->
                        try {
                            val number = entry.url.getNumberFromUrl()
                            val imageUrl = entry.url.getImageUrlFromNumber(number)
                            PokemonLibListEntry(
                                entry.name.replaceFirstChar { it.uppercase() },
                                imageUrl,
                                number
                            )
                        } catch (e: Exception) {
                            null
                        }
                    }
                    currentPage++
                    loadError.value = ""
                    isLoading.value = false
                    pokemonList.value += pokemonEntries
                }

                is Resource.Error -> {
                    loadError.value = result.message!!
                    isLoading.value = false
                }

                is Resource.Loading -> {
                    isLoading.value = true
                }
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

    private fun String.getImageUrlFromNumber(number: Int): String {
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