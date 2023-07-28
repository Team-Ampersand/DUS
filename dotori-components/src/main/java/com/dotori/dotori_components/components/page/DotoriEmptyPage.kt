package com.dotori.dotori_components.components.page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.utils.Types
import com.dotori.dotori_components.theme.DotoriTheme
import com.example.dus.R

@Composable
fun DotoriEmptyPage(mode: Types.CardType) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DotoriTheme.colors.background),
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            mode.EmptyPageImage(theme = DotoriTheme.isSystemIsDarkTheme())

            val title = mode.checkTitle()
            Text(
                modifier = Modifier.padding(top = 14.dp, bottom = 7.dp),
                text = "$title 신청한 인원이 없습니다..",
                style = DotoriTheme.typography.subTitle2,
                color = DotoriTheme.colors.neutral10
            )

            val subTitle = mode.checkSubTitle()
            Text(
                text = "홈에서 ${subTitle}을 해보세요!",
                style = DotoriTheme.typography.caption,
                color = DotoriTheme.colors.neutral20
            )
        }
    }
}

@Composable
fun Types.CardType.EmptyPageImage(theme: Boolean) {
    when (this) {
        Types.CardType.SELF_STUDY -> {
            val image = if (theme) R.drawable.empty_self_study_dark else R.drawable.empty_self_study_light
            Image(
                painter = painterResource(id = image),
                contentDescription = "empty image"
            )
        }
        Types.CardType.MASSAGE_CHAIR -> {
            val image = if (theme) R.drawable.empty_massage_chair_dark else R.drawable.empty_massage_chair_light
            Image(
                painter = painterResource(id = image),
                contentDescription = "empty image"
            )
        }
    }
}

fun Types.CardType.checkTitle(): String {
    return when(this) {
        Types.CardType.SELF_STUDY -> "자습"
        Types.CardType.MASSAGE_CHAIR -> "안마의자를"
    }
}

fun Types.CardType.checkSubTitle(): String {
    return when(this) {
        Types.CardType.SELF_STUDY -> "자습 신청"
        Types.CardType.MASSAGE_CHAIR -> "안마의자 신청"
    }
}