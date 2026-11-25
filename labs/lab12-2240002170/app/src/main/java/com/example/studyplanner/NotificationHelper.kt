package com.example.studyplanner

import android.Manifest
 import android.app.NotificationChannel
 import android.app.NotificationManager
 import android.content.Context
 import android.content.pm.PackageManager
 import android.os.Build
 import androidx.core.app.NotificationCompat
 import androidx.core.app.NotificationManagerCompat
 import androidx.core.content.ContextCompat
 const val REMINDER_CHANNEL_ID = "study_reminders"
 fun createReminderChannel(context: Context) {
 if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
 val channel = NotificationChannel(REMINDER_CHANNEL_ID, "Study reminders", NotificationManager.IMPORTANCE_DEFAULT)
 channel.description = "A daily reminder of unfinished tasks"
 context.getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
 }
 }
 fun showReminder(context: Context, unfinished: Int) {
 if (Build.VERSION.SDK_INT >= 33 && ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) return
 createReminderChannel(context)
 val notification = NotificationCompat.Builder(context, REMINDER_CHANNEL_ID).setSmallIcon(R.drawable.ic_notification).setContentTitle("Study Planner").setContentText("You have $unfinished unfinished tasks.").build()
 NotificationManagerCompat.from(context).notify(1, notification)
 }