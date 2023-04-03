package com.dotori.dotori_components.components.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.dotori.dotori_components.theme.DotoriColor.CardBackGround

@Composable
fun DotoriDialog(
    modifier: Modifier = Modifier,
    onDismiss: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    val color = CardBackGround

    Dialog(
        onDismissRequest = { onDismiss() }
    ) {
        Box(
            modifier = modifier
                .background(
                    color = color,
                    shape = RoundedCornerShape(16.dp)
                )
                .padding(24.dp)
        ) {
            content()
        }
    }
}