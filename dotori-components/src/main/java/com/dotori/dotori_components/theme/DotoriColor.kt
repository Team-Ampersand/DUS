package com.dotori.dotori_components.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)
val Transparent = Color(0x00000000)

val Primary10Light = Color(0xFF6F7AEC)
val Primary20Light = Color(0xFFEEF0FD)
val Primary30Light = Color(0xFFC5CAF7)
val Neutral10Light = Color(0xFF292E3D)
val Neutral20Light = Color(0xFF656B80)
val Neutral30Light = Color(0xFFBBBBCC)
val Neutral40Light = Color(0xFFE2E2EE)
val Neutral50Light = Color(0xFFF2F2F4)
val BackGroundLight = Color(0xFFF7F7F9)
val CardBackGroundLight = Color(0xFFFDFDFD)
val ErrorLight = Color(0xFFD84D4D)
val PositiveLight = Color(0xFF2E8546)
val SubGreenLight = Color(0xFF9BDA93)
val SubYellowLight = Color(0xFFEEE170)
val SubRedLight = Color(0xFFF3A199)

val Primary10Dark = Color(0xFF5966E9)
val Primary20Dark = Color(0xFF1D2136)
val Primary30Dark = Color(0xFF24295D)
val Neutral10Dark = Color(0xFFCDCDD5)
val Neutral20Dark = Color(0xFF818198)
val Neutral30Dark = Color(0xFF626274)
val Neutral40Dark = Color(0xFF292930)
val Neutral50Dark = Color(0xFF1E1E26)
val BackGroundDark = Color(0xFF1F1E2B)
val CardBackGroundDark = Color(0xFF17161F)
val ErrorDark = Color(0xFFFF7D7D)
val PositiveDark = Color(0xFF5EFF8B)
val SubGreenDark = Color(0xFF79CE6F)
val SubYellowDark = Color(0xFFE9D844)
val SubRedDark = Color(0xFFEE786D)

class DotoriColors(
    primary10: Color,
    primary20: Color,
    primary30: Color,
    neutral10: Color,
    neutral20: Color,
    neutral30: Color,
    neutral40: Color,
    neutral50: Color,
    background: Color,
    cardBackground: Color,
    error: Color,
    positive: Color,
    subGreen: Color,
    subYellow: Color,
    subRed: Color
) {
    var primary10 by mutableStateOf(primary10)
        private set
    var primary20 by mutableStateOf(primary20)
        private set
    var primary30 by mutableStateOf(primary30)
        private set

    var neutral10 by mutableStateOf(neutral10)
        private set
    var neutral20 by mutableStateOf(neutral20)
        private set
    var neutral30 by mutableStateOf(neutral30)
        private set
    var neutral40 by mutableStateOf(neutral40)
        private set
    var neutral50 by mutableStateOf(neutral50)
        private set

    var background by mutableStateOf(background)
        private set
    var cardBackground by mutableStateOf(cardBackground)
        private set

    var error by mutableStateOf(error)
        private set
    var positive by mutableStateOf(positive)
        private set

    var subGreen by mutableStateOf(subGreen)
        private set
    var subYellow by mutableStateOf(subYellow)
        private set

    var subRed by mutableStateOf(subRed)
        private set

    fun update(dotoriColors: DotoriColors) {
        this.primary10 = dotoriColors.primary10
        this.primary20 = dotoriColors.primary20
        this.primary30 = dotoriColors.primary30
        this.neutral10 = dotoriColors.neutral10
        this.neutral20 = dotoriColors.neutral20
        this.neutral30 = dotoriColors.neutral30
        this.neutral40 = dotoriColors.neutral40
        this.neutral50 = dotoriColors.neutral50
        this.background = dotoriColors.background
        this.cardBackground = dotoriColors.cardBackground
        this.subGreen = dotoriColors.subGreen
        this.subYellow = dotoriColors.subYellow
        this.subRed = dotoriColors.subRed
        this.error = dotoriColors.error
        this.positive = dotoriColors.positive
    }

    fun copy() = DotoriColors(
        primary10 = primary10,
        primary20 = primary20,
        primary30 = primary30,
        neutral10 = neutral10,
        neutral20 = neutral20,
        neutral30 = neutral30,
        neutral40 = neutral40,
        neutral50 = neutral50,
        background = background,
        cardBackground = cardBackground,
        error = error,
        positive = positive,
        subGreen = subGreen,
        subYellow = subYellow,
        subRed = subRed
    )
}