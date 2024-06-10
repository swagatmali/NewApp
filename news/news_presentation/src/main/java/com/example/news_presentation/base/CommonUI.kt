package com.example.news_presentation.base

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.common_util.Util
import com.example.news_domain.model.Article
import com.example.news_presentation.R


@Composable
fun ShowLoading() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        val contentDesc = stringResource(R.string.loading)
        CircularProgressIndicator(modifier = Modifier
            .align(Alignment.Center)
            .semantics {
                contentDescription = contentDesc
            })
    }
}

@Composable
fun ShowError(text: String, retryClicked: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_cancel),
            tint = Color.Red,
            contentDescription = null,
            modifier = Modifier
                .width(120.dp)
                .height(120.dp)
        )
        Text(
            text = stringResource(R.string.error_title),
            style = MaterialTheme.typography.titleMedium,
            color = Color.Red,
            fontSize = 18.sp,
            modifier = Modifier
                .padding(4.dp)
        )
        Text(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = Color.Gray,
            fontSize = 16.sp,
            modifier = Modifier
                .padding(4.dp)
        )

        Button(
            onClick = { retryClicked() },
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .padding(top = 20.dp)
                .height(50.dp)
                .width(140.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red
            )
        ) {
            Text(text = stringResource(R.string.try_again))
        }
    }
}

@Composable
fun NewsTopListItem(article: Article, onNewsClick: (url: Article) -> Unit) {
    Column(modifier = Modifier
        .padding(8.dp)
        .clickable {
            onNewsClick(article)
        }) {
        GetTopImage(article, Modifier.padding(top = 8.dp))
        GetTitleColumn(Modifier.padding(top = 8.dp), article)
    }
}

@Composable
fun NewsListItem(newsListObject: Article, onNewsClick: (url: Article) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable {
                onNewsClick(newsListObject)
            }
    ) {
        GetTitleColumn(Modifier.weight(.8f), newsListObject)
        GetListImage(newsListObject)
    }
}

@Composable
fun GetTopImage(article: Article, modifier: Modifier) {
    AsyncImage(
        model = article.urlToImage,
        contentDescription = null,
        modifier = modifier
    )
}

@Composable
private fun GetListImage(newsListObject: Article) {
    AsyncImage(
        model = newsListObject.urlToImage,
        contentScale = ContentScale.Crop,
        contentDescription = null,
        modifier = Modifier
            .width(100.dp)
            .height(100.dp)
            .padding(top = 8.dp)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun GetTitleColumn(modifier: Modifier, article: Article) {
    Column(
        modifier = modifier
            .padding(end = 15.dp)
    ) {
        Text(text = Util.calculateHRs(article.publishedAt) + "H")
        Text(text = article.title, modifier = Modifier.padding(top = 4.dp))
    }
}


@Preview
@Composable
fun NewsListItem() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(
            modifier = Modifier
                .weight(.8f)
                .padding(end = 15.dp)
        ) {
            Text(text = "2H")
            Text(
                text = "sfafda n  asdf hukh dfahasfdhak asdfjkasd fak askdfhk asdfkha" +
                        "dkfja sdfasjdflsjdflas dflajs ldfadsfasdlfkjpoekpwke" +
                        "dkfja sdfasjdflsjdflas dflajs " +
                        "dkfja sdfasjdflsjdflas dflajs " +
                        "", modifier = Modifier.padding(top = 4.dp)
            )
        }
        AsyncImage(
            model = "https://www.pymnts.com/wp-content/uploads/2023/05/Five-Below-Simon.jpg",
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .background(Color.Blue)
                .width(100.dp)
                .height(100.dp)
                .padding(top = 8.dp)
        )
    }
}
