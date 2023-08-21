package com.dotori.dotori_components.components.toggle

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.Black
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.White

@Composable
fun DotoriSwitchButton(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit
) {
    val buttonWidth: Dp = 56.dp
    val buttonHeight: Dp = 32.dp
    val switchPadding: Dp = 4.dp

    val switchSize by remember { mutableStateOf(buttonHeight-switchPadding*2) }
    val interactionSource = remember { MutableInteractionSource() }
    var switchChecked by remember { mutableStateOf(checked) }
    val moveDp = if (switchChecked) buttonWidth-switchSize-switchPadding*2 else 0.dp

    val animateSize by animateDpAsState(
        targetValue = if (switchChecked) moveDp else 0.dp,
        animationSpec = tween(
            durationMillis = 150,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        ),
        label = "dotori toggle"
    )

    Box(
        modifier = modifier
            .width(buttonWidth)
            .height(buttonHeight)
            .clip(CircleShape)
            .background(if (switchChecked) DotoriTheme.colors.primary10 else DotoriTheme.colors.neutral40)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(switchPadding)
                .clickable(
                    interactionSource = interactionSource,
                    indication = null,
                ) {
                    switchChecked = !switchChecked
                    onCheckedChange(switchChecked)
                }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(animateSize)
            )

            Box(
                modifier = Modifier.size(24.dp)
                    .clip(CircleShape)
                    .background(if (DotoriTheme.isSystemIsDarkTheme()) Black else White),
            )
        }
    }
}

@Preview
@Composable
fun DotoriSwitchButtonPreview() {
    var checkState by remember { mutableStateOf(true) }

    DotoriSwitchButton(
        checked = checkState,
        onCheckedChange = { checkState = it }
    )
}