package sa.edu.iau.cshj.studyplanner.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import sa.edu.iau.cshj.studyplanner.data.StudyTask
import sa.edu.iau.cshj.studyplanner.ui.theme.StudyPlannerTheme

data class PlannerUiState(
    val greeting: String = "Hello, Student!",
    val tasks: List<StudyTask> = emptyList()
) {
    val totalTasks: Int get() = tasks.size
    val completedTasks: Int get() = tasks.count { it.isDone }
}

@Composable
fun TaskItem(
    task: StudyTask,
    onTaskClick: (Int) -> Unit,
    onDoneChange: (Int, Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onTaskClick(task.id) },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Checkbox(
                checked = task.isDone,
                onCheckedChange = { checked -> onDoneChange(task.id, checked) }
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium,
                    textDecoration = if (task.isDone) TextDecoration.LineThrough else TextDecoration.None
                )
                Text(
                    text = task.course,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }
    }
}

@Composable
fun PlannerHomeScreen(
    uiState: PlannerUiState,
    onTaskClick: (Int) -> Unit,
    onDoneChange: (Int, Boolean) -> Unit,
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

        Text("Your Study Tasks:", style = MaterialTheme.typography.titleLarge)

        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(uiState.tasks, key = { it.id }) { task ->
                TaskItem(
                    task = task,
                    onTaskClick = onTaskClick,
                    onDoneChange = onDoneChange
                )
            }
        }
    }
}

@Preview(showBackground = true, name = "TaskItem Not Done")
@Composable
private fun TaskItemNotDonePreview() {
    StudyPlannerTheme {
        TaskItem(
            task = StudyTask(1, "Lab 7 LazyColumn & Interoperability", "CSC 402", isDone = false),
            onTaskClick = {},
            onDoneChange = { _, _ -> }
        )
    }
}

@Preview(showBackground = true, name = "TaskItem Done")
@Composable
private fun TaskItemDonePreview() {
    StudyPlannerTheme {
        TaskItem(
            task = StudyTask(2, "Lab 4 Attendance Screen & State List", "CSC 402", isDone = true),
            onTaskClick = {},
            onDoneChange = { _, _ -> }
        )
    }
}

@Preview(showBackground = true, name = "PlannerHomeScreen 5 Tasks")
@Composable
private fun PlannerHomeScreenPreview() {
    StudyPlannerTheme {
        PlannerHomeScreen(
            uiState = PlannerUiState(
                tasks = listOf(
                    StudyTask(1, "Lab 4 Attendance Check & State List", "CSC 402", isDone = true),
                    StudyTask(2, "Lab 5 Navigation Compose & Intents", "CSC 402", isDone = true),
                    StudyTask(3, "Lab 6 Rotation State Hoisting Review", "CSC 402", isDone = false),
                    StudyTask(4, "Lab 7 LazyColumn & Interop Implementation", "CSC 402", isDone = false),
                    StudyTask(5, "Term Project Proposal Finalization", "CSC 402", isDone = false)
                )
            ),
            onTaskClick = {},
            onDoneChange = { _, _ -> }
        )
    }
}

@Composable
fun PlannerHomeRoute(
    onTaskClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    var tasks by remember {
        mutableStateOf(
            listOf(
                StudyTask(1, "Lab 4 Attendance Check & State List", "CSC 402", isDone = true),
                StudyTask(2, "Lab 5 Navigation Compose & Intents", "CSC 402", isDone = true),
                StudyTask(3, "Lab 6 Rotation State Hoisting Review", "CSC 402", isDone = false),
                StudyTask(4, "Lab 7 LazyColumn & Interop Implementation", "CSC 402", isDone = false),
                StudyTask(5, "Term Project Proposal Finalization", "CSC 402", isDone = false)
            )
        )
    }

    PlannerHomeScreen(
        uiState = PlannerUiState(tasks = tasks),
        onTaskClick = onTaskClick,
        onDoneChange = { taskId, isDone ->
            tasks = tasks.map {
                if (it.id == taskId) it.copy(isDone = isDone) else it
            }
        },
        modifier = modifier
    )
}
