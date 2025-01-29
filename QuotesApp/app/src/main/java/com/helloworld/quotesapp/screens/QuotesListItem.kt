package com.helloworld.quotesapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.helloworld.quotesapp.models.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick: () -> Unit) {
    Card(
        elevation = CardDefaults.cardElevation(4.dp),
        modifier = Modifier
            .clickable { onClick() }
            .padding(8.dp)
            .fillMaxWidth(),
        shape = androidx.compose.ui.graphics.RectangleShape // to make sharp edges
    ) {
        Row {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "Quotes",
                modifier = Modifier
                    .padding(6.dp)
                    .size(50.dp)
                    .background(Color.Black)
                    .rotate(180F)
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Column {
                Text(
                    text = quote.text,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = quote.author,
                    modifier = Modifier.padding(0.dp, 4.dp, 0.dp, 2.dp),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}
