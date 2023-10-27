package com.biryulindevelop.pokemonlib.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.biryulindevelop.pokemonlib.presentation.screens.details.PokemonDetailsScreen
import com.biryulindevelop.pokemonlib.presentation.screens.list.PokemonListScreen
import com.biryulindevelop.pokemonlib.presentation.screens.splash.PokemonSplashScreen
import com.biryulindevelop.pokemonlib.ui.theme.PokemonLibTheme
import com.biryulindevelop.pokemonlib.util.Constants.DOMINANT_COLOR_KEY
import com.biryulindevelop.pokemonlib.util.Constants.POKEMON_DETAILS_PATH
import com.biryulindevelop.pokemonlib.util.Constants.POKEMON_LIST_PATH
import com.biryulindevelop.pokemonlib.util.Constants.POKEMON_NAME_KEY
import com.biryulindevelop.pokemonlib.util.Constants.SCREEN_ANIMATION_DELAY
import com.biryulindevelop.pokemonlib.util.Constants.SPLASH_SCREEN_PATH
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
                            animationSpec = tween(SCREEN_ANIMATION_DELAY)
                        )
                    },
                    exitTransition = {
                        slideOutHorizontally(
                            targetOffsetX = { -it },
                            animationSpec = tween(SCREEN_ANIMATION_DELAY)
                        )
                    },
                    popEnterTransition = {
                        slideInHorizontally(
                            initialOffsetX = { -it },
                            animationSpec = tween(SCREEN_ANIMATION_DELAY)
                        )
                    },
                    popExitTransition = {
                        slideOutHorizontally(
                            targetOffsetX = { it },
                            animationSpec = tween(SCREEN_ANIMATION_DELAY)
                        )
                    }
                ) {
                    addScreen(Screen.PokemonSplash) { PokemonSplashScreen(navController = navController) }
                    addScreen(Screen.PokemonList) { PokemonListScreen(navController = navController) }
                    addScreen(Screen.PokemonDetails) { PokemonDetailsScreen(navController = navController) }
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
    data object PokemonSplash : Screen(SPLASH_SCREEN_PATH, emptyList())
    data object PokemonList : Screen(POKEMON_LIST_PATH, emptyList())
    data object PokemonDetails : Screen(
        "$POKEMON_DETAILS_PATH/{$DOMINANT_COLOR_KEY}/{$POKEMON_NAME_KEY}",
        listOf(
            navArgument(DOMINANT_COLOR_KEY) { type = NavType.IntType },
            navArgument(POKEMON_NAME_KEY) { type = NavType.StringType }
        )
    )
}
