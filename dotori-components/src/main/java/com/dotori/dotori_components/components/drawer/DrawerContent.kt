package com.dotori.dotori_components.components.drawer

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.PersonIcon
import com.dotori.dotori_components.theme.WarningIcon

enum class ButtonState { Pressed, Idle }

// 1
enum class Icons { Person, Violation }

// That component is for drawer content.  If you want a use unadded icon
// 1. Add icon name on enum Icons
// 2. Add an icon to the branch below.
@Composable
fun DrawerContent(data: DrawerItemData, closeDrawer: () -> Unit) {

    val buttonState = remember {
        mutableStateOf(ButtonState.Idle)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(DotoriTheme.colors.background)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(color = DotoriTheme.colors.primary10),
                onClick = {
                    closeDrawer()
                    data.onClick()
                }
            )
            .pointerInput(buttonState.value) {
                awaitPointerEventScope {
                    buttonState.value = if (buttonState.value == ButtonState.Pressed) {
                        waitForUpOrCancellation()
                        ButtonState.Idle
                    } else {
                        awaitFirstDown(false)
                        ButtonState.Pressed
                    }
                }
            },
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(modifier = Modifier.padding(start = 16.dp, top = 12.dp, bottom = 12.dp)) {
            // 2
            when (data.icon) {
                Icons.Person -> {
                    PersonIcon(
                        modifier = Modifier.size(32.dp),
                        contentDescription = "사람 아이콘",
                        isPressed = buttonState.value == ButtonState.Pressed
                    )
                }
                Icons.Violation -> {
                    WarningIcon(
                        modifier = Modifier.size(32.dp),
                        contentDescription = "경고 아이콘",
                        isPressed = buttonState.value == ButtonState.Pressed
                    )
                }
            }
        }
        Text(
            text = data.title,
            style = if (buttonState.value == ButtonState.Pressed) {
                DotoriTheme.typography.subTitle1
            } else {
                DotoriTheme.typography.subTitle3
            },
            color = if (buttonState.value == ButtonState.Pressed) {
                DotoriTheme.colors.primary10
            } else {
                DotoriTheme.colors.neutral30
            }
        )
    }
}

@Preview
@Composable
private fun DrawerContentPersonPre() {
    DrawerContent(
        data = DrawerItemData(
            title = "학생 정보",
            onClick = {},
            icon = Icons.Person
        )
    ) {}
}

@Preview
@Composable
private fun DrawerContentViolationlPre() {
    DrawerContent(
        data = DrawerItemData(
            title = "학생 정보",
            onClick = {},
            icon = Icons.Violation
        )
    ) {}
}