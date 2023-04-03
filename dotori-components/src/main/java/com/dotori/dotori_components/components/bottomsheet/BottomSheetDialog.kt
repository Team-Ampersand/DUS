package com.dotori.dotori_components.components.bottomsheet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.utils.Types
import com.dotori.dotori_components.theme.DotoriDarkColor
import com.dotori.dotori_components.theme.DotoriLightColor
import kotlinx.coroutines.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DotoriBottomSheetDialog(
    modifier: Modifier = Modifier,
    sheetShape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    sheetPeekHeight: Dp = 0.dp,
    type: Types.BottomSheetType,
    sheetTopContent: @Composable ColumnScope.() -> Unit,
    sheetBottomContent: @Composable ColumnScope.() -> Unit,
    content: @Composable (sheetState: BottomSheetState) -> Unit
) {
    val sheetBackgroundColor = backgroundColorFor(type)
    val sheetState = rememberBottomSheetState(initialValue = BottomSheetValue.Collapsed)
    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = sheetState)

    BottomSheetScaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 32.dp)
            ) {
                sheetTopContent()
                Spacer(modifier = modifier.height(32.dp))
                sheetBottomContent()
            }
        },
        sheetPeekHeight = sheetPeekHeight,
        sheetBackgroundColor = sheetBackgroundColor,
        sheetShape = sheetShape
    ) {
        content(sheetState)
    }
}

@Composable
private fun backgroundColorFor(type: Types.BottomSheetType): Color =
    when (type) {
        Types.BottomSheetType.LIGHT -> DotoriLightColor.CardBackGround
        Types.BottomSheetType.DARK -> DotoriDarkColor.CardBackGround
    }