package com.example.myslideshow

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

val resources= listOf(
    R.drawable.slide00,
    R.drawable.slide01,
    R.drawable.slide02,
    R.drawable.slide03,
    R.drawable.slide04,
    R.drawable.slide05,
    R.drawable.slide06,
    R.drawable.slide07,
    R.drawable.slide08,
    R.drawable.slide09
)

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Slideshow(){
    val pagerState= rememberPagerState(pageCount = {resources.size})
    var slideshow by remember { mutableStateOf(false) }

    LaunchedEffect(key1 =slideshow) {
        while (slideshow){
            delay(3000)//3秒待つ
            pagerState.animateScrollToPage(
                page=(pagerState.currentPage+1)%resources.size//ページを1つ進める
            )
        }
    }
    Scaffold(
        topBar = { TopBar(isRunning = slideshow){slideshow = !slideshow} },//アイコンがタップされたらスライドショー実行の可否を切り替える
        bottomBar = { BottomBar(pagerState = pagerState)}
    ) {
       padding ->
        VerticalPager(
            state = pagerState,
            contentPadding = PaddingValues(vertical = 60.dp),
            modifier=Modifier.padding(padding)
        ) {page ->
            PagerItem(
                imageRes = resources[page],
                modifier=Modifier.fillMaxSize()
            )

        }
    }
}

@Preview
@Composable
fun SlideshowPreview(){
    Slideshow()
}