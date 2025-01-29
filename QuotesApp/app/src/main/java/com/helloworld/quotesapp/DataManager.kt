package com.helloworld.quotesapp

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import com.google.gson.Gson
import com.helloworld.quotesapp.models.Quote

object DataManager{
    var data = emptyArray<Quote>()
    var isDataLoaded = mutableStateOf(false)

    fun loadAssetsFromFile(context : Context){           //func to access data from json

        //USe gson library to use kotlin func using json files

        val inputStream = context.assets.open("quotes.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(bytes = buffer, charset = Charsets.UTF_8)
        val gson = Gson()
        data = gson.fromJson(json, Array<Quote>::class.java)

        //ab ye sab krne se ek chiz hui kii har ek quotes array ki form m store ho gaye
        // and after making all structures of app we arre passing data isDataLoaded ki value ko yaha pe true kar denge
        //ye sab k baad ye sab ko Main acitivity pe call karenge

        isDataLoaded.value = true
    }
}