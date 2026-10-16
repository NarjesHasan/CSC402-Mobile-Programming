package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
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
    val greeting: String = "Hello, Student!",
    val totalTasks: Int = 3,
    val completedTasks: Int = 0,
    val tasks: List<String> = listOf(
        "Lab 4 attendance check & state list",
        "CSC 402 Lecture slides review",
        "Lab 5 Navigation & Share sheet implementation"
    )
)

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onTaskClick: (String) -> Unit,
    onIncrementCompleted: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = uiState.greeting, style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "${uiState.completedTasks} of ${uiState.totalTasks} done",
            style = MaterialTheme.typography.titleMedium
        )

        Button(
            onClick = onIncrementCompleted,
            enabled = uiState.completedTasks < uiState.totalTasks
        ) {
            Text("Mark Task Done")
        }

        Text("Your Study Tasks:", style = MaterialTheme.typography.titleLarge)

        uiState.tasks.forEach { title ->
            OutlinedButton(
                onClick = { onTaskClick(title) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = title)
            }
        }
    }
}

@Preview(showBackground = true, name = "Zero completed")
@Composable
private fun PlannerHomeScreenPreviewZero() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(completedTasks = 0),
            onTaskClick = {},
            onIncrementCompleted = {}
        )
    }
}

@Preview(showBackground = true, name = "All completed")
@Composable
private fun PlannerHomeScreenPreviewAll() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(completedTasks = 3),
            onTaskClick = {},
            onIncrementCompleted = {}
        )
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var uiState by remember { mutableStateOf(PlannerUiState()) }

    PlannerHomeScreen(
        uiState = uiState,
        onTaskClick = onTaskClick,
        onIncrementCompleted = {
            if (uiState.completedTasks < uiState.totalTasks) {
                uiState = uiState.copy(completedTasks = uiState.completedTasks + 1)
            }
        },
        modifier = modifier
    )
}
