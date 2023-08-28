package com.dotori.dotori_components.components.music

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dotori.dotori_components.theme.DotoriTheme
import com.dotori.dotori_components.theme.MeatballIcon
import com.example.dus.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun DotoriMusicListItem(
    modifier: Modifier = Modifier,
    imageUrl: String,
    title: String,
    name: String,
    date: String,
    onItemClicked: () -> Unit,
    onOptionClicked: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .background(DotoriTheme.colors.cardBackground)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onItemClicked
            )
    ) {
        GlideImage(
            modifier = Modifier
                .clip(RoundedCornerShape(7.dp))
                .size(width = 128.dp, height = 72.dp),
            imageModel = { imageUrl },
            previewPlaceholder = R.drawable.ic_dotori,
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(9.dp)
        ) {
            Text(
                text = title,
                maxLines = 2,
                style = DotoriTheme.typography.smallTitle,
                color = DotoriTheme.colors.neutral10,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "$name \u2022 $date",
                style = DotoriTheme.typography.caption,
                color = DotoriTheme.colors.neutral20
            )
        }
        Spacer(modifier = Modifier.width(19.dp))
        MeatballIcon(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null,
                    onClick = onOptionClicked
                ),
            contentDescription = "option"
        )
    }
}

@Preview
@Composable
fun DotoriMusicListItemPreview() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .background(
                color = DotoriTheme.colors.cardBackground,
                shape = RoundedCornerShape(16.dp)
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(10) {
            DotoriMusicListItem(
                imageUrl = "",
                title = "10cm- 서랍(그 해 우리는 OST Part.1)/가사 Audio Lyrics 21.12.07 New Release",
                name = "2105 김준",
                date = "16시 23분",
                onItemClicked = {},
                onOptionClicked = {}
            )
        }
    }
}