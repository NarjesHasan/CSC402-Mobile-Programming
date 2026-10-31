package sa.edu.iau.cshj.lab05.ui

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

// ---------- Home ----------
@Composable
fun HomeScreen(
    onWebsiteClick: () -> Unit,
    onCallClick: () -> Unit,
    onCoursesClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text("CSC Courses", style = MaterialTheme.typography.headlineMedium)
        Button(onClick = onWebsiteClick) { Text("University website") }
        Button(onClick = onCallClick) { Text("Call the department") }
        Button(onClick = onCoursesClick) { Text("Browse courses") }
    }
}

@Composable
fun HomeRoute(onCoursesClick: () -> Unit) {
    val context = LocalContext.current

    HomeScreen(
        onWebsiteClick = {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.iau.edu.sa"))
            try {
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "No app can open this", Toast.LENGTH_SHORT).show()
            }
        },
        onCallClick = {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:0138000000"))
            try {
                context.startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(context, "No app can open this", Toast.LENGTH_SHORT).show()
            }
        },
        onCoursesClick = onCoursesClick
    )
}

