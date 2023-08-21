package com.dotori.dotori_components.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme

private val dayOfWeeks = listOf("일", "월", "화", "수", "목", "금", "토")

@Composable
fun CalendarWeekBar(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.background(color = DotoriTheme.colors.cardBackground),
        horizontalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        dayOfWeeks.forEach { day ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .aspectRatio(1f),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = day,
                    color = DotoriTheme.colors.neutral30,
                    style = DotoriTheme.typography.smallTitle
                )
            }
        }
    }
}

@Composable
@Preview
fun CalendarWeekBarPreview() {
    CalendarWeekBar()
}