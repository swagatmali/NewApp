package com.example.news_presentation.news_details_feature

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.news_domain.model.Article
import com.example.news_presentation.base.GetTopImage


@Composable
fun NewsDetailsScreen(article: Article?) {
    Column {
        article?.let {
            GetTopImage(it, Modifier)
            Column(Modifier.padding(10.dp)) {
                Text(
                    text = it.title,
                    style = MaterialTheme.typography.titleLarge
                )
                Text( modifier = Modifier.padding(top = 30.dp),
                    text = it.description,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}