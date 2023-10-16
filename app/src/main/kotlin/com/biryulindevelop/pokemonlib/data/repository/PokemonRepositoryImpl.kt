package com.biryulindevelop.pokemonlib.data.repository

import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonListDto.PokemonListDto
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
) : PokemonRepository {

    override suspend fun getPokemonList(limit: Int, offset: Int): Result<PokemonListDto> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPokemonList(limit, offset)
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }

    override suspend fun getPokemonInfo(pokemonName: String): Result<PokemonDto> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.getPokemonInfo(pokemonName)
                Result.success(response)
            } catch (e: Exception) {
                Result.failure(e)
            }
        }
    }
}