package com.helloworld.sideeffects

import androidx.collection.mutableIntSetOf
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import kotlinx.coroutines.delay


@Composable
fun App(){
    var counter = remember { mutableIntStateOf(0) }

    LaunchedEffectComposable(key1 = Unit){
        delay(2000)
        counter.intValue = 10
    }
    Counter(counter.intValue)
}


@Composable
fun Counter(value: Int){
    Text(text = value.toString())
}