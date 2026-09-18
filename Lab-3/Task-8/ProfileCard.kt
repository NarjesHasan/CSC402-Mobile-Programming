package edu.iau.cshj.csc402.lab3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab23.ui.theme.CSC402Lab3Theme

data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.draw.clip

@Composable
fun StudentCard(
    student: Student,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Task 3: Avatar + status badge
                Box(
                    modifier = Modifier.size(52.dp)
                ) {
                    // Avatar circle
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.primaryContainer),
                        contentAlignment = Alignment.Center
                    ) {
                        val initials = student.name.split(" ")
                            .mapNotNull { it.firstOrNull()?.toString() }
                            .joinToString("")
                            .take(2)
                            .uppercase()
                        Text(
                            text = initials,
                            color = MaterialTheme.colorScheme.onPrimaryContainer,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }

                    // Status dot with ring
                    Box(
                        modifier = Modifier
                            .size(14.dp)
                            .align(Alignment.BottomEnd)
                            .clip(CircleShape)
                            .background(MaterialTheme.colorScheme.tertiary)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.surface,
                                shape = CircleShape
                            )
                    )
                }

                Spacer(modifier = Modifier.width(12.dp))

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = student.name,
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                    Text(
                        text = student.program,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
                Text(
                    text = student.gpa,
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            HorizontalDivider()

            Text(
                text = student.email,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Text(
                text = student.city,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }
    }
}

import android.content.res.Configuration

@Preview(name = "Light", showBackground = true)
@Preview(
    name = "Dark",
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
private fun StudentCardPreview() {
    val sampleStudent = Student(
        name = "Nora Al-Qahtani",
        program = "Information Systems",
        gpa = "4.44",
        email = "2240008667@iau.edu.sa",
        city = "Khobar"
    )
    CSC402Lab3Theme {
        StudentCard(
            student = sampleStudent,
            modifier = Modifier.padding(16.dp)
        )
    }
}
