package com.biryulindevelop.pokemonlib.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.biryulindevelop.pokemonlib.R
import com.biryulindevelop.pokemonlib.presentation.screens.details.PokemonDetailsScreen
import com.biryulindevelop.pokemonlib.presentation.screens.list.PokemonListScreen
import com.biryulindevelop.pokemonlib.presentation.screens.splash.PokemonSplashScreen
import com.biryulindevelop.pokemonlib.ui.theme.PokemonLibTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokemonLibTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Screen.PokemonSplash.route,
                    enterTransition = {
                        slideInHorizontally(
                            initialOffsetX = { it },
                            animationSpec = tween(400)
                        )
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            targetOffsetX = { -it },
                            animationSpec = tween(400)
                        )
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            initialOffsetX = { -it },
                            animationSpec = tween(400)
                        )
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            targetOffsetX = { it },
                            animationSpec = tween(400)
                        )
                    }
                ) {
                    addScreen(Screen.PokemonSplash) { PokemonSplashScreen(navController = navController) }

                    addScreen(Screen.PokemonList) { PokemonListScreen(navController = navController) }

                    addScreen(Screen.PokemonDetails) { backStackEntry ->
                        val dominantColor = remember {
                            val color = backStackEntry.arguments?.getInt("dominantColor")
                            color?.let { Color(it) } ?: Color.White
                        }
                        val pokemonName = remember {
                            backStackEntry.arguments?.getString("pokemonName")
                                ?: getString(R.string.noname)
                        }
                        PokemonDetailsScreen(
                            dominantColor = dominantColor,
                            pokemonName = pokemonName.lowercase(),
                            navController = navController
                        )
                    }
                }
            }
        }
    }

    private fun NavGraphBuilder.addScreen(
        screen: Screen,
        content: @Composable (NavBackStackEntry) -> Unit
    ) {
        composable(screen.route, arguments = screen.arguments) { backStackEntry ->
            content(backStackEntry)
        }
    }
}

sealed class Screen(val route: String, val arguments: List<NamedNavArgument>) {
    data object PokemonSplash : Screen("pokemon_splash_screen", emptyList())
    data object PokemonList : Screen("pokemon_list_screen", emptyList())
    data object PokemonDetails : Screen(
        "pokemon_detail_screen/{dominantColor}/{pokemonName}",
        listOf(
            navArgument("dominantColor") { type = NavType.IntType },
            navArgument("pokemonName") { type = NavType.StringType }
        )
    )
}