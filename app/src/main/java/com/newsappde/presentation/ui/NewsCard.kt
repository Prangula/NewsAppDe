package com.newsappde.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.newsappde.domain.model.ArticleDomain
import com.newsappde.domain.model.SourceDomain
import com.newsappde.presentation.ui.theme.CardBackground
import com.newsappde.utils.constants.Strings.BREAKING_NEWS
import com.newsappde.utils.constants.Strings.EMPTY_STRING
import com.newsappde.utils.constants.Strings.UNKNOWN_AUTHOR
import com.newsappde.utils.extensions.NewsImage

@Composable
fun NewsCard(
    articleDomain: ArticleDomain,
    cardBackgroundColor: Color,
    modifier: Modifier = Modifier
) {
    with(articleDomain) {
        Card(
            colors = CardDefaults.cardColors(containerColor = cardBackgroundColor),
            shape = RoundedCornerShape(12.dp),
            modifier = modifier.padding(vertical = 20.dp, horizontal = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    NewsImage(
                        url = urlToImage,
                        modifier = Modifier.weight(1.5f)
                    )
                    Text(
                        text = title ?: BREAKING_NEWS,
                        fontSize = 16.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        maxLines = 6,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier
                            .weight(2f)
                            .padding(start = 16.dp)
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = author ?: UNKNOWN_AUTHOR,
                            fontSize = 14.sp,
                            color = Color.Black
                        )
                        Text(
                            text = publishedAt ?: EMPTY_STRING,
                            fontSize = 12.sp,
                            color = Color.Black
                        )
                    }
                    Text(
                        text = description ?: EMPTY_STRING,
                        fontSize = 14.sp,
                        color = Color.Black,
                        modifier = Modifier
                            .weight(2f)
                            .padding(start = 16.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun NewsCardPreview() {
    NewsCard(
        articleDomain = ArticleDomain(
            author = "Sky Sports",
            content = "",
            description = "Liverpool are closing in on the signing of goalkeeper Girogi Mamardashvili from Valencia.",
            publishedAt = "22:00",
            source = SourceDomain(
                id = "",
                name = ""
            ),
            title = "Liverpool closing in on Mamardashvili deal",
            url = "",
            urlToImage = "https://upload.wikimedia.org/wikipedia/commons/0/0b/Liverpool_FC_logo.svg"
        ),
        cardBackgroundColor = CardBackground
    )
}