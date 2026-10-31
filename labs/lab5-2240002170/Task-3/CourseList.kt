package sa.edu.iau.cshj.lab05.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

// ---------- Course list ----------
data class CourseListUiState(
    val courses: List<String> = emptyList()
)

@Composable
fun CourseListScreen(
    uiState: CourseListUiState,
    onCourseClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Courses", style = MaterialTheme.typography.headlineMedium)
        uiState.courses.forEach { code ->
            Button(onClick = { onCourseClick(code) }) { Text(code) }
        }
    }
}

@Composable
fun CourseListRoute(onCourseClick: (String) -> Unit) {
    CourseListScreen(
        uiState = CourseListUiState(listOf("CSC 402", "CSC 231", "CSC 311")),
        onCourseClick = onCourseClick
    )
}

