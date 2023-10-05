package com.biryulindevelop.pokemonlib.presentation.screens.splash

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.media.MediaPlayer
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.biryulindevelop.pokemonlib.R
import com.biryulindevelop.pokemonlib.ui.theme.DarkBlue
import com.biryulindevelop.pokemonlib.ui.theme.LightBlue
import com.biryulindevelop.pokemonlib.ui.theme.PokemonHollow
import kotlinx.coroutines.delay

@Composable
fun PokemonSplashScreen(navController: NavController) {
    var startAnimation by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnimation) 1f else 0f,
        animationSpec = tween(durationMillis = 2200),
        label = ""
    )
    val mp = MediaPlayer.create(LocalContext.current, R.raw.pika_pika_sound)

    LaunchedEffect(key1 = true) {
        startAnimation = true
        delay(2200)
        navController.popBackStack()
        navController.navigate("pokemon_list_screen")
    }

    LaunchedEffect(startAnimation) {
        if (startAnimation) {
            mp.start()
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            mp.stop()
            mp.release()
        }
    }

    Splash(alpha = alphaAnim.value)
}

@Composable
fun Splash(alpha: Float) {
    Box(
        modifier = Modifier
            .background(if (isSystemInDarkTheme()) DarkBlue else LightBlue)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LogoAnimation(alpha)
            TextLogo(alpha)
        }
    }
}


@Composable
fun LogoAnimation(alpha: Float) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.pikachu_animation))
    LottieAnimation(
        composition = composition,
        modifier = Modifier
            .fillMaxHeight(0.75f)
            .padding(horizontal = 16.dp)
            .alpha(alpha)
    )
}

@Composable
fun TextLogo(
    alpha: Float
) {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .alpha(alpha),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                contentDescription = "Pokemon Logo"
            )
            Text(
                text = stringResource(R.string.pokemon_lib),
                fontSize = 54.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontFamily = PokemonHollow,
                color = Color.Yellow,
                modifier = Modifier
                    .width(90.dp)
                    .offset(x = (-10).dp)
            )
        }
    }
}

@Composable
@Preview
fun SplashPreview() {
    Splash(alpha = 1f)
}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun SplashDarkPreview() {
    Splash(alpha = 1f)
}