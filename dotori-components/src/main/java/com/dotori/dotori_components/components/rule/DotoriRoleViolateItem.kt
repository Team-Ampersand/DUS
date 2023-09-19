package com.dotori.dotori_components.components.rule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.utils.RoleViolateType
import com.dotori.dotori_components.components.utils.roleTypeMap
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.TrashCanIcon
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DotoriRoleViolateItem(
    modifier: Modifier = Modifier,
    violateText: String,
    violateDate: String,
    onDeleteClick: () -> Unit
) {
    val violateType = enumValueOf<RoleViolateType>(violateText)

    Surface(
        modifier = modifier
            .fillMaxWidth()
            .background(DotoriTheme.colors.background)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "${roleTypeMap[violateType]}",
                style = DotoriTheme.typography.body,
                color = DotoriTheme.colors.neutral10
            )

            Spacer(modifier = Modifier.weight(1f))

            val inputDate = LocalDate.parse(violateDate)
            val dateFormat = DateTimeFormatter.ofPattern("yyyy. MM. dd.")
            val formatDate = inputDate.format(dateFormat)
            Text(
                modifier = Modifier.padding(end = 16.dp),
                text = formatDate,
                style = DotoriTheme.typography.body2,
                color = DotoriTheme.colors.neutral20
            )

            TrashCanIcon(
                modifier = Modifier
                    .size(24.dp)
                    .clickable { onDeleteClick() },
                tint = DotoriTheme.colors.error,
                contentDescription = "delete role violation"
            )
        }
    }
}

@Preview
@Composable
fun DotoriRoleViolateItemPreview() {
    DotoriRoleViolateItem(
        violateText = "FIREARMS",
        violateDate = "2023-08-29"
    ) {

    }
}