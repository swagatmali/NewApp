package com.example.news_presentation.news_list_feature

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier.Companion
import androidx.compose.ui.unit.dp
import com.example.news_domain.model.Article
import com.example.news_presentation.base.NewsListItem
import com.example.news_presentation.base.NewsTopListItem
import java.lang.reflect.Modifier

@Composable
fun NewsListScreen(articles: List<Article>, onNewsClick: (url: Article) -> Unit) {
    Box(
        modifier = androidx.compose.ui.Modifier
            .padding(7.dp)
    ) {
        LazyColumn {
            itemsIndexed(articles) { index, article ->
                if (index == 0) {
                    NewsTopListItem(article, onNewsClick = onNewsClick)
                } else {
                    NewsListItem(article, onNewsClick = onNewsClick)
                }
                Divider(color = androidx.compose.ui.graphics.Color.LightGray, thickness = 1.dp)
            }

        }
    }
}