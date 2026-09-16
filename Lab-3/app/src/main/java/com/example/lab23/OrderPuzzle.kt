package com.example.lab23

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lab23.ui.theme.CSC402Lab3Theme

@Composable
fun ChainA(modifier: Modifier = Modifier) {
    Text(
        text = "Chain A",
        modifier = modifier
            .background(Color(0xFF3DDC84))
            .padding(24.dp)
    )
}

@Composable
fun ChainB(modifier: Modifier = Modifier) {
    Text(
        text = "Chain B",
        modifier = modifier
            .padding(24.dp)
            .background(Color(0xFF3DDC84))
    )
}

@Composable
fun ChainC(modifier: Modifier = Modifier) {
    Text(
        text = "Chain C",
        modifier = modifier
            .clip(RoundedCornerShape(20.dp))
            .background(Color(0xFF3DDC84))
            .padding(24.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun OrderPuzzlePreview() {
    CSC402Lab3Theme {
        Column(modifier = Modifier.padding(16.dp)) {
            ChainA()
            Spacer(Modifier.height(16.dp))
            ChainB()
            Spacer(Modifier.height(16.dp))
            ChainC()

            Spacer(Modifier.height(32.dp))

            // Tap Target Experiment
            Text("Tap Target Experiment:")
            Spacer(Modifier.height(8.dp))

            // Option 1
            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .clickable { }
                    .padding(16.dp)
            ) {
                Text("Clickable then Padding")
            }

            Spacer(Modifier.height(16.dp))

            // Option 2
            Box(
                modifier = Modifier
                    .background(Color.LightGray)
                    .padding(16.dp)
                    .clickable { }
            ) {
                Text("Padding then Clickable")
            }
        }
    }
}
