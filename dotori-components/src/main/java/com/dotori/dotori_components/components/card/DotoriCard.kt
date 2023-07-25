package com.dotori.dotori_components.components.card

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.utils.Theme
import com.dotori.dotori_components.components.utils.Types
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.FemaleIcon
import com.dotori.dotori_components.theme.MaleIcon
import com.example.dus.R

@Composable
fun DotoriCard(
    modifier: Modifier = Modifier,
    background: Color = DotoriTheme.colors.cardBackground,
    shape: Shape = RoundedCornerShape(16.dp),
    elevation: Dp = 24.dp,
    name: String,
    gender: String,
    studentNumber: String,
    position: Int,
    mode: Types.CardType,
    isLast: Boolean
) {
    Box(modifier = modifier.fillMaxWidth()) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(80 / 43f)
                .padding(20.dp),
            color = background,
            shape = shape,
            elevation = elevation
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                Row(modifier = Modifier.padding(top = 12.dp, start = 12.dp, end = 16.dp)) {
                    Text(
                        text = position.toString(),
                        style = DotoriTheme.typography.caption,
                        color = DotoriTheme.colors.neutral20
                    )

                    Spacer(modifier = Modifier.weight(1f))

                    //  todo :: checkbox component 추가
                }

                Column(
                    modifier = Modifier.align(Alignment.Center),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = if (DotoriTheme.dotoriTheme == Theme.LIGHT) painterResource(id = R.drawable.profile_light)
                        else painterResource(id = R.drawable.profile_dark),
                        contentDescription = "profile image"
                    )

                    Row(
                        modifier = Modifier.padding(top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = name,
                            style = DotoriTheme.typography.body,
                            color = DotoriTheme.colors.neutral10
                        )

                        if (gender == "MAN") MaleIcon(
                            contentDescription = "male icon",
                            tint = DotoriTheme.colors.neutral10
                        )
                        else FemaleIcon(
                            contentDescription = "female icon",
                            tint = DotoriTheme.colors.neutral10
                        )
                    }

                    Text(
                        text = studentNumber,
                        modifier = Modifier.padding(top = 4.dp),
                        style = DotoriTheme.typography.caption,
                        color = DotoriTheme.colors.neutral20
                    )
                }
            }
        }

        when (mode) {
            Types.CardType.SELF_STUDY -> {
                if (position <= 3) {
                    when (position) {
                        1 -> CardStatusImage(drawableId = R.drawable.gold_medal)
                        2 -> CardStatusImage(drawableId = R.drawable.silver_medal)
                        3 -> CardStatusImage(drawableId = R.drawable.bronze_medal)
                    }
                } else if (isLast) CardLastNumberImage(drawableId = R.drawable.last_student_image)
            }
            Types.CardType.MASSAGE_CHAIR-> {
                if (isLast && position > 3) CardLastNumberImage(drawableId = R.drawable.last_student_image)
            }
        }
    }
}

@Composable
fun BoxScope.CardStatusImage(drawableId: Int) {
    Image(
        modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(end = 30.dp),
        painter = painterResource(id = drawableId),
        contentDescription = "student image"
    )
}

@Composable
fun BoxScope.CardLastNumberImage(drawableId: Int) {
    Image(
        modifier = Modifier.align(Alignment.BottomEnd),
        painter = painterResource(id = drawableId),
        contentDescription = "last student image",
        colorFilter = ColorFilter.tint(color = DotoriTheme.colors.primary10)
    )
}
