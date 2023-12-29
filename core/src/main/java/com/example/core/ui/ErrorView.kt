package com.example.core.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.R
import com.example.core.ui.theme.AccentPink

@Preview
@Composable
fun ErrorViewPreview() {
    ErrorView(
        e = Throwable(),
        action = { }
    )
}

@Composable
fun ErrorView(modifier: Modifier = Modifier, e: Throwable, action: () -> Unit) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically)
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_error),
            contentDescription = null,
            tint = AccentPink,
            modifier = modifier
                .fillMaxWidth()
                .size(50.dp)
        )
        Text(
            text = e.localizedMessage.orEmpty(),
            modifier = modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            textAlign = TextAlign.Center
        )
        Button(
            modifier = modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.Center),
            colors = ButtonDefaults.buttonColors(
                containerColor = AccentPink
            ),
            onClick = action
        ) {
            Text(text = stringResource(id = R.string.retry))
        }
    }
}