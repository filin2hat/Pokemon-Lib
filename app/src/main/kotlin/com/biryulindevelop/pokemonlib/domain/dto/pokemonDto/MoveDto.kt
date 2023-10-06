package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class MoveDto(
    @SerializedName("move")
    val move: MoveXDto,
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetailDto>
)