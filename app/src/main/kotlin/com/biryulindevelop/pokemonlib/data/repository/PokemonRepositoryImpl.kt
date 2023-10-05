package com.biryulindevelop.pokemonlib.data.repository

import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto.PokemonListDto
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.util.Resource
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
) : PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Resource<PokemonListDto> {
        val response = try {
            api.getPokemonList(limit, offset)
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "An unknown error occurred")
        }
        return Resource.Success(response)
    }

    override suspend fun getPokemonInfo(pokemonName: String): Resource<PokemonDto> {
        val response = try {
            api.getPokemonInfo(pokemonName)
        } catch (e: Exception) {
            return Resource.Error(e.message ?: "An unknown error occurred")
        }
        return Resource.Success(response)
    }
}