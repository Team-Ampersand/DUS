package com.dotori.dotori_components.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import java.time.LocalDate

@Composable
fun CalendarDayItem(
    modifier: Modifier = Modifier,
    day: LocalDate,
    selectedDay: LocalDate,
    onDayClicked: (LocalDate) -> Unit
) {
    val isSelected = selectedDay.isEqual(day)

    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(8.dp))
            .background(
                if (isSelected) DotoriTheme.colors.primary10 else DotoriTheme.colors.background
            )
            .clickable { onDayClicked(day) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = day.dayOfMonth.toString(),
            style = DotoriTheme.typography.body2,
            color = when {
                isSelected -> DotoriTheme.colors.neutral50
                selectedDay.monthValue != day.monthValue -> DotoriTheme.colors.neutral30
                else -> DotoriTheme.colors.neutral10
            }
        )
    }
}

@Preview
@Composable
fun DayItemPreview() {
    val day = LocalDate.now()
    val selectedDay = day.minusDays(1)
    val anotherMonth = day.minusMonths(1)

    Row {
        CalendarDayItem(
            modifier = Modifier.size(40.dp),
            day = day,
            selectedDay = selectedDay,
        ) {}
        CalendarDayItem(
            modifier = Modifier.size(40.dp),
            day = selectedDay,
            selectedDay = selectedDay,
        ) {}
        CalendarDayItem(
            modifier = Modifier.size(40.dp),
            day = anotherMonth,
            selectedDay = selectedDay,
        ) {}
    }
}