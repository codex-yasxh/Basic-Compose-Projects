package com.helloworld.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.helloworld.quotesapp.R
import com.helloworld.quotesapp.models.Quote

@Composable
fun QuoteDetails(quote: Quote) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black)
    ) {
        Image(
            painter = painterResource(R.drawable.hinduism_image),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = androidx.compose.ui.layout.ContentScale.Crop
        )
        Card(
            elevation = CardDefaults.cardElevation(6.dp),
            modifier = Modifier
                .padding(20.dp)
                .fillMaxWidth(),
            shape = androidx.compose.ui.graphics.RectangleShape // to make sharp edges
        ) {
            Column(
                modifier = Modifier.padding(4.dp)
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    colorFilter = ColorFilter.tint(Color.Black),
                    alignment = Alignment.TopStart,
                    contentDescription = "Quotes",
                    modifier = Modifier
                        .padding(4.dp)
                        .size(60.dp)
                        .rotate(180F)
                )

                Text(
                    text = quote.text,
                    fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                    modifier = Modifier.padding(4.dp, 0.dp, 0.dp, 2.dp),
                    style = MaterialTheme.typography.displayMedium
                )
                Text(
                    text = quote.author,
                    modifier = Modifier.padding(4.dp, 4.dp, 0.dp, 2.dp),
                    style = MaterialTheme.typography.labelLarge
                )
            }
        }
    }
}


