package com.example.myslideshow

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Slideshow
import androidx.compose.material.icons.filled.StopCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.input.pointer.PointerIcon.Companion.Text
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    isRunning:Boolean=false,//スライドショー実行中かどうか
    onClick:() ->Unit={}//アプロバーのアイコンがクリックされた時のコールバック
){
    TopAppBar(
        title = {
            Text(
                text="スライドショーアプリ",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color=MaterialTheme.colorScheme.onPrimary
                )
        },
        navigationIcon = {
            IconButton(
                onClick = { onClick() }) {
                Icon(
                    imageVector =
                    if(isRunning) Icons.Default.StopCircle
                    else Icons.Default.Slideshow,
                    tint = MaterialTheme.colorScheme.onPrimary,
                    contentDescription = "スライドショー")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
        )
}

@Preview
@Composable
fun TopBarPreView(){
    Column{
        TopBar()
        TopBar(true)
    }
}