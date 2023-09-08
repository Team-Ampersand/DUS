package com.dotori.dotori_components.components.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.Transparent
import com.dotori.dotori_components.theme.White

@Composable
fun DotoriButton(
    modifier: Modifier = Modifier,
    text: String,
    colors: Color = DotoriTheme.colors.primary10,
    paddingValues: PaddingValues = PaddingValues(0.dp),
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
                modifier = Modifier.padding(paddingValues),
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
                modifier = Modifier.padding(paddingValues),
                text = text,
                style = DotoriTheme.typography.smallTitle
            )
        }
    }
}

@Preview
@Composable
fun DotoriButtonPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DotoriTheme.colors.background)
    ) {
        DotoriButton(
            text = "button",
            colors = DotoriTheme.colors.primary30,
        ) {}
        Spacer(modifier = Modifier.height(10.dp))

        DotoriButton(
            text = "button",
            colors = DotoriTheme.colors.primary10,
            paddingValues = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {}
        Spacer(modifier = Modifier.height(10.dp))

        DotoriButton(
            text = "button",
            colors = Transparent,
            paddingValues = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {}
        Spacer(modifier = Modifier.height(10.dp))

        DotoriButton(
            modifier = Modifier.fillMaxWidth(),
            text = "button",
            colors = DotoriTheme.colors.primary30,
            paddingValues = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {}
        Spacer(modifier = Modifier.height(10.dp))

        DotoriButton(
            modifier = Modifier.fillMaxWidth(),
            text = "button",
            colors = DotoriTheme.colors.primary10,
            paddingValues = PaddingValues(vertical = 8.dp, horizontal = 16.dp)
        ) {}
        Spacer(modifier = Modifier.height(10.dp))
    }
}