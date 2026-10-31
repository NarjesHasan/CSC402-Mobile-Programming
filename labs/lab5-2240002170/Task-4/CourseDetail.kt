package sa.edu.iau.cshj.lab05.ui

import android.content.Intent
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

data class CourseDetailUiState(val code: String = "")

@Composable
fun CourseDetailScreen(
    uiState: CourseDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(uiState.code, style = MaterialTheme.typography.headlineMedium)
        Button(onClick = onShareClick) { Text("Share") }
        OutlinedButton(onClick = onBackClick) { Text("Back") }
    }
}

@Composable
fun CourseDetailRoute(code: String, onBackClick: () -> Unit) {
    val context = LocalContext.current
    CourseDetailScreen(
        uiState = CourseDetailUiState(code = code),
        onShareClick = {
            val send = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, "I'm taking $code this semester!")
                type = "text/plain"
            }
            context.startActivity(Intent.createChooser(send, "Share via"))
        },
        onBackClick = onBackClick
    )
}
