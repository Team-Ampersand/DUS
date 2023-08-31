package com.dotori.dotori_components.components.card

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.button.DotoriButton
import com.dotori.dotori_components.components.utils.RoleType
import com.dotori.dotori_components.components.utils.Types
import com.dotori.dotori_components.theme.ArrowRight2Icon
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.RefreshIcon
import com.dotori.dotori_components.theme.SettingIcon

@Composable
fun DotoriMainCard(
    modifier: Modifier = Modifier,
    count: Int,
    limit: Int,
    role: String,
    mode: Types.CardType,
    arrowClick: () -> Unit,
    settingClick: () -> Unit,
    refreshClick: () -> Unit,
    buttonClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(10 / 7f),
        color = DotoriTheme.colors.cardBackground,
        shape = RoundedCornerShape(16.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(bottom = 16.dp)
            ) {
                val titleText = mode.checkTitle()
                Text(
                    text = titleText,
                    style = DotoriTheme.typography.subTitle2,
                    color = DotoriTheme.colors.neutral10
                )

                if (role != RoleType.ROLE_MEMBER.toString()) {
                    SettingIcon(
                        modifier = Modifier.clickable { settingClick() },
                        tint = DotoriTheme.colors.neutral10,
                        contentDescription = "change total members"
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                RefreshIcon(
                    modifier = Modifier
                        .padding(end = 16.dp)
                        .clickable { refreshClick() },
                    tint = DotoriTheme.colors.neutral10,
                    contentDescription = "refresh icon"
                )

                ArrowRight2Icon(
                    modifier = Modifier.clickable { arrowClick() },
                    tint = DotoriTheme.colors.neutral10,
                    contentDescription = "arrow left"
                )
            }

            Spacer(modifier = Modifier.weight(0.33f))

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "$count / $limit",
                style = DotoriTheme.typography.h2,
                color = DotoriTheme.colors.neutral10
            )

            Spacer(modifier = Modifier.weight(0.33f))

            val progress = count.toFloat() / limit.toFloat()    // 진행도
            val progressColor =
                if (progress <= 0.5f) DotoriTheme.colors.subGreen
                else if (progress <= 0.8f) DotoriTheme.colors.subYellow
                else DotoriTheme.colors.subRed

            LinearProgressIndicator(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(20.dp)
                    .clip(RoundedCornerShape(4.dp)),
                progress = progress,
                color = progressColor,
                backgroundColor = DotoriTheme.colors.neutral50
            )

            Spacer(modifier = Modifier.weight(0.33f))

            val modeText = mode.checkMode()
            DotoriButton(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(17 / 3f)
                    .clip(RoundedCornerShape(8.dp)),
                text = "$modeText 신청",
                onClick = buttonClick
            )
        }
    }
}

fun Types.CardType.checkMode(): String {
    return when (this) {
        Types.CardType.SELF_STUDY -> "자습"
        Types.CardType.MASSAGE_CHAIR -> "안마"
    }
}

fun Types.CardType.checkTitle(): String {
    return when (this) {
        Types.CardType.SELF_STUDY -> "자습신청"
        Types.CardType.MASSAGE_CHAIR -> "안마의자"
    }
}

@Preview
@Composable
fun DotoriMainCardPreview() {
    DotoriMainCard(
        count = 10,
        limit = 50,
        role = "ROLE_MEMBER",
        mode = Types.CardType.SELF_STUDY,
        arrowClick = { /*TODO*/ },
        settingClick = {/*TODO*/ },
        refreshClick = {/*TODO*/ },
        buttonClick = { /*TODO*/ },
    )
}