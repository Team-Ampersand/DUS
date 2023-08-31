package com.dotori.dotori_components.components.bottom_navigate_bar

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.dotori.dotori_components.theme.HomeIcon
import com.dotori.dotori_components.theme.MassageChairIcon
import com.dotori.dotori_components.theme.NoticeBellIcon
import com.dotori.dotori_components.theme.SelfStudyIcon
import com.dotori.dotori_components.theme.WakeUpMusicIcon

@Composable
fun DotoriNavBarItem(
    modifier: Modifier = Modifier,
    type: DotoriNavBarItemType,
    isPressed: Boolean
) {
        when (type) {
            DotoriNavBarItemType.HOME -> HomeIcon(modifier = modifier, isPressed = isPressed)
            DotoriNavBarItemType.NOTICE -> NoticeBellIcon(modifier = modifier, isPressed = isPressed)
            DotoriNavBarItemType.SELF_STUDY -> SelfStudyIcon(modifier = modifier, isPressed = isPressed)
            DotoriNavBarItemType.MASSAGE_CHAIR -> MassageChairIcon(modifier = modifier, isPressed = isPressed)
            DotoriNavBarItemType.WAKE_UP_MUSIC -> WakeUpMusicIcon(modifier = modifier, isPressed = isPressed)
        }
}
