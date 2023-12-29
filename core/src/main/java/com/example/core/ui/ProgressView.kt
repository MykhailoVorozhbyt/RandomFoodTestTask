package com.example.core.ui

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core.R


@Composable
fun ProgressView() {
    val label = "ProgressView"
    val infiniteTransition = rememberInfiniteTransition(label = label)
    val angle by infiniteTransition.animateFloat(
        initialValue = -120f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            tween(5000, easing = LinearEasing),
        ), label = label
    )
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.loader),
            contentDescription = null,
            modifier = Modifier
                .size(50.dp)
                .rotate(angle),
            alignment = Alignment.TopCenter
        )
    }
}