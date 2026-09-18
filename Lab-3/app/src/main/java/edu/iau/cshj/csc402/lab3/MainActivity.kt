package edu.iau.cshj.csc402.lab3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.iau.cshj.csc402.lab3.ui.theme.CSC402Lab3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CSC402Lab3Theme {
                // Set usePadding = false here to take the "Incorrect" screenshot
                // Set usePadding = true for the "Correct" version
                ProfileScreen(usePadding = true, modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Preview(name = "Correct Padding", showBackground = true)
@Composable
fun ProfileScreenCorrectPreview() {
    CSC402Lab3Theme {
        ProfileScreen(usePadding = true)
    }
}

@Preview(name = "Incorrect Padding", showBackground = true)
@Composable
fun ProfileScreenIncorrectPreview() {
    CSC402Lab3Theme {
        ProfileScreen(usePadding = false)
    }
}
