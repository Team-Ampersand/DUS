package com.dotori.dotori_components.components.drawer

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun DrawerBody(itemList: List<DrawerItemData>, closeDrawer: () -> Unit) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(itemList) { data ->
            DrawerContent(data = data, closeDrawer = closeDrawer)
        }
    }
}

@Preview
@Composable
private fun DrawerBodyPre() {
    DrawerBody(itemList = listOf(
        DrawerItemData(
            title = "학생 정보",
            icon = Icons.Person,
            onClick = {}),
        DrawerItemData(
            title = "규정 위반",
            icon = Icons.Violation,
            onClick = {}
        )
    )) {}
}