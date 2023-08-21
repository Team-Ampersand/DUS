package com.dotori.dotori_components.components.calendar.util

import java.time.LocalDate

private const val DAYS_IN_WEEK = 7

fun LocalDate.getDaysOfMonth(): List<LocalDate> {
    val startOfMonth = this.withDayOfMonth(1)
    val endOfMonth = this.withDayOfMonth(this.lengthOfMonth())

    val daysBeforeMonth = (1 until startOfMonth.dayOfWeek.value).map {
        startOfMonth.minusDays(it.toLong())
    }

    val daysInMonth = (1..lengthOfMonth()).map {
        LocalDate.of(this.year, this.monthValue, it)
    }

    val daysAfterMonth = (1.. DAYS_IN_WEEK - (endOfMonth.dayOfWeek.value)).map {
        endOfMonth.plusDays(it.toLong())
    }

    return listOf(daysBeforeMonth, daysInMonth, daysAfterMonth).flatten()
}