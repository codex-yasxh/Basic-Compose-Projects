package com.helloworld.programming

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier as Modifier1  // Using Modifier aliasing for clarity

@Composable
fun Item1() {
    // Pass a generalized card view
    CardView(
        img = R.drawable.profileicon,
        title = "Aditya Patanwar",
        subtitle = "Learning Android Dev"
    )
}

@Composable
fun CardView(img: Int, title: String, subtitle: String) {
    Card(
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier1.padding(8.dp) // Add padding around the card
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier1.padding(8.dp) // Add padding within the card
        ) {
            // Image
            Image(
                painter = painterResource(id = img),
                contentDescription = "Image for $title",
                contentScale = ContentScale.Crop,
                modifier = Modifier1.size(80.dp)
            )

            // Card Content
            CardContent(title, subtitle , modifier = Modifier1.padding(start = 8.dp)) // Card content with padding
        }
    }
}

@Composable
fun CardContent(title: String, subtitle: String , modifier: Modifier1 = Modifier1) { //now it is reusable
    Column(
        modifier = modifier, // Padding between image and text
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleLarge
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Thin
        )
    }
}

// Data class for each category (Programming language)
data class ProgramCategory(val img: Int, val title: String, val subtitle: String)
// jo data class ka naam rakhoge wahi insert hoga
// Function to generate sample data
fun DataForList(): MutableList<ProgramCategory> { //iska naam Category mat rakhna coz wo do categories m confuse hojata h
    val list = mutableListOf<ProgramCategory>()
    list.add(ProgramCategory(R.drawable.profileicon, "Kotlin Developer    ", "Kotlin"))
    list.add(ProgramCategory(R.drawable.profileicon, "Flutter Developer    ", "Flutter"))
    list.add(ProgramCategory(R.drawable.profileicon, "Java Developer      ", "Java"))
    list.add(ProgramCategory(R.drawable.profileicon, "Python Developer    ", "Python"))
    list.add(ProgramCategory(R.drawable.profileicon, "C++ Developer      ", "C++"))
    list.add(ProgramCategory(R.drawable.profileicon, "C Developer       ", "C"))
    list.add(ProgramCategory(R.drawable.profileicon, "C# Developer      ", "C#"))
    list.add(ProgramCategory(R.drawable.profileicon, "PHP Developer       ", "PHP"))
    list.add(ProgramCategory(R.drawable.profileicon, "JavaScript Developer       ", "JavaScript"))
    list.add(ProgramCategory(R.drawable.profileicon, "Swift Developer       ", "Swift"))
    return list
}

// Preview function to display the LazyColumn of cards
@Preview
@Composable
fun PreviewItem() {
    val sampleData = DataForList()
    LazyColumn {
        items(sampleData) { item ->
            CardView(item.img, item.title, item.subtitle)
        }
    }
}
