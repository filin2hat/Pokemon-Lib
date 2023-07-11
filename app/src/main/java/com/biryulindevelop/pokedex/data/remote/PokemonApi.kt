package com.biryulindevelop.pokedex.data.remote

import com.biryulindevelop.pokedex.data.remote.responses.PokemonListModel
import com.biryulindevelop.pokedex.data.remote.responses.PokemonModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListModel

    @GET("pokemon/{pokemonName}")
    suspend fun getPokemonInfo(
        @Path("pokemonName") pokemonName: String
    ): PokemonModel
}