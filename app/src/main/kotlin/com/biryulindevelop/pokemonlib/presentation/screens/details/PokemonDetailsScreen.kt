package com.biryulindevelop.pokemonlib.presentation.screens.details

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.biryulindevelop.pokemonlib.R
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.PokemonDto
import com.biryulindevelop.pokemonlib.domain.dto.pokemonDto.TypeDto
import com.biryulindevelop.pokemonlib.ui.theme.PokemonSolid
import com.biryulindevelop.pokemonlib.ui.theme.PoketMonk
import com.biryulindevelop.pokemonlib.util.changeTypeName
import com.biryulindevelop.pokemonlib.util.parseStatColor
import com.biryulindevelop.pokemonlib.util.parseStatToAbbr
import com.biryulindevelop.pokemonlib.util.parseTypeToColor
import java.util.Locale
import kotlin.math.round

@Composable
fun PokemonDetailsScreen(
    dominantColor: Color,
    pokemonName: String,
    navController: NavController,
    topPadding: Dp = 20.dp,
    pokemonImageSize: Dp = 250.dp,
    viewModel: PokemonDetailsViewModel = hiltViewModel()
) {
    viewModel.loadPokemonInfo(pokemonName)

    val pokemonInfo = viewModel.pokemonInfo.value
    val errorInfo = viewModel.errorInfo.value
    val isLoading = viewModel.isLoading.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(dominantColor)
            .verticalScroll(rememberScrollState())
    )
    {
        PokemonDetailTopSection(
            pokemonInfo = pokemonInfo,
            navController = navController
        )
        PokemonDetailStateWrapper(
            pokemonInfo = pokemonInfo,
            errorInfo = errorInfo,
            isLoading = isLoading,
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
                .shadow(10.dp, RoundedCornerShape(10.dp))
                .clip(RoundedCornerShape(10.dp))
                .background(MaterialTheme.colorScheme.surface)
                .align(Alignment.BottomCenter),

            loadingModifier = Modifier
                .size(100.dp)
                .align(Alignment.Center)
                .padding(
                    top = topPadding + pokemonImageSize,
                    start = 16.dp,
                    end = 16.dp,
                    bottom = 16.dp
                )
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = 60.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            pokemonInfo?.sprites?.other?.officialArtwork?.frontDefault?.let {
                AsyncImage(
                    model = it,
                    contentDescription = pokemonInfo.name,
                    contentScale = ContentScale.FillHeight
                )
            }
        }
    }


}

@Composable
fun PokemonDetailTopSection(
    pokemonInfo: PokemonDto?,
    navController: NavController
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    listOf(
                        Color.Black,
                        Color.Transparent
                    )
                )
            ),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = stringResource(R.string.button_back),
            tint = Color.White,
            modifier = Modifier
                .size(40.dp)
                .offset(x = 16.dp, y = 28.dp)
                .clickable { navController.popBackStack() }
        )
        Row(
            modifier = Modifier
                .padding(28.dp)
        ) {
            Text(
                text = "#",
                fontSize = 42.sp,
                color = Color.White
            )
            Text(
                text = pokemonInfo?.id?.toString() ?: "",
                fontSize = 48.sp,
                color = Color.White
            )
        }
    }
}

@Composable
fun PokemonDetailStateWrapper(
    pokemonInfo: PokemonDto?,
    modifier: Modifier = Modifier,
    errorInfo: String?,
    isLoading: Boolean?,
    loadingModifier: Modifier = Modifier
) {
    if (isLoading == true) {
        CircularProgressIndicator(
            color = MaterialTheme.colorScheme.primary,
            modifier = loadingModifier
        )
    }

    pokemonInfo.let {
        if (it != null) {
            PokemonDetailSelection(
                pokemonInfo = it,
                modifier = modifier
            )
        }
    }
    errorInfo.let {
        if (it != null) {
            Text(
                text = it,
                color = Color.Red,
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                fontFamily = PoketMonk,
                modifier = modifier
                    .padding(horizontal = 16.dp)
            )
        }
    }
}

