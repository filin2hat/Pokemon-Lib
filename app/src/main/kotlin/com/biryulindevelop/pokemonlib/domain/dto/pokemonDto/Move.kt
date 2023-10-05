package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class Move(
    val move: Move = Move(),
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail> = listOf()
) {
    data class Move(
        val name: String = "",
        val url: String = ""
    )
}