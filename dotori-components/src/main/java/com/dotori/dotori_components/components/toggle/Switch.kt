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
    modifier: Modifier,
    switchPadding: Dp = 5.dp,
    buttonWidth: Dp = 70.dp,
    buttonHeight: Dp = 40.dp,
    isChecked: Boolean = false,
    lightIcon: @Composable () -> Unit = { LightSwitchIcon(contentDescription = "light switch") },
    darkIcon: @Composable () -> Unit = { DarkSwitchIcon(contentDescription = "dark switch") },
    onSwitchClick: (Boolean) -> Unit
) {
    val switchSize by remember { mutableStateOf(buttonHeight-switchPadding*2) } // 버튼의 width 크기
    val interactionSource = remember { MutableInteractionSource() }
    var switchClicked by remember { mutableStateOf(isChecked) }
    val moveDp = if (switchClicked) buttonWidth-switchSize-switchPadding*2 else 0.dp

    val animateSize by animateDpAsState(
        targetValue = if (switchClicked) moveDp else 0.dp,
        tween(
            durationMillis = 150,
            delayMillis = 0,
            easing = LinearOutSlowInEasing
        )
    )

    // 버튼 영역
    // 버튼의 위치 정하기
    Box(
        modifier = modifier
    ) {
        Box(    // 기본적인 modifier 속성
            modifier = Modifier
                .width(buttonWidth)
                .height(buttonHeight)
                .clip(CircleShape)
                .background(if (switchClicked) DotoriColor.Black else DotoriColor.Natural40)
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
                    if (switchClicked) darkIcon()
                    else lightIcon()
                }
            }
        }
    }
}