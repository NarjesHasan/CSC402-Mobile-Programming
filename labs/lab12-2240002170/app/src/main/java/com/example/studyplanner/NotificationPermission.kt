package com.example.studyplanner

import android.Manifest
 import android.os.Build
 import androidx.activity.compose.rememberLauncherForActivityResult
 import androidx.activity.result.contract.ActivityResultContracts
 import androidx.compose.runtime.*
 import androidx.compose.ui.platform.LocalContext
 import androidx.core.content.ContextCompat
 import android.content.pm.PackageManager
 @Composable fun AskNotificationPermission() {
 if (Build.VERSION.SDK_INT < 33) return
 val context = LocalContext.current
 val launcher = rememberLauncherForActivityResult(ActivityResultContracts.RequestPermission()) { }
 LaunchedEffect(Unit) { if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) launcher.launch(Manifest.permission.POST_NOTIFICATIONS) }
 }