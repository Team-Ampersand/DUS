package com.dotori.dotori_components.components.textField

import androidx.annotation.DrawableRes
import com.example.dus.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dotori.dotori_components.components.utils.Types
import com.dotori.dotori_components.theme.DotoriDarkColor
import com.dotori.dotori_components.theme.DotoriLightColor
import com.dotori.dotori_components.theme.DotoriTypography

@Composable
fun DotoriTextField(
    modifier: Modifier = Modifier,
    types: Types.TextFieldType,
    value: String,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    textStyle: TextStyle = DotoriTypography.body,
    focusColor: Color = DotoriLightColor.Primary10,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: String,
    leadingIcon: Int? = null,
    trailingIcon: Int? = null,
    onValueChange: (String) -> Unit
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var isFocus by remember { mutableStateOf(false) }
    val textColor = textColorFor(type = types)
    val backgroundColor = backgroundColorFor(type = types)
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    val placeholderColor = placeholderColorFor(type = types)
    val unFocusColor = backgroundColor

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier
                .fillMaxWidth()
                .focusRequester(focusRequester)
                .onFocusChanged {
                    isFocus = it.isFocused
                },
            textStyle = mergedTextStyle,
            cursorBrush = SolidColor(focusColor),
            visualTransformation = visualTransformation,
            singleLine = singleLine,
            maxLines = maxLines,
            decorationBox = { innerTextField ->
                Box(
                    modifier = modifier
                        .fillMaxWidth()
                        .background(
                            color = backgroundColor,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = if (isFocus) focusColor else unFocusColor,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 16.dp, vertical = 14.dp)
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        leadingIcon?.let {
                            leadingIconLoading(id = it, types = types)
                            Spacer(modifier = modifier.width(17.dp))
                        }
                        if (value.isEmpty()) {
                            Text(
                                text = placeholder,
                                fontSize = textStyle.fontSize,
                                fontWeight = textStyle.fontWeight,
                                fontFamily = textStyle.fontFamily,
                                lineHeight = textStyle.lineHeight,
                                color = placeholderColor,
                            )
                        }
                        trailingIcon?.let {
                            Spacer(modifier = modifier.weight(1f))
                            trailingIconLoading(id = it, types = types)
                        }
                    }
                    Row(
                        modifier = modifier
                            .padding(
                                horizontal = if(leadingIcon != null) 41.dp else 0.dp
                            )
                            .padding(top = 3.dp)
                    ) {
                        innerTextField()
                    }
                }
            }
        )
    }
}

@Composable
private fun backgroundColorFor(type: Types.TextFieldType): Color =
    when (type) {
        Types.TextFieldType.LIGHT -> DotoriLightColor.Natural50
        Types.TextFieldType.DARK -> DotoriDarkColor.Natural50
    }

@Composable
private fun textColorFor(type: Types.TextFieldType): Color =
    when (type) {
        Types.TextFieldType.LIGHT -> DotoriLightColor.Neutral10
        Types.TextFieldType.DARK -> DotoriDarkColor.Neutral10
    }

@Composable
private fun iconColorFor(type: Types.TextFieldType): Color =
    when (type) {
        Types.TextFieldType.LIGHT -> DotoriLightColor.Neutral10
        Types.TextFieldType.DARK -> DotoriDarkColor.Neutral10
    }

@Composable
private fun placeholderColorFor(type: Types.TextFieldType): Color =
    when (type) {
        Types.TextFieldType.LIGHT -> DotoriLightColor.Natural30
        Types.TextFieldType.DARK -> DotoriDarkColor.Natural30
    }

@Composable
private fun leadingIconLoading(@DrawableRes id: Int, types: Types.TextFieldType) {
    Icon(
        painter = painterResource(id = id),
        contentDescription = "leadingIcon",
        tint = iconColorFor(type = types)
    )
}

@Composable
private fun trailingIconLoading(@DrawableRes id: Int, types: Types.TextFieldType) {
    Icon(
        painter = painterResource(id = id),
        contentDescription = "trailingIcon",
        tint = iconColorFor(type = types)
    )
}

@Preview(showBackground = true)
@Composable
fun textFieldPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        var lightTestText by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.LIGHT,
            value = lightTestText,
            onValueChange = { lightTestText = it },
            placeholder = "Light Dotori TextField Test"
        )

        var darkTestText by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.DARK,
            value = darkTestText,
            onValueChange = { darkTestText = it },
            placeholder = "Dark Dotori TextField Test"
        )

        var lightTestText2 by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.LIGHT,
            value = lightTestText2,
            onValueChange = { lightTestText2 = it },
            placeholder = "Light Dotori TextField Test",
            leadingIcon = R.drawable.person
        )

        var darkTestText2 by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.DARK,
            value = darkTestText2,
            onValueChange = { darkTestText2 = it },
            placeholder = "Dark Dotori TextField Test",
            trailingIcon = R.drawable.eye_close
        )

        var lightTestText3 by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.LIGHT,
            value = lightTestText3,
            onValueChange = { lightTestText3 = it },
            placeholder = "Light Dotori TextField Test",
            leadingIcon = R.drawable.person,
            trailingIcon = R.drawable.x_mark
        )

        var darkTestText3 by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.DARK,
            value = darkTestText3,
            onValueChange = { darkTestText3 = it },
            placeholder = "Dark Dotori TextField Test",
            leadingIcon = R.drawable.lock,
            trailingIcon = R.drawable.eye_close
        )
    }
}

