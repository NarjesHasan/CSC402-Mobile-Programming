package com.example.lab23

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab23.ui.theme.Lab23Theme

data class Student(
    val name: String,
    val program: String,
    val gpa: String,
    val email: String,
    val city: String
)

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

                // Task 3: Avatar + green badge
                Box(
                    modifier = Modifier.size(52.dp)
                ) {

                    // Avatar circle
                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .clip(CircleShape)
                            .background(Color(0xFF123B5D)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "AQ",
                            color = Color.White,
                            fontWeight = FontWeight.Bold
                        )
                    }

                    // Green status badge
                    Box(
                        modifier = Modifier
                            .size(15.dp)
                            .align(Alignment.BottomEnd)
                            .clip(CircleShape)
                            .background(Color.Green)
                            .border(
                                width = 2.dp,
                                color = MaterialTheme.colorScheme.surface,
                                shape = CircleShape
                            )
                    )
                }

                Spacer(
                    modifier = Modifier.width(12.dp)
                )

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = student.name,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = student.program,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                }

                Text(
                    text = student.gpa,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            HorizontalDivider()

            Text(
                text = student.email,
                fontSize = 14.sp
            )

            Text(
                text = student.city,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StudentCardPreview() {
    Lab23Theme {
        StudentCard(
            student = Student(
                name = "Narjes Al-Wohaib",
                program = "Computer Science",
                gpa = "4.52",
                email = "2240002170@iau.edu.sa",
                city = "Qatif, Eastern Province"
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
