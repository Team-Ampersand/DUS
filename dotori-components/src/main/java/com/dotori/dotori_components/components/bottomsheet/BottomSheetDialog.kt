package com.dotori.dotori_components.components.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.button.DotoriButton
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
        sheetContent = { sheetContent() },
        sheetBackgroundColor = sheetBackgroundColor,
        sheetShape = sheetShape
    ) {
        content(sheetState)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun DotoriBottomSheetDialogPreview() {
    val coroutineScope = rememberCoroutineScope()

    DotoriBottomSheetDialog(
        sheetContent = {
            Text(text = "test")
        }
    ) { sheetState ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DotoriTheme.colors.background)
        ) {
            DotoriButton(text = "show") {
                coroutineScope.launch {
                    sheetState.show()
                }
            }
        }
    }
}
