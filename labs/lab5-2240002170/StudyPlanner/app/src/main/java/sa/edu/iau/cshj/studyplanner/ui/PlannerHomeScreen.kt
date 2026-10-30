package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val greeting: String = "Hello, Narjes!",
    val tasks: List<String> = emptyList()
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(uiState.greeting, style = MaterialTheme.typography.headlineMedium)
        Text("Your study tasks", style = MaterialTheme.typography.titleLarge)
        uiState.tasks.forEach { title ->
            Button(onClick = { onTaskClick(title) }) {
                Text(title)
            }
        }
    }
}

@Preview(showBackground = true, name = "Study planner tasks")
@Composable
private fun PlannerHomePreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                tasks = listOf("Lab 4 report", "Review Lecture 5", "Prepare CSC 402 notes")
            ),
            onTaskClick = {}
        )
    }
}

@Composable
fun PlannerHomeRoute(onTaskClick: (String) -> Unit) {
    val uiState = PlannerUiState(
        greeting = "Hello, Narjes!",
        tasks = listOf("Lab 4 report", "Review Lecture 5", "Prepare CSC 402 notes")
    )
    PlannerHomeScreen(uiState = uiState, onTaskClick = onTaskClick)
}
