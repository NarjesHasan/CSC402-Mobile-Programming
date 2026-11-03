package edu.iau.cshj.csc402.lab8

data class StudyTask(
    val id: Int,
    val title: String,
    val course: String,
    val isDone: Boolean = false
)
