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
import com.dotori.dotori_components.theme.HomeIcon
import com.dotori.dotori_components.theme.MassageChairIcon
import com.dotori.dotori_components.theme.NoticeBellIcon
import com.dotori.dotori_components.theme.SelfStudyIcon
import com.dotori.dotori_components.theme.WakeUpMusicIcon

@Composable
fun DotoriNavBar(
    modifier: Modifier = Modifier,
    navigateToHome: () -> Unit,
    navigateToNotice: () -> Unit,
    navigateToSelfStudy: () -> Unit,
    navigateMassageChair: () -> Unit,
    navigateToWakeUpMusic: () -> Unit
) {
    var homeIconIsClicked by remember { mutableStateOf(false) }
    var noticeBellIconIsClicked by remember { mutableStateOf(false) }
    var selfStudyIconIsClicked by remember { mutableStateOf(false) }
    var massageChairIsClicked by remember { mutableStateOf(false) }
    var wakeUpMusicIconIsClicked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DotoriTheme.colors.cardBackground)
            .padding(
                vertical = 12.dp
            )
    ) {
        HomeIcon(
            modifier = Modifier
                .weight(1f)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    homeIconIsClicked = !homeIconIsClicked
                    navigateToHome()
                },
            isPressed = homeIconIsClicked
        )
        NoticeBellIcon(
            modifier = Modifier
                .weight(1f)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    noticeBellIconIsClicked = !noticeBellIconIsClicked
                    navigateToNotice()
                },
            isPressed = noticeBellIconIsClicked
        )
        SelfStudyIcon(
            modifier = Modifier
                .weight(1f)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    selfStudyIconIsClicked = !selfStudyIconIsClicked
                    navigateToSelfStudy()
                },
            isPressed = selfStudyIconIsClicked
        )
        MassageChairIcon(
            modifier = Modifier
                .weight(1f)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    massageChairIsClicked = !massageChairIsClicked
                    navigateMassageChair()
                },
            isPressed = massageChairIsClicked
        )
        WakeUpMusicIcon(
            modifier = Modifier
                .weight(1f)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    wakeUpMusicIconIsClicked = !wakeUpMusicIconIsClicked
                    navigateToWakeUpMusic()
                },
            isPressed = wakeUpMusicIconIsClicked
        )
    }
}

@Preview
@Composable
fun DotoriNavBarPreview() {
    DotoriNavBar(
        navigateToHome = { /*TODO*/ },
        navigateToNotice = { /*TODO*/ },
        navigateToSelfStudy = { /*TODO*/ },
        navigateMassageChair = { /*TODO*/ },
        navigateToWakeUpMusic = { /*TODO*/ }
    )
}
