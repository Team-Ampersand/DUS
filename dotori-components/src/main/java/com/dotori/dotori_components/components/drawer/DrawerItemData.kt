package com.dotori.dotori_components.components.drawer

data class DrawerItemData(
    val title: String,
    val onClick: () -> Unit,
    val icon: Icons
)
