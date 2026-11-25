package com.example.studyplanner

import android.app.Application
 import androidx.lifecycle.AndroidViewModel
 import androidx.lifecycle.viewModelScope
 import kotlinx.coroutines.flow.*
 import kotlinx.coroutines.launch
 class TodayViewModel(application: Application) : AndroidViewModel(application) {
 private val repository = TaskRepository(StudyDatabase.getDatabase(application).studyTaskDao())
 private val _uiState = MutableStateFlow(TodayUiState())
 val uiState: StateFlow<TodayUiState> = _uiState.asStateFlow()
 init { viewModelScope.launch { repository.allTasks.collect { tasks -> _uiState.update { it.copy(isLoading = false, tasks = tasks) } } } }
 fun onAddTask(title: String) { if (title.isBlank()) return; viewModelScope.launch { repository.add(title.trim(), "Mobile Apps"); _uiState.update { it.copy(message = "Task added") } } }
 fun onTaskCheckedChange(task: StudyTask, done: Boolean) { viewModelScope.launch { repository.setDone(task, done); if (done) _uiState.update { it.copy(message = "Marked as done") } } }
 fun onDeleteTask(task: StudyTask) { viewModelScope.launch { repository.delete(task); _uiState.update { it.copy(message = "Task deleted") } } }
 fun onMessageShown() { _uiState.update { it.copy(message = null) } }

}