package com.dotori.dotori_components.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.utils.Types
import com.dotori.dotori_components.theme.DotoriButtonColor
import com.dotori.dotori_components.theme.DotoriButtonContentColor

@Composable
fun DotoriButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: Types.ButtonType,
    text: String
) {
    if (colors == Types.ButtonType.TRANSPARENT) {
        OutlinedButton(
            onClick = onClick,
            modifier = modifier,
            border = BorderStroke(1.dp, Color(0xFFBBBBCC)),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = DotoriButtonColor.Transparent,
                contentColor = DotoriButtonContentColor.ButtonContentGray
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = text, modifier = Modifier.padding(horizontal = 15.dp))
        }
    } else {
        Button(
            onClick = onClick,
            modifier = modifier,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = when (colors) {
                    Types.ButtonType.LIGHTBLUE -> DotoriButtonColor.LightBlue
                    Types.ButtonType.BLUE -> DotoriButtonColor.Blue
                    Types.ButtonType.DARKBLUE -> DotoriButtonColor.DarkBlue
                    else -> DotoriButtonColor.DarkBlue
                },
                contentColor = DotoriButtonContentColor.ButtonContentWhite
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Text(text = text, modifier = Modifier.padding(horizontal = 15.dp))
        }
    }
}

@Composable
fun DotoriLongButton(
    onClick: () -> Unit,
    colors: Types.LongButtonType,
    text: String,
    horizontalPaddingValue: Dp = 10.dp
) {
    Button(
        onClick = onClick,
        modifier = Modifier.fillMaxWidth()
            .padding(start = horizontalPaddingValue, end = horizontalPaddingValue),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = when (colors) {
                Types.LongButtonType.BLUE -> DotoriButtonColor.Blue
                Types.LongButtonType.LIGHTBLUE -> DotoriButtonColor.LightBlue
                Types.LongButtonType.DARKBLUE -> DotoriButtonColor.DarkBlue
            },
            contentColor = DotoriButtonContentColor.ButtonContentWhite
        ),
        shape = RoundedCornerShape(8.dp),
    ) {
        Text(text = text)
    }
}

