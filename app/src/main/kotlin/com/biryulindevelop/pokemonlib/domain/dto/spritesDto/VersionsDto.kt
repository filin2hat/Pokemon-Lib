package com.biryulindevelop.pokemonlib.domain.dto.spritesDto

import com.google.gson.annotations.SerializedName

data class VersionsDto(
    @SerializedName("generation-i")
    val generationI: GenerationIDto = GenerationIDto(),
    @SerializedName("generation-ii")
    val generationIi: GenerationIiDto = GenerationIiDto(),
    @SerializedName("generation-iii")
    val generationIii: GenerationIiiDto = GenerationIiiDto(),
    @SerializedName("generation-iv")
    val generationIv: GenerationIvDto = GenerationIvDto(),
    @SerializedName("generation-v")
    val generationV: GenerationVDto = GenerationVDto(),
    @SerializedName("generation-vi")
    val generationVi: GenerationViDto = GenerationViDto(),
    @SerializedName("generation-vii")
    val generationVii: GenerationViiDto = GenerationViiDto(),
    @SerializedName("generation-viii")
    val generationViii: GenerationViiiDto = GenerationViiiDto()
)