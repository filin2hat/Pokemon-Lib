package com.biryulindevelop.pokedex.data.remote.responses


data class PokemonListModel(
    val count: Int = 0,
    val next: String = "",
    val previous: Any = Any(),
    val results: List<Result> = listOf()
) {
    data class Result(
        val name: String = "",
        val url: String = ""
    )
}