package com.dotori.dotori_components.components.rule

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.components.checkbox.DotoriCheckBox
import com.dotori.dotori_components.components.utils.GenderType
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.FemaleIcon
import com.dotori.dotori_components.theme.MaleIcon
import com.dotori.dotori_components.theme.MeatballIcon
import com.dotori.dotori_components.theme.White
import com.example.dus.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DotoriRoleViolateListItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    name: String,
    studentId: String,
    gender: String,
    violate: String,
    onOptionClicked: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isClicked by interactionSource.collectIsPressedAsState()
    var isChecked by remember { mutableStateOf(false) }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(
                if (isClicked || isChecked) DotoriTheme.colors.background else DotoriTheme.colors.cardBackground
            )
            .padding(
                horizontal = 8.dp,
                vertical = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        DotoriCheckBox(onCheckedChange = { isChecked = it })
        Spacer(modifier = Modifier.width(16.dp))
        GlideImage(
            modifier = Modifier
                .clip(CircleShape)
                .size(40.dp),
            imageModel = { imageUrl },
            previewPlaceholder = R.drawable.ic_profile_light,
        )
        Spacer(modifier = Modifier.width(12.dp))
        Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
            Text(
                text = name,
                style = DotoriTheme.typography.smallTitle,
                color = DotoriTheme.colors.neutral10
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(3.dp)
            ) {
                Text(
                    text = studentId,
                    style = DotoriTheme.typography.smallTitle,
                    color = DotoriTheme.colors.neutral20
                )
                if (gender == GenderType.MAN.toString()) {
                    MaleIcon(
                        modifier = Modifier.size(14.dp),
                        tint = DotoriTheme.colors.neutral20
                    )
                } else {
                    FemaleIcon(
                        modifier = Modifier.size(14.dp),
                        tint = DotoriTheme.colors.neutral20
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(36.dp))
        Text(
            modifier = Modifier.weight(1f),
            text = violate,
            style = DotoriTheme.typography.smallTitle,
            color = DotoriTheme.colors.neutral20,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Spacer(modifier = Modifier.width(15.dp))
        MeatballIcon(
            modifier = Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
                onClick = onOptionClicked
            ),
            tint = DotoriTheme.colors.neutral30
        )
    }
}

@Preview
@Composable
fun DotoriRoleViolateListItemPreview() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        DotoriRoleViolateListItem(
            imageUrl = "",
            name = "김준",
            studentId = "1101",
            gender = "MAN",
            violate = "전자기기 소지, 반입 - 사행성기구외 2개"
        ) {}
        DotoriRoleViolateListItem(
            imageUrl = "",
            name = "김준",
            studentId = "1101",
            gender = "WOMAN",
            violate = "전자기기 소지, 반입 - 사행성기구외 2개"
        ) {}
    }
}