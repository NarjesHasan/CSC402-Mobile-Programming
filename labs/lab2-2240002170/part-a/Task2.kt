/**
 * Task 2: Control Flow
 * Student: Narjes Al-Wohaib (2240002170)
 */

fun main() {
    val score = 85
    
    println("--- Task 2: Grade Evaluation ---")
    
    // Using if-else
    val result = if (score >= 60) "Pass" else "Fail"
    println("Score: $score, Result: $result")

    // Using when
    val grade = when {
        score >= 90 -> "A"
        score >= 80 -> "B"
        score >= 70 -> "C"
        score >= 60 -> "D"
        else -> "F"
    }
    println("Letter Grade: $grade")
}
