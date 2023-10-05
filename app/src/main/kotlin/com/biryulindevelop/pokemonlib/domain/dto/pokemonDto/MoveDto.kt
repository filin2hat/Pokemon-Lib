package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class MoveDto(
    val move: MoveNameDto = MoveNameDto(),
    @SerializedName("version_group_details")
    val versionGroupDetails: List<VersionGroupDetailDto> = listOf()
)