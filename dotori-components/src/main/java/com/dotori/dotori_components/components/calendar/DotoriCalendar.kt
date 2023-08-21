package com.dotori.dotori_components.components.calendar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.calendar.util.getDaysOfMonth
import com.dotori.dotori_components.theme.DotoriTheme
import java.time.LocalDate

@Composable
fun DotoriCalendar(
    modifier: Modifier = Modifier,
) {
    var selectedDay by remember { mutableStateOf(LocalDate.now()) }

    Column(
        modifier = modifier
            .background(color = DotoriTheme.colors.cardBackground)
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CalendarHeader(
            modifier = Modifier.padding(top = 32.dp, bottom = 16.dp),
            title = selectedDay,
            onLeftClicked = { selectedDay = selectedDay.minusMonths(1) },
            onRightClicked = { selectedDay = selectedDay.plusMonths(1) }
        )
        CalendarWeekBar(modifier = Modifier.padding(horizontal = 2.dp))
        LazyVerticalGrid(
            modifier = Modifier
                .padding(top = 8.dp, bottom = 21.dp)
                .clip(RoundedCornerShape(8.dp))
                .background(DotoriTheme.colors.background),
            columns = GridCells.Fixed(7),
            userScrollEnabled = false
        ) {
            items(selectedDay.getDaysOfMonth()) { day ->
                CalendarDayItem(
                    day = day,
                    selectedDay = selectedDay
                ) {
                    selectedDay = it
                }
            }
        }
    }
}

@Preview
@Composable
fun DotoriCalendarPreview() {
    DotoriCalendar()
}