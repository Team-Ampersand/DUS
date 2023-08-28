package com.dotori.dotori_components.components.role

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.utils.RoleType
import com.dotori.dotori_components.theme.DotoriTheme

@Composable
fun DotoriRoleBadge(
    modifier: Modifier = Modifier,
    role: String
) {
    val badgeColor = when (role) {
        RoleType.ROLE_MEMBER.toString() -> DotoriTheme.colors.neutral20
        RoleType.ROLE_COUNCILLOR.toString() -> DotoriTheme.colors.subRed
        RoleType.ROLE_DEVELOPER.toString() -> DotoriTheme.colors.primary10
        else -> DotoriTheme.colors.subYellow
    }

    val badgeTitle = when (role) {
        RoleType.ROLE_MEMBER.toString() -> "학생"
        RoleType.ROLE_COUNCILLOR.toString() -> "자치위원회"
        RoleType.ROLE_DEVELOPER.toString() -> "개발자"
        else -> "사감선생님"
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .border(
                border = BorderStroke(width = 1.dp, color = badgeColor),
                shape = CircleShape
            )
            .padding(horizontal = 8.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .clip(CircleShape)
                    .background(badgeColor)
            )

            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = badgeTitle,
                style = DotoriTheme.typography.smallTitle,
                color = badgeColor
            )
        }
    }
}

@Preview
@Composable
fun DotoriBadgePreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DotoriTheme.colors.background)
    ) {
        DotoriRoleBadge(role = "ROLE_DEVELOPER")
        DotoriRoleBadge(role = "ROLE_COUNCILLOR")
        DotoriRoleBadge(role = "ROLE_ADMIN")
        DotoriRoleBadge(role = "ROLE_MEMBER")
    }
}