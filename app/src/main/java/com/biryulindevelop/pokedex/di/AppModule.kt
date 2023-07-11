package com.biryulindevelop.pokedex.di

import com.biryulindevelop.pokedex.data.remote.PokemonApi
import com.biryulindevelop.pokedex.repository.PokemonRepository
import com.biryulindevelop.pokedex.util.Constants
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