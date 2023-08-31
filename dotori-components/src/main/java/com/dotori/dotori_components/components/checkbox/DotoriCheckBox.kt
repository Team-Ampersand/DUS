package com.dotori.dotori_components.components.checkbox

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.CheckIcon
import com.dotori.dotori_components.theme.DotoriTheme

@Composable
@OptIn(ExperimentalMaterialApi::class)
fun DotoriCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean = false,
    onCheckedChange: (Boolean) -> Unit
) {
    var checkBoxState by remember { mutableStateOf(checked) }

    Card(
        modifier = modifier
            .size(24.dp),
        shape = RoundedCornerShape(10.dp),
        onClick = {
            checkBoxState = !checkBoxState
            onCheckedChange(checkBoxState)
        },
        elevation = 0.dp
    ) {
        if (checkBoxState) DotoriCheckBoxSelected()
        else DotoriCheckBoxUnSelected()
    }
}

@Composable
private fun DotoriCheckBoxSelected() {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(DotoriTheme.colors.primary10),
        contentAlignment = Alignment.Center
    ) {
        CheckIcon(contentDescription = "check icon")
    }
}

@Composable
private fun DotoriCheckBoxUnSelected() {
    Box(
        modifier = Modifier
            .size(24.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(DotoriTheme.colors.background)
            .border(
                width = 1.dp,
                color = DotoriTheme.colors.neutral30,
                shape = RoundedCornerShape(10.dp)
            ),
    )
}

@Preview
@Composable
private fun DotoriCheckBoxPreview() {
    var checkState by remember { mutableStateOf(true) }

    Box(
        modifier = Modifier.fillMaxSize()
            .background(DotoriTheme.colors.background),
    ) {
        DotoriCheckBox(
            modifier = Modifier.padding(40.dp),
            onCheckedChange = { checkState = it }
        )
    }
}