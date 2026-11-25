package com.example.studyplanner

import android.content.*
 import android.os.BatteryManager
 import androidx.compose.runtime.*
 import androidx.compose.ui.platform.LocalContext
 import androidx.core.content.ContextCompat
 private fun isCharging(context: Context): Boolean = context.getSystemService(BatteryManager::class.java).isCharging
 @Composable fun rememberIsCharging(): Boolean {
 val context = LocalContext.current
 var charging by remember { mutableStateOf(isCharging(context)) }
 DisposableEffect(context) {
 val receiver = object : BroadcastReceiver() { override fun onReceive(c: Context, i: Intent) { charging = isCharging(c) } }
 val filter = IntentFilter(Intent.ACTION_POWER_CONNECTED).apply { addAction(Intent.ACTION_POWER_DISCONNECTED) }
 ContextCompat.registerReceiver(context, receiver, filter, ContextCompat.RECEIVER_EXPORTED)
 onDispose { context.unregisterReceiver(receiver) }
 }
 return charging
 }