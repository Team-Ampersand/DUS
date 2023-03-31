package com.dotori.dotori_components.components.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.utils.Types.BottomSheetType
import com.dotori.dotori_components.theme.DotoriDarkColor
import com.dotori.dotori_components.theme.DotoriLightColor

@Composable
fun DotoriBottomSheet(
    sheetContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    sheetShape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    type: BottomSheetType,
    content: @Composable () -> Unit
) {
    val sheetBackgroundColor = backgroundColorFor(type)

    Box(modifier) {
        DotoriBottomSheetStack(
            body = {
                Column(modifier = Modifier.fillMaxSize()) {
                    content()
                }
            }
        ) {
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .clip(sheetShape)
            ) {
                Column(
                    modifier = modifier
                        .background(sheetBackgroundColor)
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp, vertical = 32.dp)
                ) {
                    sheetContent()
                }
            }
        }
    }
}

@Composable
fun DotoriBottomSheetStack(
    body: @Composable () -> Unit,
    bottomSheet: @Composable () -> Unit
) {
    Layout(
        content = {
            body()
            bottomSheet()
        }
    ) { measurable, constraints ->
        val placeable = measurable.first().measure(constraints)

        layout(placeable.width, placeable.height) {
            placeable.placeRelative(0, 0)

            val (sheetPlaceable) = measurable.drop(1).map {
                it.measure(constraints.copy(minWidth = 0, minHeight = 0))
            }
            sheetPlaceable.placeRelative(0, constraints.maxHeight - sheetPlaceable.height)
        }
    }
}

@Composable
private fun backgroundColorFor(type: BottomSheetType): Color =
    when (type) {
        BottomSheetType.LIGHT -> DotoriLightColor.CardBackGround
        BottomSheetType.DARK -> DotoriDarkColor.CardBackGround
    }