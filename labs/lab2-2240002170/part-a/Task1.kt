/**
 * Task 1: Basic Variables and Data Types
 * Student: Narjes Al-Wohaib (2240002170)
 */

fun main() {
    val studentName: String = "Narjes Al-Wohaib"
    val studentID: String = "2240002170"
    val gpa: Double = 4.42
    val creditsEarned: Int = 78
    val isActive: Boolean = true

    println("--- Task 1: Student Information ---")
    println("Name: $studentName")
    println("ID: $studentID")
    println("GPA: $gpa")
    println("Credits: $creditsEarned")
    println("Status: ${if (isActive) "Active" else "Inactive"}")
}
