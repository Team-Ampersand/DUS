package com.dotori.dotori_components.components.notice

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.White

@Composable
fun DotoriNoticeListItem(
    modifier: Modifier = Modifier,
    writer: String,
    title: String,
    content: String,
    date: String,
    background: Color = DotoriTheme.colors.neutral50,
    focusColor: Color = DotoriTheme.colors.primary10
) {
    var isFocus by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .border(
                width = 2.dp,
                color = if (isFocus) focusColor else background,
                shape = RoundedCornerShape(8.dp)
            )
            .background(
                color = background,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) { isFocus = !isFocus },
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(12.dp)
                    .background(
                        color = when (writer) {
                            "도토리" -> DotoriTheme.colors.primary10
                            "사감 선생님" -> DotoriTheme.colors.subYellow
                            else -> DotoriTheme.colors.subRed
                        },
                        shape = CircleShape
                    )
            )
            Spacer(modifier = Modifier.width(4.dp))
            Text(
                text = writer,
                color = DotoriTheme.colors.neutral10,
                style = DotoriTheme.typography.smallTitle
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = date,
                color = DotoriTheme.colors.neutral20,
                style = DotoriTheme.typography.caption
            )
        }
        Text(
            text = title,
            color = DotoriTheme.colors.neutral20,
            style = DotoriTheme.typography.caption
        )
        Text(
            text = content,
            color = DotoriTheme.colors.neutral20,
            style = DotoriTheme.typography.caption,
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun DotoriNoticeListItemPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Column(
            modifier = Modifier.padding(horizontal = 20.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            DotoriNoticeListItem(
                modifier = Modifier.fillMaxWidth(),
                writer = "도토리",
                title = "[기숙사 자습실 사용 관련 공지]",
                content = "많은 분들이 급식의 화살표를 눌렀을때 날짜만 변경되는 점이 불편하다고 하여 이제는 급식",
                date = "2023.08.28"
            )
            DotoriNoticeListItem(
                modifier = Modifier.fillMaxWidth(),
                writer = "사감 선생님",
                title = "[기숙사 자습실 사용 관련 공지]",
                content = "운전모드를 반드시 냉방으로 맞춰야 합니다. 만약 난방으로 맞추고 가동할 경우 에어컨 가동이 중단 될 수 있습니다. 냉방 모드 설정 방법 - 디스플레이 하단에 조절 버튼 중 좌측 상단에 있는 버튼(Auto)을 사용하여 눈송이 표시가 나타나게 설정합니다. 리모컨에 잠금이 걸려있는 경우 - 온도 조절 버튼 2개를 동시에 누르면 잠금이 해제가 됩니다.",
                date = "2023.08.28"
            )
            DotoriNoticeListItem(
                modifier = Modifier.fillMaxWidth(),
                writer = "기숙사자치위원회",
                title = "[기숙사 자습실 사용 관련 공지]",
                content = "최근 자습 신청할 때 일학년이 매크로를 사용한다는 이야기가 많아 6월 3일까지 일학년 전체 자습금지 하겠습니다. 매크로를 사용한 학생은 이시완#7244 에 개인 디코 하시길 바랍니다. 또한 자습 신청을 한 후, 다른 학생에게 양도하는 행위 또한 자제해 주시길 바랍니다.",
                date = "2023.08.28"
            )
        }
    }
}