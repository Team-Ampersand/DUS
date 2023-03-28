package com.dotori.dotori_components.theme

import androidx.compose.runtime.Stable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.dus.R

val suitFont = FontFamily(
    Font(R.font.suit_bold, FontWeight.Bold),
    Font(R.font.suit_medium, FontWeight.Medium),
    Font(R.font.suit_semi_bold, FontWeight.SemiBold)
)

object DotoriTypography {

    @Stable
    val h1 = TextStyle(
        fontFamily = suitFont,
        fontSize = 48.sp,
        fontWeight = FontWeight.Bold
    )

    @Stable
    val h2 = TextStyle(
        fontFamily = suitFont,
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )

    @Stable
    val h3 = TextStyle(
        fontFamily = suitFont,
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    )

    @Stable
    val h4 = TextStyle(
        fontFamily = suitFont,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    )

    @Stable
    val subTitle1 = TextStyle(
        fontFamily = suitFont,
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )

    @Stable
    val subTitle2 = TextStyle(
        fontFamily = suitFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    )

    @Stable
    val subTitle3 = TextStyle(
        fontFamily = suitFont,
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    )

    @Stable
    val smallTitle = TextStyle(
        fontFamily = suitFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.SemiBold
    )

    @Stable
    val body = TextStyle(
        fontFamily = suitFont,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        lineHeight = 1.5f.sp
    )

    @Stable
    val body2 = TextStyle(
        fontFamily = suitFont,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    )

    @Stable
    val caption = TextStyle(
        fontFamily = suitFont,
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    )
}