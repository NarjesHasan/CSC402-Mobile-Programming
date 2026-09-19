/**
 * Task 5: Course Management
 * Student: Narjes Al-Wohaib (2240002170)
 */

data class Course(
    val code: String,
    val title: String,
    val credits: Int,
    val days: String
)

fun findCourse(courses: List<Course>, code: String): Course? {
    return courses.find { it.code.equals(code, ignoreCase = true) }
}

fun main() {
    val courses = listOf(
        Course("CSC 402", "Mobile Application Programming", 3, "Mon / Wed"),
        Course("CSC 311", "Database Systems", 4, "Sun / Tue"),
        Course("CSC 340", "Operating Systems", 3, "Mon / Wed"),
        Course("MATH 202", "Discrete Mathematics", 3, "Sun / Thu"),
        Course("ENG 214", "Technical Writing", 2, "Tue")
    )

    println("--- Task 5: Course Management ---")

    // Filter: Courses with 3 or more credits
    val highCreditCourses = courses.filter { it.credits >= 3 }
    println("Courses with >= 3 credits: ${highCreditCourses.map { it.code }}")

    // Map: List of course titles
    val courseTitles = courses.map { it.title }
    println("All course titles: $courseTitles")

    // sumOf: Total credits
    val totalCredits = courses.sumOf { it.credits }
    println("Total registered credits: $totalCredits")

    // firstOrNull: Find a specific course
    val foundCourse = findCourse(courses, "CSC 402")
    println("Search Result (CSC 402): ${foundCourse?.title ?: "Not found"}")

    // copy: Clone and modify
    val updatedCourse = foundCourse?.copy(days = "Mon / Wed / Fri")
    println("Updated Course Schedule: ${updatedCourse?.code} - ${updatedCourse?.days}")
}
