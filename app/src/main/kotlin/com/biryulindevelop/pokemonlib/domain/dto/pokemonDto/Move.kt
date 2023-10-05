package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class Move(
    val move: MoveName = MoveName(),
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetail> = listOf()
)