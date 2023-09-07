package com.dotori.dotori_components.components.bottomsheet

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import kotlinx.coroutines.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DotoriBottomSheetDialog(
    modifier: Modifier = Modifier,
    sheetShape: Shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
    sheetContent: @Composable ColumnScope.() -> Unit,
    content: @Composable (sheetState: ModalBottomSheetState) -> Unit
) {
    val sheetBackgroundColor = DotoriTheme.colors.cardBackground
    val sheetState = rememberModalBottomSheetState(initialValue = ModalBottomSheetValue.Hidden)

    ModalBottomSheetLayout(
        modifier = modifier,
        sheetState = sheetState,
        sheetContent = {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 32.dp)
            ) {
                sheetContent()
            }
        },
        sheetBackgroundColor = sheetBackgroundColor,
        sheetShape = sheetShape
    ) {
        content(sheetState)
    }
}
