package edu.iau.cshj.csc402.lab3

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import edu.iau.cshj.csc402.lab3.ui.theme.CSC402Lab3Theme
import androidx.compose.ui.unit.dp

// Prediction:
// Chain A -> Result 1
// Chain B -> Result 2
// Chain C -> Result 3
// Tap-target prediction: .clickable { }.padding(16.dp) allows tapping in padded area.

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
        // Wrap in theme if available
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

// Observed Result:
// Chain A -> Result 2 (Background covers content, then padding is added outside the colored area)
// Chain B -> Result 1 (Padding is added first, then background fills the entire padded area)
// Chain C -> Result 3 (Clip is applied to the bounds, then background fills the clipped area)
//
// Tap-target observation:
// .padding(16.dp).clickable { } is the one that allows tapping in the padded area.
// .clickable { }.padding(16.dp) only responds to taps on the text itself, because the click listener 
// was applied before the bounds were expanded by padding.
