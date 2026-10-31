package edu.iau.cshj.csc402.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import sa.edu.iau.cshj.lab07.ui.CampusNewsRoute
import edu.iau.cshj.csc402.lab7.ui.theme.Lab7_Task3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab7_Task3Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CampusNewsRoute(
                        onBackClick = { finish() },
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

