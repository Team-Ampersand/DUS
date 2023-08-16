package com.dotori.dotori_components.components.text_field

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.utils.Types
import com.dotori.dotori_components.theme.*

@Composable
fun DotoriTextField(
    modifier: Modifier = Modifier,
    types: Types.TextFieldType,
    value: String,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    textStyle: TextStyle = DotoriTheme.typography.body,
    focusColor: Color = DotoriTheme.colors.primary10,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    placeholder: String,
    leadingIcon: @Composable ((Color) -> Unit)? = null,
    trailingIcon: @Composable ((Color) -> Unit)? = null,
    onValueChange: (String) -> Unit
) {
    val focusRequester by remember { mutableStateOf(FocusRequester()) }
    var isFocus by remember { mutableStateOf(false) }
    val textColor = DotoriTheme.colors.neutral10
    val backgroundColor = DotoriTheme.colors.neutral50
    val iconColor = DotoriTheme.colors.neutral10
    val mergedTextStyle = textStyle.merge(TextStyle(color = textColor))
    val placeholderColor = DotoriTheme.colors.neutral30
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
                        leadingIcon?.let { leadingIcon ->
                            leadingIconLoading(icon = { leadingIcon(it) }, iconColor = iconColor)
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
                        trailingIcon?.let { trailingIcon ->
                            Spacer(modifier = modifier.weight(1f))
                            trailingIconLoading(icon = { trailingIcon(it) }, iconColor = iconColor)
                        }
                    }
                    Row(
                        modifier = modifier
                            .padding(
                                horizontal = if (leadingIcon != null) 41.dp else 0.dp
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
private fun leadingIconLoading(icon: @Composable ((Color) -> Unit)?, iconColor: Color) {
    icon?.let {
        it(iconColor)
    }
}

@Composable
private fun trailingIconLoading(icon: @Composable ((Color) -> Unit)?, iconColor: Color) {
    icon?.let {
        it(iconColor)
    }
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
            leadingIcon = { PersonIcon(contentDescription = "PersonIcon", tint = it) },
        )

        var darkTestText2 by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.DARK,
            value = darkTestText2,
            onValueChange = { darkTestText2 = it },
            placeholder = "Dark Dotori TextField Test",
            trailingIcon = { EyeCloseIcon(contentDescription = "EyeCloseIcon", tint = it) }
        )

        var lightTestText3 by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.LIGHT,
            value = lightTestText3,
            onValueChange = { lightTestText3 = it },
            placeholder = "Light Dotori TextField Test",
            leadingIcon = { PersonIcon(contentDescription = "PersonIcon", tint = it) },
            trailingIcon = { XMarkIcon(contentDescription = "XMarkIcon", tint = it) }
        )

        var darkTestText3 by remember { mutableStateOf("") }
        Spacer(modifier = Modifier.height(20.dp))

        DotoriTextField(
            types = Types.TextFieldType.DARK,
            value = darkTestText3,
            onValueChange = { darkTestText3 = it },
            placeholder = "Dark Dotori TextField Test",
            leadingIcon = { LockIcon(contentDescription = "LockIcon", tint = it) },
            trailingIcon = { EyeCloseIcon(contentDescription = "EyeCloseIcon", tint = it) }
        )
    }
}

