package com.biryulindevelop.pokemonlib.presentation.screens.list

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.biryulindevelop.pokemonlib.domain.models.PokemonListItem
import com.biryulindevelop.pokemonlib.domain.usecase.GetPokemonListItemUseCase
import com.biryulindevelop.pokemonlib.util.Constants.EMPTY_STRING
import com.biryulindevelop.pokemonlib.util.Constants.PAGE_SIZE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListItemUseCase: GetPokemonListItemUseCase
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
                getPokemonListItemUseCase.execute(
                    limit = PAGE_SIZE,
                    offset = currentPage * PAGE_SIZE
                )
            }

            result.fold(
                onSuccess = { loadedList ->
                    currentPage++
                    loadError = EMPTY_STRING
                    isLoading = false
                    pokemonList += loadedList
                },
                onFailure = { error ->
                    loadError = error.message.orEmpty()
                    isLoading = false
                }
            )
        }
    }
}
