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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DarkSwitchIcon
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.LightSwitchIcon

@Composable
fun DotoriThemeSwitchButton(
    modifier: Modifier = Modifier,
    isDark: Boolean = false,
    onSwitchClick: (Boolean) -> Unit
) {
    val buttonWidth: Dp = 70.dp
    val buttonHeight: Dp = 40.dp
    val switchPadding: Dp = 5.dp

    val switchSize by remember { mutableStateOf(buttonHeight-switchPadding*2) }
    val interactionSource = remember { MutableInteractionSource() }
    var switchClicked by remember { mutableStateOf(isDark) }
    val moveDp = if (switchClicked) buttonWidth-switchSize-switchPadding*2 else 0.dp

    val animateSize by animateDpAsState(
        targetValue = if (switchClicked) moveDp else 0.dp,
        tween(
            durationMillis = 150,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    Box(modifier = modifier) {
        Box(
            modifier = Modifier
                .width(buttonWidth)
                .height(buttonHeight)
                .clip(CircleShape)
                .background(DotoriTheme.colors.neutral40)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(switchPadding)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                    ) {
                        switchClicked = !switchClicked
                        onSwitchClick(switchClicked)
                    }
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(animateSize)
                )

                Box {
                    if (switchClicked) DarkSwitchIcon(contentDescription = "dark switch")
                    else LightSwitchIcon(contentDescription = "light switch")
                }
            }
        }
    }
}