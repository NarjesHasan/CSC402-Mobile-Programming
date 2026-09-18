package edu.iau.cshj.csc402.lab3

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    usePadding: Boolean = true,
    modifier: Modifier = Modifier
) {
    val sampleStudent = Student(
        name = "Narjes Al-Wohaib",
        program = "Computer Science",
        gpa = "4.52",
        email = "2240002170@iau.edu.sa",
        city = "Qatif"
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
        // The column below applies or ignores the innerPadding provided by Scaffold
        val contentModifier = if (usePadding) Modifier.padding(innerPadding) else Modifier
        
        Column(modifier = contentModifier) {
            StudentCard(
                student = sampleStudent,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
