package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto

import com.google.gson.annotations.SerializedName

data class VersionGroupDetailDto(
    @SerializedName("level_learned_at")
    val levelLearnedAt: Int = 0,
    @SerializedName("move_learn_method")
    val moveLearnMethod: MoveLearnMethodDto = MoveLearnMethodDto(),
    @SerializedName("version_group")
    val versionGroup: VersionGroupDto = VersionGroupDto()
)