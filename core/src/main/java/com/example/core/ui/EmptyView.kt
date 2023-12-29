package com.example.core.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.ui.theme.AccentPink

@Composable
fun EmptyView(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_hourglass_empty),
            contentDescription = null,
            tint = AccentPink,
            modifier = modifier
                .fillMaxWidth()
                .size(50.dp)
        )
        Text(
            text = stringResource(id = R.string.text_no_data_found),
            style = MaterialTheme.typography.displayMedium,
            textAlign = TextAlign.Center,
            modifier = modifier
                .fillMaxWidth()
        )
    }
}