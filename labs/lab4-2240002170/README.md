# CSC 402 · Lab 4: Activities, Composables, and State

**Student Name:** Narjes Hasan  
**Student ID:** 2240002170  
**Repository Subfolder:** `labs/lab4-2240002170`

---

## Directory Structure

```text
labs/lab4-2240002170/
├── Lab04Attendance/       # Guided Tasks Application
│   ├── app/src/main/
│   │   ├── AndroidManifest.xml
│   │   └── java/sa/edu/iau/cshj/lab04/
│   │       ├── MainActivity.kt
│   │       └── ui/
│   │           ├── AttendanceScreen.kt
│   │           └── theme/
│   └── build.gradle.kts
├── StudyPlanner/          # Individual Assignment (Semester App - Part 1 & Part 2)
│   ├── app/src/main/
│   │   ├── AndroidManifest.xml
│   │   └── java/sa/edu/iau/cshj/studyplanner/
│   │       ├── MainActivity.kt
│   │       ├── navigation/
│   │       │   ├── Routes.kt
│   │       │   └── StudyPlannerApp.kt
│   │       └── ui/
│   │           ├── PlannerHomeScreen.kt
│   │           ├── TaskDetailScreen.kt
│   │           └── theme/
│   └── build.gradle.kts
└── README.md
```

---

## Section 1: Guided Tasks Writeup & Answers (Lab04Attendance)

### Task 1 — Find the way in
- **1.1 `android:name` on `<activity>` element:** `".MainActivity"` (`sa.edu.iau.cshj.lab04.MainActivity`)
- **1.2 Two `<intent-filter>` lines making this the launch Activity:**
  1. `<action android:name="android.intent.action.MAIN" />`
  2. `<category android:name="android.intent.category.LAUNCHER" />`
- **1.3 Three operations inside `onCreate` (in order):**
  1. `super.onCreate(savedInstanceState)` — Initializes Activity superclass lifecycle.
  2. `enableEdgeToEdge()` — Configures full-screen window insets and system bar layout.
  3. `setContent { Lab04AttendanceTheme { AttendanceRoute() } }` — Sets Compose UI tree content.
- **1.4 Commenting out `<category android:name="android.intent.category.LAUNCHER" />`:**
  - *Observation:* The app still compiles and installs on the device/emulator, but its launcher icon disappears from the home screen / app drawer because Android no longer categorizes it as a launchable entry point.
- **Checkpoint 1 Explanation:** APK installation only requires a valid package declaration. Reachability from the launcher screen specifically requires both `MAIN` action and `LAUNCHER` category.

### Task 2 — Name the state
- **2.1 Screen contents:** Session title ("CSC 402 - Week 4"), checked-in student count ("Checked in: 12"), and a Check-in button ("Check in").
- **2.2 Screen state (dynamic information):** `checkedInCount: Int` and `isCheckedIn: Boolean`.
- **2.3 User action callback name:** `onCheckIn: () -> Unit`.
- **2.4 Data class declaration:**
  ```kotlin
  data class AttendanceUiState(
      val sessionTitle: String = "",
      val checkedInCount: Int = 0,
      val isCheckedIn: Boolean = false
  )
  ```

### Task 3 — Write the screen & Previews
- **3.5 Preview comparison ("Not checked in yet" vs. "Already checked in"):**
  - In "Already checked in", the button displays "Checked In" and is disabled (`enabled = false`).
  - The single field causing this visual and interactive change is `isCheckedIn = true`.

### Task 4 — Make it work, trace, and broken experiment
- **4.4 Trace for one tap:**
  | Step | Event / Action | Executing Function |
  | :--- | :--- | :--- |
  | 1 | User taps the "Check in" `Button` | `AttendanceScreen` |
  | 2 | Button click handler executes `onCheckIn()` callback | `AttendanceScreen` |
  | 3 | Route lambda runs `uiState = uiState.copy(...)` | `AttendanceRoute` |
  | 4 | State value updates; Compose re-composes UI | `AttendanceScreen` |

- **4.6 Broken experiment (`uiState.checkedInCount + 1` calculated & discarded):**
  - *Observation:* Tapping the button produces no UI change (count remains unchanged and button remains active).
  - *Trace Step Failure:* Step 3 failed because `uiState` was never reassigned a new state instance, so Compose did not observe a state mutation and did not trigger re-composition.

---

## Section 2: Semester App — Part 1 (StudyPlanner)

### Architectural Highlights
- **Package:** `sa.edu.iau.cshj.studyplanner`
- **Immutable State:** `PlannerUiState` data class with `greeting`, `totalTasks`, `completedTasks`, and default values.
- **Stateless UI:** `PlannerHomeScreen` receives state in, emits `onTaskClick` / `onIncrementCompleted` callbacks out, and accepts `modifier: Modifier = Modifier` as the last parameter.
- **Route State Ownership:** `PlannerHomeRoute` manages state using `remember { mutableStateOf(PlannerUiState()) }` and applies state updates immutably using `.copy()`.
- **Previews:** Includes `PlannerHomeScreenPreviewZero` (0 completed) and `PlannerHomeScreenPreviewAll` (3 completed).

---

## Section 3: Paper Sketch & Reference Outline (P1.1)

```text
+--------------------------------------------------+
|               Study Planner Home                 |
+--------------------------------------------------+
| Greeting: "Hello, Student!"                      |
| Progress: "0 of 3 done"                          |
|                                                  |
| [ Mark Task Done ]  <-- Increments completed     |
|                                                  |
| Your Study Tasks:                                |
| +----------------------------------------------+ |
| | Lab 4 attendance check & state list          | |
| +----------------------------------------------+ |
| | CSC 402 Lecture slides review                | |
| +----------------------------------------------+ |
| | Lab 5 Navigation & Share sheet               | |
| +----------------------------------------------+ |
+--------------------------------------------------+
```

### State List Summary
- **Shown Information:** Greeting text, progress count, task title buttons.
- **Dynamic State:** `completedTasks: Int`, `totalTasks: Int`, `tasks: List<String>`.
- **User Actions:** `onIncrementCompleted: () -> Unit`, `onTaskClick: (String) -> Unit`.

---

## Section 4: Screenshot Capture Guide

To capture evidence images in Android Studio / Emulator:
1. **PlannerHomeScreen Preview #1 (0 completed):** Open `PlannerHomeScreen.kt` in Android Studio -> Design Split View -> Click Preview screenshot button for `PlannerHomeScreenPreviewZero`. Save as `evidence/planner_home_zero.png`.
2. **PlannerHomeScreen Preview #2 (All completed):** Open `PlannerHomeScreen.kt` -> Design Split View -> Click Preview screenshot button for `PlannerHomeScreenPreviewAll`. Save as `evidence/planner_home_all.png`.
3. **Running StudyPlanner App:** Launch `StudyPlanner` on emulator -> Tap "Mark Task Done" button -> Take screenshot (`Ctrl + S` or ADB tool). Save as `evidence/studyplanner_running.png`.
