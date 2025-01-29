package com.helloworld.themetogglebutton

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.helloworld.themetogglebutton.ui.theme.ThemeToggleButtonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    val isDarkTheme = remember { mutableStateOf(false) }

    ThemeToggleButtonTheme(darkTheme = isDarkTheme.value) {
        Column(
            modifier = Modifier.fillMaxSize()
                .background(MaterialTheme.colorScheme.background), // Apply background color
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Applying Themes",
                style = MaterialTheme.typography.displayMedium, // Apply text color
                modifier = Modifier.padding(16.dp)
            )
            Button(
                onClick = { isDarkTheme.value = !isDarkTheme.value }, // Toggle state on button click
            ) {
                Text(
                    text = "Change Theme",
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.onPrimary, // Apply text color
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }
}
