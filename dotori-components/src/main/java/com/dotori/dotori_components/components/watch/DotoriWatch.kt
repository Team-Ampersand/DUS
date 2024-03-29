package com.dotori.dotori_components.components.watch

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import com.example.dus.R
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date

@SuppressLint("SimpleDateFormat")
@Composable
fun DotoriWatch(
    modifier: Modifier = Modifier,
    time: Date,
) {
    val boxHeight = remember {
        mutableStateOf(100.dp)
    }
    val density = LocalDensity.current
    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(boxHeight.value)
                .clip(RoundedCornerShape(16.dp))
                .paint(
                    painter = painterResource(id = R.drawable.bg_dotori_watch),
                    contentScale = ContentScale.Crop
                )
        ) {
            Image(
                modifier = Modifier
                    .fillMaxHeight()
                    .aspectRatio(1f)
                    .align(Alignment.BottomEnd),
                contentScale = ContentScale.Crop,
                painter = painterResource(id = if (isSystemInDarkTheme()) R.drawable.img_dark_dotori else R.drawable.img_white_dotori),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier
                .padding(top = 24.dp, start = 24.dp, bottom = 24.dp)
                .onSizeChanged { layoutCoordinates ->
                    with(density) {
                        boxHeight.value = layoutCoordinates.height.toDp() + 54.dp
                    }
                },
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "현재시간",
                style = DotoriTheme.typography.caption,
                color = Color.White
            )
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = SimpleDateFormat("aa").format(time).toString(),
                    style = DotoriTheme.typography.h4,
                    color = Color.White
                )
                Text(
                    text = SimpleDateFormat("HH: mm: ss").format(time).toString(),
                    style = DotoriTheme.typography.h3,
                    color = Color.White
                )
            }
        }
    }
}

@Preview
@Composable
private fun DotoriWatchPreview() {
    val currentTime = remember {
        mutableStateOf(Date())
    }
    LaunchedEffect(key1 = true) {
        while (true) {
            delay(1_000)
            currentTime.value = Date()
        }
    }

    DotoriWatch(
        time = currentTime.value
    )

}
