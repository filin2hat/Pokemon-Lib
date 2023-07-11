package com.biryulindevelop.pokedex.data.remote.responses


import com.google.gson.annotations.SerializedName

data class PokemonModel(
    val abilities: List<Ability> = listOf(),
    @SerializedName("base_experience")
    val baseExperience: Int = 0,
    val forms: List<Form> = listOf(),
    @SerializedName("game_indices")
    val gameIndices: List<GameIndice> = listOf(),
    val height: Int = 0,
    @SerializedName("held_items")
    val heldItems: List<Any> = listOf(),
    val id: Int = 0,
    @SerializedName("is_default")
    val isDefault: Boolean = false,
    @SerializedName("location_area_encounters")
    val locationAreaEncounters: String = "",
    val moves: List<Move> = listOf(),
    val name: String = "",
    val order: Int = 0,
    @SerializedName("past_types")
    val pastTypes: List<Any> = listOf(),
    val species: Species = Species(),
    val sprites: Sprites = Sprites(),
    val stats: List<Stat> = listOf(),
    val types: List<Type> = listOf(),
    val weight: Int = 0
) {
    data class Ability(
        val ability: Ability = Ability(),
        @SerializedName("is_hidden")
        val isHidden: Boolean = false,
        val slot: Int = 0
    ) {
        data class Ability(
            val name: String = "",
            val url: String = ""
        )
    }

    data class Form(
        val name: String = "",
        val url: String = ""
    )

    data class GameIndice(
        @SerializedName("game_index")
        val gameIndex: Int = 0,
        val version: Version = Version()
    ) {
        data class Version(
            val name: String = "",
            val url: String = ""
        )
    }

    data class Move(
        val move: Move = Move(),
        @SerializedName("version_group_details")
        val versionGroupDetails: List<VersionGroupDetail> = listOf()
    ) {
        data class Move(
            val name: String = "",
            val url: String = ""
        )

        data class VersionGroupDetail(
            @SerializedName("level_learned_at")
            val levelLearnedAt: Int = 0,
            @SerializedName("move_learn_method")
            val moveLearnMethod: MoveLearnMethod = MoveLearnMethod(),
            @SerializedName("version_group")
            val versionGroup: VersionGroup = VersionGroup()
        ) {
            data class MoveLearnMethod(
                val name: String = "",
                val url: String = ""
            )

            data class VersionGroup(
                val name: String = "",
                val url: String = ""
            )
        }
    }

    data class Species(
        val name: String = "",
        val url: String = ""
    )

    data class Sprites(
        @SerializedName("back_default")
        val backDefault: String = "",
        @SerializedName("back_female")
        val backFemale: Any = Any(),
        @SerializedName("back_shiny")
        val backShiny: String = "",
        @SerializedName("back_shiny_female")
        val backShinyFemale: Any = Any(),
        @SerializedName("front_default")
        val frontDefault: String = "",
        @SerializedName("front_female")
        val frontFemale: Any = Any(),
        @SerializedName("front_shiny")
        val frontShiny: String = "",
        @SerializedName("front_shiny_female")
        val frontShinyFemale: Any = Any(),
        val other: Other = Other(),
        val versions: Versions = Versions()
    ) {
        data class Other(
            @SerializedName("dream_world")
            val dreamWorld: DreamWorld = DreamWorld(),
            val home: Home = Home(),
            @SerializedName("official-artwork")
            val officialArtwork: OfficialArtwork = OfficialArtwork()
        ) {
            data class DreamWorld(
                @SerializedName("front_default")
                val frontDefault: String = "",
                @SerializedName("front_female")
                val frontFemale: Any = Any()
            )

            data class Home(
                @SerializedName("front_default")
                val frontDefault: String = "",
                @SerializedName("front_female")
                val frontFemale: Any = Any(),
                @SerializedName("front_shiny")
                val frontShiny: String = "",
                @SerializedName("front_shiny_female")
                val frontShinyFemale: Any = Any()
            )

            data class OfficialArtwork(
                @SerializedName("front_default")
                val frontDefault: String = "",
                @SerializedName("front_shiny")
                val frontShiny: String = ""
            )
        }

        data class Versions(
            @SerializedName("generation-i")
            val generationI: GenerationI = GenerationI(),
            @SerializedName("generation-ii")
            val generationIi: GenerationIi = GenerationIi(),
            @SerializedName("generation-iii")
            val generationIii: GenerationIii = GenerationIii(),
            @SerializedName("generation-iv")
            val generationIv: GenerationIv = GenerationIv(),
            @SerializedName("generation-v")
            val generationV: GenerationV = GenerationV(),
            @SerializedName("generation-vi")
            val generationVi: GenerationVi = GenerationVi(),
            @SerializedName("generation-vii")
            val generationVii: GenerationVii = GenerationVii(),
            @SerializedName("generation-viii")
            val generationViii: GenerationViii = GenerationViii()
        ) {
            data class GenerationI(
                @SerializedName("red-blue")
                val redBlue: RedBlue = RedBlue(),
                val yellow: Yellow = Yellow()
            ) {
                data class RedBlue(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_gray")
                    val backGray: String = "",
                    @SerializedName("back_transparent")
                    val backTransparent: String = "",
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_gray")
                    val frontGray: String = "",
                    @SerializedName("front_transparent")
                    val frontTransparent: String = ""
                )

                data class Yellow(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_gray")
                    val backGray: String = "",
                    @SerializedName("back_transparent")
                    val backTransparent: String = "",
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_gray")
                    val frontGray: String = "",
                    @SerializedName("front_transparent")
                    val frontTransparent: String = ""
                )
            }

            data class GenerationIi(
                val crystal: Crystal = Crystal(),
                val gold: Gold = Gold(),
                val silver: Silver = Silver()
            ) {
                data class Crystal(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("back_shiny_transparent")
                    val backShinyTransparent: String = "",
                    @SerializedName("back_transparent")
                    val backTransparent: String = "",
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_shiny_transparent")
                    val frontShinyTransparent: String = "",
                    @SerializedName("front_transparent")
                    val frontTransparent: String = ""
                )

                data class Gold(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_transparent")
                    val frontTransparent: String = ""
                )

                data class Silver(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_transparent")
                    val frontTransparent: String = ""
                )
            }

            data class GenerationIii(
                val emerald: Emerald = Emerald(),
                @SerializedName("firered-leafgreen")
                val fireredLeafgreen: FireredLeafgreen = FireredLeafgreen(),
                @SerializedName("ruby-sapphire")
                val rubySapphire: RubySapphire = RubySapphire()
            ) {
                data class Emerald(
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_shiny")
                    val frontShiny: String = ""
                )

                data class FireredLeafgreen(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_shiny")
                    val frontShiny: String = ""
                )

                data class RubySapphire(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_shiny")
                    val frontShiny: String = ""
                )
            }

            data class GenerationIv(
                @SerializedName("diamond-pearl")
                val diamondPearl: DiamondPearl = DiamondPearl(),
                @SerializedName("heartgold-soulsilver")
                val heartgoldSoulsilver: HeartgoldSoulsilver = HeartgoldSoulsilver(),
                val platinum: Platinum = Platinum()
            ) {
                data class DiamondPearl(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_female")
                    val backFemale: Any = Any(),
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any = Any(),
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any(),
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any = Any()
                )

                data class HeartgoldSoulsilver(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_female")
                    val backFemale: Any = Any(),
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any = Any(),
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any(),
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any = Any()
                )

                data class Platinum(
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_female")
                    val backFemale: Any = Any(),
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any = Any(),
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any(),
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any = Any()
                )
            }

            data class GenerationV(
                @SerializedName("black-white")
                val blackWhite: BlackWhite = BlackWhite()
            ) {
                data class BlackWhite(
                    val animated: Animated = Animated(),
                    @SerializedName("back_default")
                    val backDefault: String = "",
                    @SerializedName("back_female")
                    val backFemale: Any = Any(),
                    @SerializedName("back_shiny")
                    val backShiny: String = "",
                    @SerializedName("back_shiny_female")
                    val backShinyFemale: Any = Any(),
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any(),
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any = Any()
                ) {
                    data class Animated(
                        @SerializedName("back_default")
                        val backDefault: String = "",
                        @SerializedName("back_female")
                        val backFemale: Any = Any(),
                        @SerializedName("back_shiny")
                        val backShiny: String = "",
                        @SerializedName("back_shiny_female")
                        val backShinyFemale: Any = Any(),
                        @SerializedName("front_default")
                        val frontDefault: String = "",
                        @SerializedName("front_female")
                        val frontFemale: Any = Any(),
                        @SerializedName("front_shiny")
                        val frontShiny: String = "",
                        @SerializedName("front_shiny_female")
                        val frontShinyFemale: Any = Any()
                    )
                }
            }

            data class GenerationVi(
                @SerializedName("omegaruby-alphasapphire")
                val omegarubyAlphasapphire: OmegarubyAlphasapphire = OmegarubyAlphasapphire(),
                @SerializedName("x-y")
                val xY: XY = XY()
            ) {
                data class OmegarubyAlphasapphire(
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any(),
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any = Any()
                )

                data class XY(
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any(),
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any = Any()
                )
            }

            data class GenerationVii(
                val icons: Icons = Icons(),
                @SerializedName("ultra-sun-ultra-moon")
                val ultraSunUltraMoon: UltraSunUltraMoon = UltraSunUltraMoon()
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any()
                )

                data class UltraSunUltraMoon(
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any(),
                    @SerializedName("front_shiny")
                    val frontShiny: String = "",
                    @SerializedName("front_shiny_female")
                    val frontShinyFemale: Any = Any()
                )
            }

            data class GenerationViii(
                val icons: Icons = Icons()
            ) {
                data class Icons(
                    @SerializedName("front_default")
                    val frontDefault: String = "",
                    @SerializedName("front_female")
                    val frontFemale: Any = Any()
                )
            }
        }
    }

    data class Stat(
        @SerializedName("base_stat")
        val baseStat: Int = 0,
        val effort: Int = 0,
        val stat: Stat = Stat()
    ) {
        data class Stat(
            val name: String = "",
            val url: String = ""
        )
    }

    data class Type(
        val slot: Int = 0,
        val type: Type = Type()
    ) {
        data class Type(
            val name: String = "",
            val url: String = ""
        )
    }
}