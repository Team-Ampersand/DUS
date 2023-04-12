package com.dotori.dotori_components.components.toggle

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DarkSwitchIcon
import com.dotori.dotori_components.theme.DotoriColor
import com.dotori.dotori_components.theme.LightSwitchIcon

@Composable
fun DotoriThemeSwitchButton(
    switchPadding: Dp,
    buttonWidth: Dp,
    buttonHeight: Dp,
    isChecked: Boolean = false,
    lightIcon: @Composable () -> Unit = { LightSwitchIcon(contentDescription = "light switch") },
    darkIcon: @Composable () -> Unit = { DarkSwitchIcon(contentDescription = "dark switch") },
    onSwitchClick: () -> Unit
) {
    val switchSize by remember { mutableStateOf(buttonHeight-switchPadding*2) }
    val interactionSource = remember { MutableInteractionSource() }
    var switchClicked by remember { mutableStateOf(isChecked) }
    var padding by remember { mutableStateOf(0.dp) }

    padding = if (switchClicked) buttonWidth-switchSize-switchPadding*2 else 0.dp

    val animateSize by animateDpAsState(
        targetValue = if (switchClicked) padding else 0.dp,
        tween(
            durationMillis = 500,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    Box(
        modifier = Modifier
            .width(buttonWidth)
            .height(buttonHeight)
            .clip(CircleShape)
            .background(if (switchClicked) DotoriColor.Black else DotoriColor.Natural40)
            .clickable(
                interactionSource = interactionSource,
                indication = null
            ) {
                switchClicked = !switchClicked
                onSwitchClick()
            }
    ) {
        Row(modifier = Modifier
            .fillMaxSize()
            .padding(switchPadding)
        ) {
             Box(
                 modifier = Modifier
                     .fillMaxHeight()
                     .width(animateSize)
             )

            Box(
                modifier = Modifier
                    .size(switchSize)
                    .clip(CircleShape)
            ) {
                if (switchClicked) darkIcon()
                else lightIcon()
            }
        }
    }
}