package com.helloworld.counterapp

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
@Preview
@Composable
fun NotificationScreen() {
    var count: MutableState<Int> = rememberSaveable { mutableStateOf(0) }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        NotificationCounter(count.value, { count.value++ }) // Button and Text first
        MessageBar(count.value) // MessageBar placed after the button
    }
}

@Composable
fun NotificationCounter(count: Int, Increment: () -> Unit) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "You have $count notifications",
            modifier = Modifier.background(color = Color.White)
        )
        Button(
            onClick = { Increment() }
        ) {
            Text("Send Notification")
        }
    }
}

@Composable
fun MessageBar(count: Int) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(top = 16.dp) // Add spacing between the button and the bar
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(color = Color.LightGray)
                .padding(10.dp)
        ) {
            Text("We have sent $count notifications")
        }
    }
}
