package com.dotori.dotori_components.components.menu

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.button.DotoriButton
import com.dotori.dotori_components.theme.DotoriTheme

@Composable
fun DotoriDropDownMenu(
    modifier: Modifier = Modifier,
    expanded: Boolean = false,
    onDismissRequest: () -> Unit,
    content: @Composable (ColumnScope.() -> Unit)
) {
    MaterialTheme(
        colors = MaterialTheme.colors.copy(surface = DotoriTheme.colors.cardBackground),
        shapes = MaterialTheme.shapes.copy(medium = RoundedCornerShape(16.dp))
    ) {
        DropdownMenu(
            modifier = modifier,
            expanded = expanded,
            onDismissRequest = onDismissRequest,
            content = content
        )
    }
}

@Composable
fun DotoriDropDownMenuItem(
    modifier: Modifier = Modifier,
    title: String,
    itemWidth: Dp = 240.dp,
    itemHeight: Dp = 48.dp,
    onClick: () -> Unit
) {
    DropdownMenuItem(
        modifier = modifier.size(width = itemWidth, height = itemHeight),
        onClick = onClick
    ) {
        Text(
            text = title,
            style = DotoriTheme.typography.smallTitle,
            color = DotoriTheme.colors.neutral10
        )
    }
}

@Preview
@Composable
fun DotoriDropDownMenuPreview() {
    var dropDownMenu by remember { mutableStateOf(false) }

    DotoriButton(text = "drop down") {
        dropDownMenu = true
    }

    DotoriDropDownMenu(
        expanded = dropDownMenu,
        onDismissRequest = { dropDownMenu = false }
    ) {
        DotoriDropDownMenuItem(title = "item1") {

        }
        DotoriDropDownMenuItem(title = "item2") {

        }
        DotoriDropDownMenuItem(title = "item3") {

        }
    }
}