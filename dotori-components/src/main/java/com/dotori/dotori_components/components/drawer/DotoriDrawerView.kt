package com.dotori.dotori_components.components.drawer

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.drawer.content.DrawerViewHeader
import com.dotori.dotori_components.theme.DotoriTheme
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DotoriDrawerView(
    modifier: Modifier = Modifier,
    itemList: List<DrawerItemData>,
    content: @Composable (openDrawer: () -> Unit) -> Unit,
) {
    val scaffoldState = rememberScaffoldState()

    val coroutineScope = rememberCoroutineScope()
    val openDrawer: () -> Unit = { coroutineScope.launch { scaffoldState.drawerState.open() } }
    val closeDrawer: () -> Unit = { coroutineScope.launch { scaffoldState.drawerState.close() } }

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        drawerBackgroundColor = DotoriTheme.colors.background,
        drawerContent = {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(vertical = 24.dp, horizontal = 32.dp),
            ) {
                DrawerViewHeader()
                Spacer(modifier = Modifier.height(32.dp))
                DrawerBody(itemList = itemList, closeDrawer = closeDrawer)
            }
        }, content = {
            content(openDrawer = openDrawer)
        }
    )
}

@Preview
@Composable
private fun DotoriDrawerPre() {
    DotoriDrawerView(itemList = listOf(
        DrawerItemData(
            title = "학생 정보",
            icon = Icons.Person,
            onClick = {}),
        DrawerItemData(
            title = "규정 위반",
            icon = Icons.Violation,
            onClick = {}
        )
    )
    ) { openDrawer ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Yellow)
        ) {
            Button(modifier = Modifier.align(Alignment.Center), onClick = openDrawer) {
                Text(text = "Test")
            }
        }
    }
}