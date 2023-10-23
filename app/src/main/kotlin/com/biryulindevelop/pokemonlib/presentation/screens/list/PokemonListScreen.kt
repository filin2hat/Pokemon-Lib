package com.biryulindevelop.pokemonlib.presentation.screens.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.biryulindevelop.pokemonlib.R
import com.biryulindevelop.pokemonlib.domain.model.PokemonListEntry
import com.biryulindevelop.pokemonlib.ui.theme.PokemonHollow
import com.biryulindevelop.pokemonlib.ui.theme.PoketMonk
import com.biryulindevelop.pokemonlib.util.Constants.EMPTY_STRING
import com.biryulindevelop.pokemonlib.util.calcDominantColor

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel()
) {
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(84.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_international_pok_mon_logo),
                    contentDescription = "Pokemon Logo",
                    modifier = Modifier
                        .padding(top = 12.dp)
                )
                Text(
                    text = stringResource(R.string.pokemon_lib),
                    fontSize = 54.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = PokemonHollow,
                    color = Color.Yellow,
                    modifier = Modifier
                        .padding(top = 8.dp)
                        .width(90.dp)
                        .offset(x = (-10).dp)
                )
            }
            SearchBar(
                hint = stringResource(R.string.search),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                onSearch = {
                    viewModel.searchPokemon(it)
                }
            )
            PokemonList(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hint: String = EMPTY_STRING,
    onSearch: (String) -> Unit
) {
    var text by remember {
        mutableStateOf(EMPTY_STRING)
    }
    var isHintDisplayed by remember {
        mutableStateOf(hint != EMPTY_STRING)
    }
    Box(modifier = modifier) {
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                onSearch(it)
            },
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp, vertical = 12.dp)
                .onFocusChanged {
                    isHintDisplayed = !it.isFocused && text.isBlank()
                }
        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}

@Composable
fun PokemonList(
    navController: NavController,
    viewModel: PokemonListViewModel
) {
    val pokemonList by rememberUpdatedState(viewModel.pokemonList)
    val isSearching by rememberUpdatedState(viewModel.isSearching)
    val loadError by rememberUpdatedState(viewModel.loadError)
    val isLoading: Boolean by rememberUpdatedState(viewModel.isLoading)

    LazyColumn(
        contentPadding = PaddingValues(10.dp)
    ) {
        val itemCount = if (pokemonList.size % 2 == 0) {
            pokemonList.size / 2
        } else {
            pokemonList.size / 2 + 1
        }
        items(itemCount) {
            if (it >= itemCount - 1 && !isLoading && !isSearching) {
                viewModel.loadPokemonPaged()
            }
            PokemonListRow(rowIndex = it, entries = pokemonList, navController = navController)
        }
    }
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(color = MaterialTheme.colorScheme.primary)
        }
        if (loadError.isNotEmpty()) {
            RetryLoading(error = loadError) {
                viewModel.loadPokemonPaged()
            }
        }
    }
}

@Composable
fun PokemonLibEntry(
    entry: PokemonListEntry,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val defaultDominantColor = MaterialTheme.colorScheme.surface
    var dominantColor by remember {
        mutableStateOf(defaultDominantColor)
    }
    Box(
        contentAlignment = Center,
        modifier = modifier
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(
                Brush.verticalGradient(
                    listOf(
                        dominantColor,
                        defaultDominantColor
                    )
                )
            )
            .clickable {
                navController.navigate(
                    "pokemon_detail_screen/${dominantColor.toArgb()}/${entry.pokemonName}"
                )
            }
    ) {
        Column(
            horizontalAlignment = CenterHorizontally
        ) {
            val painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = entry.imageUrl)
                    .apply(block = fun ImageRequest.Builder.() {
                        listener(
                            onSuccess = { _, result ->
                                calcDominantColor(result.drawable) { color ->
                                    dominantColor = color
                                }
                            }
                        )
                    }).build(),
                placeholder = painterResource(id = R.drawable.poketball),
            )
            Image(
                painter = painter,
                contentDescription = entry.pokemonName,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(3.5f)
                    .padding(4.dp)
            )
            Text(
                text = entry.pokemonName,
                fontFamily = PokemonHollow,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .weight(1f)
                    .padding(start = 4.dp, end = 4.dp, bottom = 2.dp)
                    .offset(y = (-5).dp)
            )
        }
    }
}

@Composable
fun PokemonListRow(
    rowIndex: Int,
    entries: List<PokemonListEntry>,
    navController: NavController
) {
    Column {
        Row {
            PokemonLibEntry(
                entry = entries[rowIndex * 2],
                navController = navController,
                modifier = Modifier.weight(1f)
            )
            Spacer(modifier = Modifier.width(10.dp))
            if (entries.size >= rowIndex * 2 + 2) {
                PokemonLibEntry(
                    entry = entries[rowIndex * 2 + 1],
                    navController = navController,
                    modifier = Modifier.weight(1f)
                )
            } else {
                Spacer(modifier = Modifier.weight(1f))
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}

@Composable
fun RetryLoading(
    error: String,
    onRetry: () -> Unit
) {
    Column {
        Text(
            text = error,
            color = Color.Red,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontFamily = PoketMonk
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { onRetry() },
            modifier = Modifier.align(CenterHorizontally)
        ) {
            Text(
                text = stringResource(R.string.retry),
                fontFamily = PoketMonk
            )
        }
    }
}