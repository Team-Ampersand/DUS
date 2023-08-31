package com.dotori.dotori_components.components.drawer.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriLogoIcon
import com.dotori.dotori_components.theme.DotoriText
import com.dotori.dotori_components.theme.DotoriTheme

@Composable
fun DrawerViewHeader() {
    Row(
        modifier = Modifier
            .padding(start = 23.dp, top = 18.5.dp, end = 31.dp, bottom = 18.5.dp)
            .background(DotoriTheme.colors.background),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DotoriLogoIcon()
        DotoriText()
    }
}

@Preview
@Composable
private fun DrawerViewHeaderPre() {
    DrawerViewHeader()
}