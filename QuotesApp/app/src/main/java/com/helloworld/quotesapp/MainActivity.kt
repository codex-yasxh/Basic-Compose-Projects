package com.helloworld.quotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.helloworld.quotesapp.models.Quote
import com.helloworld.quotesapp.screens.QuoteDetails
import com.helloworld.quotesapp.screens.QuoteListItem
import com.helloworld.quotesapp.screens.QuoteListScreen
import com.helloworld.quotesapp.ui.theme.QuotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DataManager.loadAssetsFromFile(this)
        setContent {
                    App()
            }
        }
    }



@Composable
fun App(){
    if(DataManager.isDataLoaded.value){
            QuoteListScreen(data = DataManager.data){
        }
    }
}