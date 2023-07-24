<h1 align="center">PokemonLib</h1>

<p align="center">
PokemonLib is a project designed for Pokemon fans that provides information about various Pokemon. 
This app uses Jetpack Compose, a declarative framework for building user interfaces in Android. 
With PokemonLib, you can explore the world of Pokemon, learn about their characteristics, abilities, types, and more.
</p>

## Main functions:

- View a list of Pokémon with the ability to search.
- Detailed information about each pokemon, including image, properties and main parameters.
- Support for dark and light themes for comfortable use at any time of the day.
- Using animations and effects to improve the user experience.
- Application of modern technologies such as Kotlin, Jetpack Compose and Android Architecture
  Components.

## Screenshots

<img src="https://github.com/filin2hat/Pokemon-Lib/assets/94535311/7e4a0305-7b93-4979-adad-8da0fe178d37" align="center" width="21%"/>
<img src="https://github.com/filin2hat/Pokemon-Lib/assets/94535311/8ff1da3d-57e0-4ed9-ac72-6743f962733b" align="center" width="21%"/>
<img src="https://github.com/filin2hat/Pokemon-Lib/assets/94535311/9234ccbb-4017-41f8-a68d-ef986c6515af" align="center" width="21%"/>
<img src="https://github.com/filin2hat/Pokemon-Lib/assets/94535311/4efcf3f9-bdf2-4f5d-89f2-f73f8c836b52" align="center" width="21%"/>

## Tech stack & Open-source libraries

- Minimum SDK level 26
- [Kotlin](https://kotlinlang.org/)
  based, [Coroutines](https://github.com/Kotlin/kotlinx.coroutines)
    + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/)
      for asynchronous.
- Jetpack
    - [Compose](https://developer.android.com/jetpack/compose) for building modern user interfaces.
    - ViewModel: Manages UI-related data holder and lifecycle aware.
    - [Hilt](https://dagger.dev/hilt/): for dependency injection.
- Architecture
    - MVVM Architecture (View - DataBinding - ViewModel - Model)
    - Repository Pattern
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit): Construct the REST APIs and paging
  network data.
- [Material-Components](https://github.com/material-components/material-components-android):
  Material design components for building some UI components.
- [Coil](https://github.com/coil-kt/coil): Image loading.
- [Lottie](https://github.com/airbnb/lottie-android): Animated vector images
- [Palette](https://developer.android.com/jetpack/androidx/releases/palette): Extract representative
  color palettes
  from images.
- [Timber](https://github.com/JakeWharton/timber): A logger with a small, extensible API.

## Architecture

**PokemonLib** is based on the MVVM architecture and the Repository pattern, which follows
the [Google's official architecture guidance](https://developer.android.com/topic/architecture).

The overall architecture of **PokemonLib** is composed of two layers; the UI layer and the data
layer.
Each layer has dedicated components and they have each different responsibilities, as defined below:

**PokemonLib** was built
with [Guide to app architecture](https://developer.android.com/topic/architecture), so it would be a
great sample to show how the architecture works in real-world projects.

## Open API

<img src="https://user-images.githubusercontent.com/24237865/83422649-d1b1d980-a464-11ea-8c91-a24fdf89cd6b.png" align="right" width="21%"/>

PokemonLib using the [PokeAPI](https://pokeapi.co/) for constructing RESTful API.<br>
PokeAPI provides a RESTful API interface to highly detailed objects built from thousands of lines of
data related to Pokémon.
