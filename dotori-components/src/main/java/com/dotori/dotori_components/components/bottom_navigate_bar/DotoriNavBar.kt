package com.dotori.dotori_components.components.bottom_navigate_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme

@Composable
fun DotoriNavBar(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToNotice: () -> Unit,
    navigateToSelfStudy: () -> Unit,
    navigateToMassageChair: () -> Unit,
    navigateToWakeUpMusic: () -> Unit
) {
    var isPressed by remember { mutableStateOf(-1) }
    val itemList = listOf(DotoriNavBarItemType.HOME, DotoriNavBarItemType.NOTICE, DotoriNavBarItemType.SELF_STUDY, DotoriNavBarItemType.MASSAGE_CHAIR, DotoriNavBarItemType.WAKE_UP_MUSIC)

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DotoriTheme.colors.cardBackground)
            .padding(
                vertical = 12.dp
            )
    ) {
        repeat(itemList.size) {
            DotoriNavBarItem(
                modifier = Modifier
                    .weight(1f)
                    .clickable(
                        interactionSource = MutableInteractionSource(),
                        indication = null,
                        onClick = {
                            isPressed = it
                            when (itemList[it]) {
                                DotoriNavBarItemType.HOME -> navigateToHome()
                                DotoriNavBarItemType.NOTICE -> navigateToNotice()
                                DotoriNavBarItemType.SELF_STUDY -> navigateToSelfStudy()
                                DotoriNavBarItemType.MASSAGE_CHAIR -> navigateToMassageChair()
                                DotoriNavBarItemType.WAKE_UP_MUSIC -> navigateToWakeUpMusic()
                            }
                        }
                    ),
                type = itemList[it],
                isPressed = isPressed == it
            )
        }
    }
}

@Preview
@Composable
fun DotoriNavBarPreview() {
    DotoriNavBar(
        navigateToHome = { /*TODO*/ },
        navigateToNotice = { /*TODO*/ },
        navigateToSelfStudy = { /*TODO*/ },
        navigateToMassageChair = { /*TODO*/ },
        navigateToWakeUpMusic = { /*TODO*/ }
    )
}
