package com.biryulindevelop.pokedex.data.remote

import com.biryulindevelop.pokedex.domain.dto.PokemonListDto
import com.biryulindevelop.pokedex.domain.dto.PokemonDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListDto

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonInfo(
        @Path("pokemonName") pokemonName: String
    ): PokemonDto
}