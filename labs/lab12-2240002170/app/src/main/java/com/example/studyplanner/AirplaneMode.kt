package com.example.studyplanner

import android.content.*
 import android.provider.Settings
 import androidx.compose.runtime.*
 import androidx.compose.ui.platform.LocalContext
 import androidx.core.content.ContextCompat
 class AirplaneModeReceiver(private val onChange: (Boolean) -> Unit) : BroadcastReceiver() {
 override fun onReceive(context: Context, intent: Intent) { if (intent.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) onChange(isAirplaneModeOn(context)) }
 }
 fun isAirplaneModeOn(context: Context): Boolean = Settings.Global.getInt(context.contentResolver, Settings.Global.AIRPLANE_MODE_ON, 0) != 0
 @Composable fun rememberAirplaneModeOn(): Boolean {
 val context = LocalContext.current
 var isOn by remember { mutableStateOf(isAirplaneModeOn(context)) }
 DisposableEffect(context) {
 val receiver = AirplaneModeReceiver { isOn = it }
 ContextCompat.registerReceiver(context, receiver, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED), ContextCompat.RECEIVER_EXPORTED)
 onDispose { context.unregisterReceiver(receiver) }
 }
 return isOn
 }