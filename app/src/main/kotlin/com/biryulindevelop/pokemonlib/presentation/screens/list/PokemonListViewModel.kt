package com.biryulindevelop.pokemonlib.presentation.screens.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biryulindevelop.pokemonlib.domain.model.PokemonListItem
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.util.Constants.EMPTY_STRING
import com.biryulindevelop.pokemonlib.util.Constants.PAGE_SIZE
import com.biryulindevelop.pokemonlib.util.getImageUrlFromNumber
import com.biryulindevelop.pokemonlib.util.getNumberFromUrl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val repository: PokemonRepository
) : ViewModel() {

    private var currentPage = 0

    var pokemonList by mutableStateOf<List<PokemonListItem>>(emptyList())
        private set
    var loadError by mutableStateOf(EMPTY_STRING)
        private set
    var isLoading by mutableStateOf(false)
        private set
    var isSearching by mutableStateOf(false)
        private set

    private var cachedPokemonList = listOf<PokemonListItem>()

    private var isSearchStarting = true

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

            result.fold(
                onSuccess = { response ->
                    val pokemonEntries: List<PokemonListItem?> =
                        response.getOrNull()?.results?.map { entry ->
                            try {
                                val number = entry.url.getNumberFromUrl()
                                val imageUrl = getImageUrlFromNumber(number)
                                PokemonListItem(
                                    pokemonName = entry.name.replaceFirstChar { it.uppercase() },
                                    imageUrl = imageUrl,
                                    id = number
                                )
                            } catch (e: Exception) {
                                null
                            }
                        } ?: emptyList()

                    pokemonEntries.filterNotNull().let { loadedList ->
                        currentPage++
                        loadError = EMPTY_STRING
                        isLoading = false
                        pokemonList += loadedList
                    }
                },
                onFailure = { error ->
                    loadError = error.message.orEmpty()
                    isLoading = false
                }
            )
        }
    }
}
