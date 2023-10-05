package com.biryulindevelop.pokemonlib.data.repository

import com.biryulindevelop.pokemonlib.data.remote.PokemonApi
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonList.PokemonListDto
import com.biryulindevelop.pokemonlib.util.Resource
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