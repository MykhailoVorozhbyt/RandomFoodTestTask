package com.example.randomfood.ui.food_information.views

import android.content.Context
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.core.R
import com.example.core.ui.ProgressView
import com.example.core.ui.theme.AccentPink
import com.example.core.utils.toColor
import com.example.domain.models.FoodInformationModel
import com.example.randomfood.ui.food_information.model.FoodInformationUiState


@Composable
fun FoodInformationContent(
    state: FoodInformationUiState,
    popBackClick: () -> Unit
) {
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        FoodListToolbar(state.foodInformation.id) {
            popBackClick.invoke()
        }
        if (state.isLoaderVisible) {
            ProgressView()
        } else {
            AnimatedVisibility(
                visible = true,
                enter = fadeIn(animationSpec = tween(1000)),
                exit = fadeOut(animationSpec = tween(1000))
            ) {
                FoodInformationItem(state.foodInformation, context)
            }
        }
    }
}

@Composable
fun FoodInformationItem(info: FoodInformationModel, context: Context) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .padding(20.dp),
        colors = CardDefaults.cardColors(
            containerColor = info.color.toColor()
        ),
    ) {
        if (info.photoUrl != null) {
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(context)
                    .data(info.photoUrl)
                    .crossfade(true)
                    .build()
            ).let {
                Image(
                    painter = it,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally),
                )
            }
        }
        Text(
            text = info.text,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally)
                .padding(20.dp),
            style = TextStyle(
                color = Color.White,
                fontSize = 20.sp
            )
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FoodListToolbar(
    title: String,
    popBackClick: () -> Unit
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
        navigationIcon = {
            IconButton(
                onClick = { popBackClick.invoke() },
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Icon(
                    painterResource(R.drawable.ic_arrow_back),
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