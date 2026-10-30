package sa.edu.iau.cshj.studyplanner.ui

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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.data.StudyTask
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class TaskDetailUiState(
    val task: StudyTask? = null
)

val sampleTasksMap = mapOf(
    1 to StudyTask(1, "Lab 4 Attendance Check & State List", "CSC 402", isDone = true),
    2 to StudyTask(2, "Lab 5 Navigation Compose & Intents", "CSC 402", isDone = true),
    3 to StudyTask(3, "Lab 6 Rotation State Hoisting Review", "CSC 402", isDone = false),
    4 to StudyTask(4, "Lab 7 LazyColumn & Interop Implementation", "CSC 402", isDone = false),
    5 to StudyTask(5, "Term Project Proposal Finalization", "CSC 402", isDone = false)
)

@Composable
fun TaskDetailScreen(
    uiState: TaskDetailUiState,
    onShareClick: () -> Unit,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val task = uiState.task
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Task Detail", style = MaterialTheme.typography.titleMedium)
        if (task != null) {
            Text(text = task.title, style = MaterialTheme.typography.headlineMedium)
            Text(text = "Course: ${task.course}", style = MaterialTheme.typography.bodyLarge)
            Text(
                text = "Status: ${if (task.isDone) "Completed" else "In Progress"}",
                style = MaterialTheme.typography.bodyLarge
            )
            Button(onClick = onShareClick) {
                Text("Share Task")
            }
        } else {
            Text(text = "Task not found", style = MaterialTheme.typography.headlineSmall)
        }
        OutlinedButton(onClick = onBackClick) {
            Text("Back")
        }
    }
}

@Preview(showBackground = true, name = "Task Detail Preview 1")
@Composable
private fun TaskDetailPreview1() {
    StudyPlannerTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState(
                task = StudyTask(4, "Lab 7 LazyColumn & Interop Implementation", "CSC 402", isDone = false)
            ),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

@Preview(showBackground = true, name = "Task Detail Preview 2")
@Composable
private fun TaskDetailPreview2() {
    StudyPlannerTheme {
        TaskDetailScreen(
            uiState = TaskDetailUiState(
                task = StudyTask(2, "Lab 5 Navigation Compose & Intents", "CSC 402", isDone = true)
            ),
            onShareClick = {},
            onBackClick = {}
        )
    }
}

@Composable
fun TaskDetailRoute(
    taskId: Int,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val task = sampleTasksMap[taskId]
    TaskDetailScreen(
        uiState = TaskDetailUiState(task = task),
        onShareClick = {
            if (task != null) {
                val sendIntent = Intent(Intent.ACTION_SEND).apply {
                    putExtra(Intent.EXTRA_TEXT, "Today I'm studying: ${task.title} (${task.course})")
                    type = "text/plain"
                }
                context.startActivity(Intent.createChooser(sendIntent, "Share task via"))
            }
        },
        onBackClick = onBackClick,
        modifier = modifier
    )
}