@Composable
fun PokemonDetailSelection(
    pokemonInfo: PokemonDto,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = CenterHorizontally,
        modifier = modifier
            .padding(top = 100.dp)
    ) {
        Text(
            text = pokemonInfo.name.replaceFirstChar {
                if (it.isLowerCase()) it.titlecase(Locale.ROOT)
                else it.toString()
            },
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
        PokemonTypeSection(types = pokemonInfo.types)
        PokemonDetailDataSection(
            pokemonWeight = pokemonInfo.weight,
            pokemonHeight = pokemonInfo.height
        )
        PokemonBaseStats(pokemonInfo = pokemonInfo)
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun PokemonTypeSection(types: List<TypeDto>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(16.dp)
    ) {
        for (type in types) {
            val charType: String = changeTypeName(type = type, context = LocalContext.current)
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 8.dp)
                    .clip(CircleShape)
                    .background(parseTypeToColor(type))
                    .height(35.dp)
            ) {

                Text(
                    text = charType.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.ROOT
                        ) else it.toString()
                    },
                    color = Color.White,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Composable
fun PokemonDetailDataSection(
    pokemonWeight: Int,
    pokemonHeight: Int,
    sectionHeight: Dp = 80.dp
) {
    val pokemonWeightInKg = remember {
        round(pokemonWeight * 100f) / 1000f
    }
    val pokemonHeightInMeters = remember {
        round(pokemonHeight * 100f) / 1000f
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        PokemonDetailDataItem(
            dataValue = pokemonWeightInKg,
            dataUnit = "kg",
            dataIcon = painterResource(id = R.drawable.ic_weight),
            modifier = Modifier.weight(1f)
        )
        Spacer(
            modifier = Modifier
                .size(1.dp, sectionHeight)
                .background(Color.LightGray)
        )
        PokemonDetailDataItem(
            dataValue = pokemonHeightInMeters,
            dataUnit = "m",
            dataIcon = painterResource(id = R.drawable.ic_height),
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun PokemonDetailDataItem(
    dataValue: Float,
    dataUnit: String,
    dataIcon: Painter,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        Icon(
            painter = dataIcon,
            contentDescription = null,
            tint = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "$dataValue$dataUnit",
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun PokemonStat(
    statName: String,
    statValue: Int,
    statMaxValue: Int,
    statColor: Color,
    height: Dp = 28.dp,
    animDuration: Int = 1500,
    animDelay: Int = 0
) {
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val curPercent = animateFloatAsState(
        targetValue = if (animationPlayed) {
            statValue / statMaxValue.toFloat()
        } else 0f,
        animationSpec = tween(
            animDuration,
            animDelay
        ), label = ""
    )

    LaunchedEffect(key1 = true) {
        animationPlayed = true
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(height)
            .padding(horizontal = 8.dp)
            .clip(CircleShape)
            .background(
                if (isSystemInDarkTheme()) {
                    Color(0xFF505050)
                } else {
                    Color.LightGray
                }
            )
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(curPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp)
        ) {
            Text(
                text = statName,
                fontFamily = PokemonSolid,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                text = (curPercent.value * statMaxValue).toInt().toString(),
                fontFamily = PoketMonk,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun PokemonBaseStats(
    pokemonInfo: PokemonDto,
    animDelayPerItem: Int = 100
) {
    val maxBaseStat = remember {
        pokemonInfo.stats.maxOf { it.baseStat }
    }
    Spacer(modifier = Modifier.height(8.dp))
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = stringResource(R.string.base_stats),
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onSurface,
            modifier = Modifier
                .align(CenterHorizontally)
                .padding(bottom = 8.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        for (i in pokemonInfo.stats.indices) {
            val stat = pokemonInfo.stats[i]
            PokemonStat(
                statName = parseStatToAbbr(stat = stat, context = LocalContext.current),
                statValue = stat.baseStat,
                statMaxValue = maxBaseStat,
                statColor = parseStatColor(stat),
                animDelay = i * animDelayPerItem,
                animDuration = 800 + (i * 300)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}