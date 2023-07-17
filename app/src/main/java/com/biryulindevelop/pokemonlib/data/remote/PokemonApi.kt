package com.biryulindevelop.pokemonlib.data.remote

import com.biryulindevelop.pokemonlib.domain.dto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.PokemonListDto
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