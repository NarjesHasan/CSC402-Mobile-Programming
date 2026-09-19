# Implementation Plan - CSC402 Lab 2

Complete CSC402 Lab 2 Part A (Kotlin console tasks) and Part B (Jetpack Compose screens), including documentation and screenshots.

## User Review Required

> [!IMPORTANT]
> The specification for Task 1-4 was not found in the repository. I will implement standard Kotlin exercises (Variables, Control Flow, Functions, Collections) that lead up to Task 5, as is typical for this course's curriculum.

## Proposed Changes

### Part A: Kotlin Console Tasks

#### [NEW] [Task1.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-a/Task1.kt)
Basic variables and data types demonstration.

#### [NEW] [Task2.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-a/Task2.kt)
Control flow using `if` and `when`.

#### [NEW] [Task3.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-a/Task3.kt)
Function definitions and calls.

#### [NEW] [Task4.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-a/Task4.kt)
Basic list operations.

#### [NEW] [Task5.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-a/Task5.kt)
Implementation of the `Course` data class and specific collection operations (filter, map, sumOf, firstOrNull, findCourse, copy) as requested.

---

### Part B: Jetpack Compose Screens

#### [MODIFY] [WelcomeScreen.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-b/app/src/main/java/edu/iau/cshj/csc402/lab2/WelcomeScreen.kt)
Finalize Task 6 with Navy bar, JU avatar, and green chip.

#### [NEW] [StudentIdScreen.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-b/app/src/main/java/edu/iau/cshj/csc402/lab2/StudentIdScreen.kt)
Task 7: Student identity card with Narjes's info and reusable `StatItem`.

#### [NEW] [CounterScreen.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-b/app/src/main/java/edu/iau/cshj/csc402/lab2/CounterScreen.kt)
Task 8: Counter with `mutableStateOf` and derived messages.

#### [NEW] [GreetingScreen.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-b/app/src/main/java/edu/iau/cshj/csc402/lab2/GreetingScreen.kt)
Task 9: Text input greeting with letter count derivation.

#### [NEW] [CourseListScreen.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-b/app/src/main/java/edu/iau/cshj/csc402/lab2/CourseListScreen.kt)
Task 10: `LazyColumn` for 7 courses with specific card styling.

#### [NEW] [TaskTrackerScreen.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-b/app/src/main/java/edu/iau/cshj/csc402/lab2/TaskTrackerScreen.kt)
Task 11: Interactive task list with summary strip and "Add Task" functionality.

---

### Infrastructure & Documentation

#### [MODIFY] [MainActivity.kt](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/part-b/app/src/main/java/edu/iau/cshj/csc402/lab2/MainActivity.kt)
Update to allow switching between screens for screenshots.

#### [NEW] [Lab2_Writeup.html](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/docs/Lab2_Writeup.html)
Comprehensive report including console output, screenshots, and experiment answers.

#### [MODIFY] [README.md](file:///C:/Users/narje/OneDrive/Documents/CSC402-Mobile-Programming/labs/lab2-2240002170/README.md)
Update with student and environment information.

## Verification Plan

### Automated Tests
- Build project using `./gradlew :app:assembleDebug`.
- Run Part A Kotlin files and capture output.

### Manual Verification
- Deploy each screen (Task 6-11) to the emulator.
- Capture real screenshots of each screen.
- Verify all UI interactions (Counter, Greeting input, Task toggles) work as expected.
