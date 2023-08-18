package com.dotori.dotori_components.components.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme

@Composable
fun DotoriSegmentedButtons(
    modifier: Modifier = Modifier,
    sectionNames: List<String>,
    rowPadding: Dp,
    textPadding: Dp,
    outRoundedCornerShape: Dp,
    innerRoundedCornerShape: Dp,
    onSwitchClick: () -> Unit
) {
    var selectedButtonIndex by remember { mutableStateOf(0) }

    Box(
        modifier = modifier.background(
            color = DotoriTheme.colors.neutral50,
            shape = RoundedCornerShape(outRoundedCornerShape)
        ),
    ) {
        Row(modifier = Modifier.padding(rowPadding)) {
            sectionNames.forEachIndexed { index, text ->
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(
                            color = backgroundColor(
                                selectedButtonIndex = selectedButtonIndex,
                                index = index
                            ),
                            shape = RoundedCornerShape(innerRoundedCornerShape)
                        )
                        .clickable(
                            interactionSource = MutableInteractionSource(),
                            indication = null
                        ) {
                            selectedButtonIndex = index
                            onSwitchClick()
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = textPadding),
                        text = text,
                        style = DotoriTheme.typography.subTitle2,
                        color = DotoriTheme.colors.neutral10
                    )
                }
            }
        }
    }
}

@Composable
fun backgroundColor(
    selectedButtonIndex: Int,
    index: Int
) = animateColorAsState(
    targetValue = if (selectedButtonIndex == index) DotoriTheme.colors.cardBackground else DotoriTheme.colors.neutral50,
    animationSpec = tween(easing = LinearOutSlowInEasing)
).value


@Preview
@Composable
fun DotoriSegmentedButtonsPreview() {
    var list = mutableListOf("남", "여")
    var list1 = mutableListOf("아침", "점심", "저녁")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DotoriTheme.colors.background)
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        DotoriSegmentedButtons(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            textPadding = 10.dp,
            rowPadding = 6.dp,
            outRoundedCornerShape = 8.dp,
            innerRoundedCornerShape = 4.dp,
            sectionNames = list,
            onSwitchClick = {}
        )
        Spacer(modifier = Modifier.height(20.dp))
        DotoriSegmentedButtons(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            textPadding = 13.dp,
            rowPadding = 4.dp,
            outRoundedCornerShape = 4.dp,
            innerRoundedCornerShape = 8.dp,
            sectionNames = list1,
            onSwitchClick = {}
        )
    }
}
