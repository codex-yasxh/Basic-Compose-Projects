package com.helloworld.sideeffects

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import com.helloworld.sideeffects.ui.theme.SideEffectsTheme
import kotlinx.coroutines.delay

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SideEffectsTheme {
                    App()
            }
        }
    }
}

@Composable
fun LaunchedEffectComposable(key1: Unit, function: () -> Unit) {
    val counter = remember{ mutableIntStateOf(0) }


    LaunchedEffect(key1 = Unit)  {
        try {
            for (i in 1 .. 10){
                counter.intValue++
                delay(2000)
            }
        }
        catch(e : Exception){
            Log.d("Launch Effect Composable", "Exception - ${e.message.toString()}")
        }
    }

    // Setting Up texts which will be print on the UI
    var text = "Counter is Running ${counter.intValue}"
    if(counter.intValue == 10){
        text = "Counter Stopped"
    }
    Text( text = text)
}