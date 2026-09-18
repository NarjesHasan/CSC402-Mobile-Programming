package edu.iau.cshj.csc402.lab3

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

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
    // TODO: Task 2 fills this in
}

@Preview(showBackground = true)
@Composable
private fun StudentCardPreview() {
    val sampleStudent = Student(
        name = "Narjes Al-Wohaib",
        program = "Computer Science",
        gpa = "4.52",
        email = "2240002170@iau.edu.sa",
        city = "Qatif"
    )
    // CSC402Lab3Theme {
    //     StudentCard(student = sampleStudent)
    // }
}
