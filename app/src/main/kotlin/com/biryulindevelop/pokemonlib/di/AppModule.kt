package com.biryulindevelop.pokemonlib.di

import com.biryulindevelop.pokemonlib.data.repository.PokemonApi
import com.biryulindevelop.pokemonlib.data.repository.PokemonRepositoryImpl
import com.biryulindevelop.pokemonlib.domain.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.util.Constants
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Singleton
    @Binds
    fun bindPokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository

}

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokeApi(): PokemonApi {
        return Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constants.BASE_URL)
            .build()
            .create(PokemonApi::class.java)
    }

}
