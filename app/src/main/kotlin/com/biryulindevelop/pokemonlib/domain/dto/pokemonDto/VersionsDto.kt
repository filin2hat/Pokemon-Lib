package com.biryulindevelop.pokemonlib.domain.dto.pokemonDto


import com.google.gson.annotations.SerializedName

data class VersionsDto(
    @SerializedName("generation-i")
    val generationI: GenerationIDto,
    @SerializedName("generation-ii")
    val generationIi: GenerationIiDto,
    @SerializedName("generation-iii")
    val generationIii: GenerationIiiDto,
    @SerializedName("generation-iv")
    val generationIv: GenerationIvDto,
    @SerializedName("generation-v")
    val generationV: GenerationVDto,
    @SerializedName("generation-vi")
    val generationVi: GenerationViDto,
    @SerializedName("generation-vii")
    val generationVii: GenerationViiDto,
    @SerializedName("generation-viii")
    val generationViii: GenerationViiiDto
)