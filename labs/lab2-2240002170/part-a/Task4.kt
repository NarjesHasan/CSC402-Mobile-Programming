/**
 * Task 4: List Operations
 * Student: Narjes Al-Wohaib (2240002170)
 */

fun main() {
    val programmingLanguages = listOf("Kotlin", "Java", "Python", "C++", "Swift")
    
    println("--- Task 4: List of Languages ---")
    println("Original list: $programmingLanguages")
    
    println("First language: ${programmingLanguages.first()}")
    println("Last language: ${programmingLanguages.last()}")
    
    val sortedLanguages = programmingLanguages.sorted()
    println("Sorted list: $sortedLanguages")
    
    val containsKotlin = if ("Kotlin" in programmingLanguages) "Yes" else "No"
    println("Does the list contain Kotlin? $containsKotlin")
}
