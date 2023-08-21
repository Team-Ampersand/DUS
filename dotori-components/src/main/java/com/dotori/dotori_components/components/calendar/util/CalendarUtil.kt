package com.dotori.dotori_components.components.calendar.util

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

private const val DAYS_IN_WEEK = 7

fun LocalDate.getDaysOfMonth(): List<LocalDate> {
    val startOfMonth = this.withDayOfMonth(1)
    val startOfMonthIndex = startOfMonth.dayOfWeek.value % DAYS_IN_WEEK

    val endOfMonth = this.withDayOfMonth(this.lengthOfMonth())
    val endOfMonthIndex = endOfMonth.dayOfWeek.value % DAYS_IN_WEEK

    val firstSunday = startOfMonth.with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
    val daysBeforeMonth = (0 until startOfMonthIndex).map {
        firstSunday.plusDays(it.toLong())
    }

    val daysInMonth = (1..lengthOfMonth()).map {
        LocalDate.of(this.year, this.monthValue, it)
    }

    val daysAfterMonth = (1 .. 6 - endOfMonthIndex).map {
        endOfMonth.plusDays(it.toLong())
    }

    return listOf(daysBeforeMonth, daysInMonth, daysAfterMonth).flatten()
}