package com.example.studyplanner

import androidx.compose.foundation.layout.*
 import androidx.compose.foundation.lazy.LazyColumn
 import androidx.compose.foundation.lazy.items
 import androidx.compose.material3.*
 import androidx.compose.runtime.*
 import androidx.compose.runtime.saveable.rememberSaveable
 import androidx.compose.ui.Alignment
 import androidx.compose.ui.Modifier
 import androidx.compose.ui.unit.dp
 import androidx.lifecycle.compose.collectAsStateWithLifecycle
 import androidx.lifecycle.viewmodel.compose.viewModel
 import kotlinx.coroutines.launch
 @Composable fun TodayRoute(viewModel: TodayViewModel = viewModel()) {
 val uiState by viewModel.uiState.collectAsStateWithLifecycle()
 val isFocusMode = rememberAirplaneModeOn()
 val isCharging = rememberIsCharging()
 AskNotificationPermission()
TodayScreen(uiState, viewModel::onAddTask, viewModel::onTaskCheckedChange, viewModel::onDeleteTask, viewModel::onMessageShown, isFocusMode, isCharging, viewModel::onRemindMe)
 }
 @Composable fun TaskRow(task: StudyTask, onCheckedChange: (StudyTask, Boolean) -> Unit, onDeleteTask: (StudyTask) -> Unit) {
 Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
 Checkbox(checked = task.isDone, onCheckedChange = { onCheckedChange(task, it) })
 Column(Modifier.weight(1f)) { Text(task.title); Text(task.course, style = MaterialTheme.typography.bodySmall) }
 TextButton(onClick = { onDeleteTask(task) }) { Text("Delete") }
 }
 }
 @Composable fun TodayScreen(uiState: TodayUiState, onAddTask: (String) -> Unit, onTaskCheckedChange: (StudyTask, Boolean) -> Unit, onDeleteTask: (StudyTask) -> Unit, onMessageShown: () -> Unit, isFocusMode: Boolean, isCharging: Boolean, onRemindMe: () -> Unit) {
 val snackbarHostState = remember { SnackbarHostState() }
 val scope = rememberCoroutineScope()
 LaunchedEffect(uiState.message) { uiState.message?.let { snackbarHostState.showSnackbar(it); onMessageShown() } }
 Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) { padding ->
 Column(Modifier.fillMaxSize().padding(padding).padding(16.dp)) {
 Row(verticalAlignment = Alignment.CenterVertically) {
 Text("Today", Modifier.weight(1f), style = MaterialTheme.typography.headlineMedium)
 TextButton(onClick = onRemindMe) { Text("Remind me") }
TextButton(onClick = { scope.launch { snackbarHostState.showSnackbar("Tick a task when you finish it") } }) { Text("Help") }
 }
 if (isFocusMode) Card(Modifier.fillMaxWidth()) { Text("Focus mode: airplane mode is on. No distractions!", Modifier.padding(12.dp)) }
 if (isCharging) Card(Modifier.fillMaxWidth()) { Text("Charging — a good time for a long study session", Modifier.padding(12.dp)) }
 AddTaskRow(onAddTask)
 when { uiState.isLoading -> CircularProgressIndicator(); uiState.tasks.isEmpty() -> Text("No tasks yet. Add your first one above."); else -> LazyColumn(Modifier.weight(1f)) { items(uiState.tasks, key = { it.id }) { TaskRow(it, onTaskCheckedChange, onDeleteTask) } } }
 }
 }
 }
 @Composable fun AddTaskRow(onAddTask: (String) -> Unit) {
 var newTitle by rememberSaveable { mutableStateOf("") }
 Row(verticalAlignment = Alignment.CenterVertically) {
 OutlinedTextField(value = newTitle, onValueChange = { newTitle = it }, label = { Text("New task") }, singleLine = true, modifier = Modifier.weight(1f))
 Button(onClick = { onAddTask(newTitle); newTitle = "" }) { Text("Add") }
 }
 }