package com.helloworld.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardApp()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardApp() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Centered Name & Title
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Profile Image (Ensure this image is in res/drawable)
            Image(
                painter = painterResource(id = R.drawable.contrasticon), // Ensure contrasticon.png exists
                contentDescription = "Profile Image",
                modifier = Modifier.size(100.dp) // Adjust size if needed
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Name
            Text(
                text = "Aditya Patanwar",
                style = MaterialTheme.typography.headlineMedium // Better for names
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Job Title
            Text(
                text = "Native Android Developer",
                style = MaterialTheme.typography.bodyMedium // Ensures consistency
            )
        }

        // Contact Information at the Bottom
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "GitHub: github.com/codex-yasxh",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Email: aditya.patanwar@example.com",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "LinkedIn: linkedin.com/in/aditya-patanwar",
                style = MaterialTheme.typography.bodyMedium
            )

        }
    }
}
