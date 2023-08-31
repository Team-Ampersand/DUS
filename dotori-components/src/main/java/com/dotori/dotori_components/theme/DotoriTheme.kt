package com.dotori.dotori_components.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.staticCompositionLocalOf
import com.dotori.dotori_components.components.utils.Theme

private val DotoriDarkColors = DotoriColors(
    primary10 = Primary10Dark,
    primary20 = Primary20Dark,
    primary30 = Primary30Dark,
    neutral10 = Neutral10Dark,
    neutral20 = Neutral20Dark,
    neutral30 = Neutral30Dark,
    neutral40 = Neutral40Dark,
    neutral50 = Neutral50Dark,
    background = BackGroundDark,
    cardBackground = CardBackGroundDark,
    subGreen = SubGreenDark,
    subYellow = SubYellowDark,
    subRed = SubRedDark,
    error = ErrorDark,
    positive = PositiveDark
)

private val DotoriLightColors = DotoriColors(
    primary10 = Primary10Light,
    primary20 = Primary20Light,
    primary30 = Primary30Light,
    neutral10 = Neutral10Light,
    neutral20 = Neutral20Light,
    neutral30 = Neutral30Light,
    neutral40 = Neutral40Light,
    neutral50 = Neutral50Light,
    background = BackGroundLight,
    cardBackground = CardBackGroundLight,
    subGreen = SubGreenLight,
    subYellow = SubYellowLight,
    subRed = SubRedLight,
    error = ErrorLight,
    positive = PositiveLight
)

private val LocalColorProvider = staticCompositionLocalOf { DotoriLightColors }

@Composable
private fun DotoriThemeLocalProvider(
    colors: DotoriColors,
    typography: DotoriTypography,
    content: @Composable () -> Unit
) {
    val colorPalette = remember { colors.copy() }

    colorPalette.update(dotoriColors = colors)
    CompositionLocalProvider(
        LocalColorProvider provides colorPalette,
        LocalTypography provides typography,
        content = content
    )
}

private val Theme.colors: DotoriColors
    get() = when(this) {
        Theme.DARK -> DotoriDarkColors
        Theme.LIGHT -> DotoriLightColors
    }

object DotoriTheme {
    val colors: DotoriColors
        @Composable
        get() = LocalColorProvider.current

    val typography: DotoriTypography
        @Composable
        get() = LocalTypography.current

    var dotoriTheme by mutableStateOf(Theme.LIGHT)

    fun isSystemIsDarkTheme(): Boolean {
        return dotoriTheme == Theme.DARK
    }
}

@Composable
fun DotoriTheme(
    dotoriTheme: Theme = DotoriTheme.dotoriTheme,
    typography: DotoriTypography = DotoriTheme.typography,
    content: @Composable () -> Unit
) {
    DotoriThemeLocalProvider(
        colors = dotoriTheme.colors,
        typography = typography,
        content = content
    )
}