package com.helloworld.wallpaper

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.helloworld.wallpaper.ui.theme.WallpaperTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WallpaperTheme {
                WallpaperScreen()  // Corrected function name
            }
        }
    }
}

@Preview
@Composable
fun WallpaperScreen() {
    Box(
        modifier = Modifier.fillMaxSize()  // Ensures Box takes up full screen
    ) {
        // Background image
        Image(
            painter = painterResource(R.drawable.darkbluebackground),
            contentDescription = "Wallpaper",
            modifier = Modifier.fillMaxSize()  // Ensure image fills the screen
        )

        // Text on top of the image
        Text(
            "Chief Technology Officer", color = Color.White,
            style = MaterialTheme.typography.displayLarge,
            modifier = Modifier
                .padding(16.dp)  // Adds padding to the text
                .align(androidx.compose.ui.Alignment.Center)  // Aligns text to top-left
        )
    }
}
