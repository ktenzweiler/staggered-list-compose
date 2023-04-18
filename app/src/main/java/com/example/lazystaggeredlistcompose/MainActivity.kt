package com.example.lazystaggeredlistcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lazystaggeredlistcompose.ui.theme.LazyStaggeredListComposeTheme
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val listItems = (1 .. 25).map {
            Listitem(
                height = Random.nextInt(75, 200).dp,
                color = Color(Random.nextLong(0xFFFFFFFF)).copy(alpha = .85f)
            )
        }

        setContent {
            LazyStaggeredListComposeTheme {
               LazyVerticalStaggeredGrid(
                   columns = StaggeredGridCells.Adaptive(minSize = 100.dp),
                   modifier = Modifier.fillMaxSize(),
                   contentPadding = PaddingValues(16.dp),
                   horizontalArrangement = Arrangement.spacedBy(8.dp),
                   verticalArrangement = Arrangement.spacedBy(8.dp)
               ) {
                   items(listItems) {
                       RandomColorBox(listItem = it)
                   }
               }
            }
        }
    }
}

@Composable
private fun RandomColorBox(listItem: Listitem) {
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(listItem.height)
        .clip(RoundedCornerShape(12.dp))
        .background(listItem.color))
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyStaggeredListComposeTheme {
        Greeting("Android")
    }
}