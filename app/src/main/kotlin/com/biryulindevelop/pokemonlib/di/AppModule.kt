package com.biryulindevelop.pokemonlib.di

import com.biryulindevelop.pokemonlib.data.remote.PokemonApi
import com.biryulindevelop.pokemonlib.data.repository.PokemonRepository
import com.biryulindevelop.pokemonlib.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providePokemonRepository(api: PokemonApi): PokemonRepository {
        return PokemonRepository(api)
    }

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