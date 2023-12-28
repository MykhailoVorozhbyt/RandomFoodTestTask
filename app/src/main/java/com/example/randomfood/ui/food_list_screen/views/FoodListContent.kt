package com.example.randomfood.ui.food_list_screen.views

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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
import com.example.core.ui.theme.AccentPink
import com.example.core.utils.toColor
import com.example.domain.responses.FoodItemsResponse
import com.example.randomfood.BuildConfig.API_BASE_URL
import com.example.randomfood.ui.food_list_screen.models.FoodListUiState

@Preview
@Composable
fun FoodListContentPreview() {
    FoodListContent(
        state = FoodListUiState(),
        pressOnReload = {},
        foodItemClick = {},
    )
}

@Composable
fun FoodListContent(
    state: FoodListUiState,
    pressOnReload: () -> Unit,
    foodItemClick: (id: String) -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FoodListToolbar(state.title) {
            pressOnReload.invoke()
        }
        if (state.isLoaderVisible) {
            Image(
                painter = painterResource(id = R.drawable.loader),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                alignment = Alignment.TopCenter
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp, vertical = 10.dp)
            ) {
                items(state.food) { item ->
                    FoodItem(context, item) { id ->
                        foodItemClick.invoke(id)
                    }
                }
            }
        }
    }
}

@Composable
fun FoodItem(
    context: Context,
    data: FoodItemsResponse,
    foodItemClick: (id: String) -> Unit
) {
    val iconPainter =
        rememberAsyncImagePainter(
            model = ImageRequest.Builder(context)
                .data("${API_BASE_URL}${data.image}")
                .crossfade(true)
                .build()
        )
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp),
        colors = CardDefaults.cardColors(
            containerColor = data.color.toColor()
        ),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .clickable {
                    foodItemClick.invoke(data.id)
                }
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
            Image(
                painter = iconPainter,
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
            )
        }
    }
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
            Icon(
                painterResource(R.drawable.ic_refresh_button),
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier
                    .clickable { pressOnReload.invoke() }
                    .padding(10.dp)
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = AccentPink
        ),
        modifier = Modifier.fillMaxWidth()
    )
}