package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val greeting: String = "Hello, Narjes!",
    val totalTasks: Int = 3,
    val completedTasks: Int = 0
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onMarkTaskDone: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(uiState.greeting, style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "${uiState.completedTasks} of ${uiState.totalTasks} done",
            style = MaterialTheme.typography.titleMedium
        )
        Button(
            onClick = onMarkTaskDone,
            enabled = uiState.completedTasks < uiState.totalTasks
        ) {
            Text(if (uiState.completedTasks < uiState.totalTasks) "Mark a task done" else "All tasks done")
        }
    }
}

@Preview(showBackground = true, name = "Nothing done yet")
@Composable
private fun PlannerHomePreviewNothingDone() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState("Hello, Narjes!", totalTasks = 3, completedTasks = 0),
            onMarkTaskDone = {}
        )
    }
}

@Preview(showBackground = true, name = "Everything done")
@Composable
private fun PlannerHomePreviewEverythingDone() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState("Hello, Narjes!", totalTasks = 3, completedTasks = 3),
            onMarkTaskDone = {}
        )
    }
}

@Composable
fun PlannerHomeRoute(modifier: Modifier = Modifier) {
    var uiState by remember { mutableStateOf(PlannerUiState()) }

    PlannerHomeScreen(
        uiState = uiState,
        onMarkTaskDone = {
            uiState = uiState.copy(completedTasks = (uiState.completedTasks + 1).coerceAtMost(uiState.totalTasks))
        },
        modifier = modifier
    )
}
