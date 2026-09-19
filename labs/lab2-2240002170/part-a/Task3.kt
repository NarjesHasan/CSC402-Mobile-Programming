/**
 * Task 3: Functions
 * Student: Narjes Al-Wohaib (2240002170)
 */

fun calculateFinalScore(quiz: Double, mid: Double, final: Double): Double {
    return (quiz * 0.2) + (mid * 0.3) + (final * 0.5)
}

fun formatMessage(name: String, score: Double): String {
    return "Student $name achieved a weighted score of ${String.format("%.2f", score)}"
}

fun main() {
    val name = "Narjes"
    val quiz = 95.0
    val mid = 88.0
    val final = 92.0

    val finalScore = calculateFinalScore(quiz, mid, final)
    println("--- Task 3: Score Calculation ---")
    println(formatMessage(name, finalScore))
}
