package com.dotori.dotori_components.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.Transparent
import com.dotori.dotori_components.theme.White

@Composable
fun DotoriButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: Color = DotoriTheme.colors.primary10,
    onClick: () -> Unit
) {
    if (colors == Transparent) {
        OutlinedButton(
            modifier = modifier,
            border = BorderStroke(1.dp, DotoriTheme.colors.neutral30),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Transparent,
                contentColor = DotoriTheme.colors.neutral20
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = onClick
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = text,
                style = DotoriTheme.typography.smallTitle
            )
        }
    } else {
        Button(
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colors,
                contentColor = White
            ),
            shape = RoundedCornerShape(8.dp),
            onClick = onClick
        ) {
            Text(
                modifier = Modifier.padding(horizontal = 15.dp),
                text = text,
                style = DotoriTheme.typography.smallTitle
            )
        }
    }
}