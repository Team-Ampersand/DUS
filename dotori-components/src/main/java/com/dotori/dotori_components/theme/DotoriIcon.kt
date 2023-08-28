package com.dotori.dotori_components.theme

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.example.dus.R

@Composable
fun ArrowRightIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_arrow_right),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ArrowRight2Icon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    contentDescription: String?,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_arrow_right2),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ArrowDownIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_arrow_down),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ArrowLeftIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_arrow_left),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ArrowLeft2Icon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_arrow_left2),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ListIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_list),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun CalendarIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_calendar),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun DownloadIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_download),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ExclamationMarkIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_exclamation_mark),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun EyeCloseIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_eye_close),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun EyeOpenIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_eye_open),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun FemaleIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_female),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun FilterIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_filter),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun HamburgerIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_hamburger),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun LockIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_lock),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun Logout(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_logout),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun MaleIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_male),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun MeatballIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_meatball),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun PenIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_pen),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun PersonIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    isPressed: Boolean = false,
) {
    Icon(
        painter = painterResource(id = if (isPressed) R.drawable.ic_pressed_person else R.drawable.ic_person),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun PlusIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_plus),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun SearchIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_search),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun ShortcutsIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_shortcuts),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun TrashCanIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_trash_can),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun WarningIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    isPressed: Boolean = false,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(
            id = if (isPressed) {
                R.drawable.ic_pressed_violation
            } else {
                R.drawable.ic_warning
            }
        ),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun XMarkIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_x_mark),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun XMarkIcon2(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_x_mark2),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun XSmallIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_x_small),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun SelfStudyAllowIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    contentDescription: String?,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_self_study_allow),
        tint = tint,
        contentDescription = contentDescription
    )
}

@Composable
fun SelfStudyDisallowIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    contentDescription: String?,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_self_study_disallow),
        tint = tint,
        contentDescription = contentDescription
    )
}

@Composable
fun SettingIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    contentDescription: String?,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_setting_icon),
        tint = tint,
        contentDescription = contentDescription
    )
}

@Composable
fun RefreshIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    contentDescription: String?,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_refresh_icon),
        tint = tint,
        contentDescription = contentDescription
    )
}

@Composable
fun LightSwitchIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_morning),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun DarkSwitchIcon(
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_night),
        contentDescription = contentDescription,
        modifier = modifier,
        tint = tint
    )
}

@Composable
fun CheckIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
    contentDescription: String?
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_check),
        tint = tint,
        contentDescription = contentDescription
    )
}

@Composable
fun DotoriLogoIcon(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_dotori),
        tint = tint,
        contentDescription = "앱 아이콘"
    )
}

@Composable
fun DotoriText(
    modifier: Modifier = Modifier,
    tint: Color = Color.Unspecified,
) {
    Icon(
        modifier = modifier,
        painter = painterResource(id = R.drawable.ic_dotori_logo),
        tint = tint,
        contentDescription = "도토리"
    )
}
