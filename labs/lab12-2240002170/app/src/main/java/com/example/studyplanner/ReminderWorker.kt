package com.example.studyplanner

import android.content.Context
 import androidx.work.*
 import java.util.concurrent.TimeUnit
 class ReminderWorker(context: Context, params: WorkerParameters) : CoroutineWorker(context, params) {
 override suspend fun doWork(): Result {
 val unfinished = StudyDatabase.getDatabase(applicationContext).studyTaskDao().countUnfinished()
 if (unfinished > 0) showReminder(applicationContext, unfinished)
 return Result.success()
 }
 }
 fun scheduleDailyReminder(context: Context) {
 val constraints = Constraints.Builder().setRequiresBatteryNotLow(true).build()
 val request = PeriodicWorkRequestBuilder<ReminderWorker>(1, TimeUnit.DAYS).setConstraints(constraints).build()
 WorkManager.getInstance(context).enqueueUniquePeriodicWork("daily_reminder", ExistingPeriodicWorkPolicy.KEEP, request)
 }