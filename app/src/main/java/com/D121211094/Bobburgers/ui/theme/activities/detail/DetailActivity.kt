package com.D121211094.Bobburgers.ui.theme.activities.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.D121211094.Bobburgers.data.models.Character
import com.D121211094.Bobburgers.ui.theme.BobBurgersTheme


class DetailActivity : ComponentActivity() {

    private var selectedCharacter: Character? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        selectedCharacter = intent.getParcelableExtra("CHARACTER")
        setContent {
            BobBurgersTheme {

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DetailScreen()
                }
            }
        }
    }

    @Composable
    private fun DetailScreen() {
        LazyColumn {
            item {
                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(selectedCharacter?.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Ini gambar",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(544.dp)
                )
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray),horizontalAlignment = Alignment.CenterHorizontally) {
                    selectedCharacter?.name?.let { Text(text = it) }
                    selectedCharacter?.gender?.let { Text(text = it) }
                    selectedCharacter?.age?.let { Text(text = it) }
                    selectedCharacter?.voicedBy?.let { Text(text = it) }
                    selectedCharacter?.occupation?.let { Text(text = it) }
                }

                }
        }
    }

}