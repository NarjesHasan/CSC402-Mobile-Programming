package com.example.lab23

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Alignment
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    usePadding: Boolean = true,
    modifier: Modifier = Modifier
) {
    val students = listOf(
        Student("Narjes Al-Wohaib", "Computer Science", "4.52", "2240002170@iau.edu.sa", "Qatif"),
        Student("Abdulrahman Al-Mutairi", "Information Systems", "4.85", "abdulrahman@example.com", "Riyadh"),
        Student("Sarah Al-Ghamdi", "Software Engineering", "4.70", "sarah@example.com", "Dammam"),
        Student("Fahad Al-Qahtani", "Computer Science", "4.20", "fahad@example.com", "Jubail"),
        Student("Lujain Al-Subaie", "Cyber Security", "4.95", "lujain@example.com", "Khobar")
    )

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(title = { Text("My Profile") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { }) {
                Icon(Icons.Default.Edit, contentDescription = "Edit profile")
            }
        }
    ) { innerPadding ->
        val contentModifier = if (usePadding) Modifier.padding(innerPadding) else Modifier
        
        Column(modifier = contentModifier.padding(horizontal = 16.dp)) {
            // Header Row
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Student Directory", style = MaterialTheme.typography.titleMedium)
                Text("${students.size} students", style = MaterialTheme.typography.bodySmall)
            }

            LazyColumn(
                contentPadding = PaddingValues(bottom = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(students) { student ->
                    StudentCard(student = student)
                }
            }
        }
    }
}
