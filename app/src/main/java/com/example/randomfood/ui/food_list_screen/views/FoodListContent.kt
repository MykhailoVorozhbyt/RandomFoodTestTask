package com.example.randomfood.ui.food_list_screen.views

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.core.R
import com.example.core.ui.ProgressView
import com.example.core.ui.theme.AccentPink
import com.example.core.utils.toColor
import com.example.domain.entities.FoodInfoEntity
import com.example.domain.responses.FoodItemsResponse
import com.example.randomfood.BuildConfig.API_BASE_URL
import com.example.randomfood.ui.food_list_screen.models.FoodListUiState

@Preview
@Composable
fun FoodListContentPreview() {
    FoodListContent(
        state = FoodListUiState(
            title = "cucumber",
            food = listOf(
                FoodItemsResponse(
                    id = "cucumber",
                    name = "Cucumber",
                    image = "/images/cucumber.png",
                    color = "C3A29E",
                ),
                FoodItemsResponse(
                    id = "cucumber",
                    name = "Cucumber",
                    image = "/images/cucumber.png",
                    color = "C3A29E",
                ),
                FoodItemsResponse(
                    id = "cucumber",
                    name = "Cucumber",
                    image = "/images/cucumber.png",
                    color = "C3A29E",
                ),
                FoodItemsResponse(
                    id = "cucumber",
                    name = "Cucumber",
                    image = "/images/cucumber.png",
                    color = "C3A29E",
                )
            )
        ),
        pressOnReload = {},
        foodItemClick = {},
    )
}

@Composable
fun FoodListContent(
    state: FoodListUiState,
    pressOnReload: () -> Unit,
    foodItemClick: (FoodInfoEntity) -> Unit
) {
    val context = LocalContext.current
    var visible by remember { mutableStateOf(false) }

    val imageAlpha: Float by animateFloatAsState(
        targetValue = if (visible) 1f else 0f,
        animationSpec = tween(
            durationMillis = 1500,
            easing = FastOutSlowInEasing,
        ), label = ""
    )
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FoodListToolbar(state.title) {
            pressOnReload.invoke()
        }
        if (state.isLoaderVisible) {
            visible = false
            ProgressView()
        } else {
            AnimatedVisibility(
                visible = visible,
                enter = slideInVertically(
                    initialOffsetY = { -40 }
                ),
                modifier = Modifier.alpha(imageAlpha)
            ) {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 30.dp, vertical = 10.dp)
                        .animateContentSize().alpha(imageAlpha)
                ) {
                    items(state.food) { item ->
                        FoodItem(context, item) { id ->
                            foodItemClick.invoke(id)
                        }
                    }
                }
            }
            visible = true
        }
    }
}

@Composable
fun FoodItem(
    context: Context,
    data: FoodItemsResponse,
    foodItemClick: (FoodInfoEntity) -> Unit
) {
    val iconUrl: String? = if (data.image == null) null else "${API_BASE_URL}${data.image}"
    val iconPainter =
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(context)
                .data(iconUrl)
                .crossfade(true)
                .build()
        )
    var visible by remember { mutableStateOf(false) }

    AnimatedVisibility(
        visible = visible,
        enter = slideInVertically()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .padding(vertical = 10.dp)
                .clickable {
                    foodItemClick.invoke(
                        FoodInfoEntity(
                            id = data.id,
                            photoName = iconUrl,
                            color = data.color,
                        )
                    )
                },
            colors = CardDefaults.cardColors(
                containerColor = data.color.toColor()
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .padding(start = 20.dp)
                    .padding(end = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = data.name,
                    modifier = Modifier
                        .weight(1f),
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 20.sp
                    )
                )
                if (data.image != null) {
                    rememberAsyncImagePainter(
                        model = ImageRequest.Builder(context)
                            .data(iconUrl)
                            .crossfade(true)
                            .build()
                    ).let {
                        Image(
                            painter = iconPainter,
                            contentDescription = null,
                            modifier = Modifier
                                .size(60.dp)
                        )
                    }
                }
            }
        }
    }
    visible = true
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodListToolbar(
    title: String,
    pressOnReload: () -> Unit
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                title,
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
            )
        },
        actions = {
            IconButton(
                onClick = { pressOnReload.invoke() },
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(
                    painterResource(R.drawable.ic_refresh_button),
                    contentDescription = null,
                    tint = Color.White,
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = AccentPink
        ),
        modifier = Modifier.fillMaxWidth()
    )
}