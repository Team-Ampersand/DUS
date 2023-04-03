package com.dotori.dotori_components.theme

import androidx.appcompat.app.AppCompatDelegate
import androidx.compose.ui.graphics.Color
import com.dotori.dotori_components.components.utils.Theme

object DotoriColor {
    // 현재 테마를 가져옵니다.
    private val currentTheme: Theme
        get() = when(AppCompatDelegate.getDefaultNightMode()) {
            AppCompatDelegate.MODE_NIGHT_YES -> Theme.DARK
            else -> Theme.LIGHT
        }

    val Black = Color(0xFF000000)
    val White = Color(0xFFFFFFFF)
    val Transparent = Color(0x00000000)


    val Error = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFD84D4D)
        Theme.DARK -> Color(0xFFFF7D7D)
    }
    val Positive = when(currentTheme) {
        Theme.LIGHT -> Color(0xFF2E8546)
        Theme.DARK -> Color(0xFF5EFF8B)
    }

    val Primary10 = when(currentTheme) {
        Theme.LIGHT -> Color(0xFF6F7AEC)
        Theme.DARK -> Color(0xFF5966E9)
    }
    val Primary20 = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFEEF0FD)
        Theme.DARK -> Color(0xFF1D2136)
    }
    val Primary30 = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFC5CAF7)
        Theme.DARK -> Color(0xFF24295D)
    }

    val Neutral10 = when(currentTheme) {
        Theme.LIGHT -> Color(0xFF292E3D)
        Theme.DARK -> Color(0xFF24295D)
    }
    val Natural20 = when(currentTheme) {
        Theme.LIGHT -> Color(0xFF656B80)
        Theme.DARK -> Color(0xFF818198)
    }
    val Natural30 = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFBBBBCC)
        Theme.DARK -> Color(0xFF626274)
    }
    val Natural40 = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFE2E2EE)
        Theme.DARK -> Color(0xFF292930)
    }
    val Natural50 = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFF2F2F4)
        Theme.DARK -> Color(0xFF1E1E26)
    }

    val BackGround = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFF7F7F9)
        Theme.DARK -> Color(0xFF1F1E2B)
    }
    val CardBackGround = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFFDFDFD)
        Theme.DARK -> Color(0xFF17161F)
    }

    val SubGreen = when(currentTheme) {
        Theme.LIGHT -> Color(0xFF9BDA93)
        Theme.DARK -> Color(0xFF79CE6F)
    }
    val SubYellow = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFEEE170)
        Theme.DARK -> Color(0xFFE9D844)
    }
    val SubRed = when(currentTheme) {
        Theme.LIGHT -> Color(0xFFF3A199)
        Theme.DARK -> Color(0xFFEE786D)
    }
}


object DotoriButtonColor {
    val LightBlue = DotoriColor.Primary30
    val Blue = DotoriColor.Primary10
    val Transparent = DotoriColor.Transparent
}

object DotoriButtonContentColor {
    val ButtonContentWhite = DotoriColor.White
    val ButtonContentGray = DotoriColor.Natural20
}