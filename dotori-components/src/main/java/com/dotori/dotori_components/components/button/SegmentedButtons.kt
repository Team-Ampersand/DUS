package com.dotori.dotori_components.components.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.Transparent

@Composable
fun DotoriSegmentedButtons(
    modifier: Modifier = Modifier,
    rowPadding: Dp,
    textPadding: Dp,
    outRoundedCornerShape: Dp,
    innerRoundedCornerShape: Dp,
    list: List<String>,
    onSwitchClick: (Int) -> Unit
) {
    var selectedButtonIndex by remember { mutableStateOf(0) }

    Box(modifier = modifier) {
        Box(
            modifier = Modifier.background(
                color = DotoriTheme.colors.neutral50,
                shape = RoundedCornerShape(outRoundedCornerShape)
            ),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(rowPadding),
            ) {
                list.forEachIndexed { index, text ->
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f)
                            .background(
                                color = if (selectedButtonIndex == index) DotoriTheme.colors.cardBackground else DotoriTheme.colors.neutral50,
                                shape = RoundedCornerShape(innerRoundedCornerShape)
                            )
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = null
                            ) {
                                selectedButtonIndex = index
                                onSwitchClick(index)
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
}

@Preview
@Composable
fun preview() {
    var list = mutableListOf("남", "여")
    Column(modifier = Modifier
        .fillMaxSize()
        .background(DotoriTheme.colors.background)) {
        DotoriSegmentedButtons(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            textPadding = 10.dp,
            rowPadding = 6.dp,
            outRoundedCornerShape = 8.dp,
            innerRoundedCornerShape = 4.dp,
            list = list,
            onSwitchClick = {}
        )
    }
}
