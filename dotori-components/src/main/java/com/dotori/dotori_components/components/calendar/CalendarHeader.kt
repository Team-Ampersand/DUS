package com.dotori.dotori_components.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.ArrowLeftIcon
import com.dotori.dotori_components.theme.ArrowRightIcon
import com.dotori.dotori_components.theme.DotoriTheme
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun CalendarHeader(
    modifier: Modifier = Modifier,
    title: LocalDate,
    onLeftClicked: () -> Unit,
    onRightClicked: () -> Unit
) {
    val dayOfWeek = title.dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN)
    val formattedDate = DateTimeFormatter.ofPattern("yyyy.MM.dd").format(title)

    Row(
        modifier = modifier.background(color = DotoriTheme.colors.cardBackground),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        ArrowLeftIcon(
            modifier = Modifier.clickable { onLeftClicked() },
            contentDescription = "previous",
            tint = DotoriTheme.colors.neutral10
        )
        Text(
            text = "$formattedDate ($dayOfWeek)",
            style = DotoriTheme.typography.body,
            color = DotoriTheme.colors.neutral10
        )
        ArrowRightIcon(
            modifier = Modifier.clickable { onRightClicked() },
            contentDescription = "next",
            tint = DotoriTheme.colors.neutral10
        )
    }
}

@Preview
@Composable
fun CalendarHeaderPreview() {
    var date by remember { mutableStateOf(LocalDate.now()) }

    CalendarHeader(
        title = date,
        onLeftClicked = { date = date.minusMonths(1) },
        onRightClicked = { date = date.plusMonths(1)}
    )
}