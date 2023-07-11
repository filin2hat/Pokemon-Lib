package com.biryulindevelop.pokedex.data.repository

import com.biryulindevelop.pokedex.data.remote.PokemonApi
import com.biryulindevelop.pokedex.domain.dto.PokemonListDto
import com.biryulindevelop.pokedex.domain.dto.PokemonDto
import com.biryulindevelop.pokedex.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class PokemonRepository @Inject constructor(
    private val api: PokemonApi
) {

    suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonListDto> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "An unknown error occurred")
        }
        return Resource.Success(response)
    }

    suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDto> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "An unknown error occurred")
        }
        return Resource.Success(response)
    }
}