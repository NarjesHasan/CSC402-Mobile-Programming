package com.example.studyplanner

import androidx.room.*
 import kotlinx.coroutines.flow.Flow
 @Dao interface StudyTaskDao {
 @Query("SELECT * FROM study_tasks ORDER BY id") fun getAllTasks(): Flow<List<StudyTask>>
 @Insert suspend fun insert(task: StudyTask)
 @Update suspend fun update(task: StudyTask)
 @Delete suspend fun delete(task: StudyTask)
 }