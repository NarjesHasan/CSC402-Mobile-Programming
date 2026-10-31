# CSC 402 · Lab 5: Leaving the Screen: Intents and Navigation

**Student Name:** Narjes Hasan  
**Student ID:** 2240002170  
**Repository Subfolder:** `labs/lab5-2240002170`

Task-by-task implementation and evidence map: [`TASKS.md`](TASKS.md).

---

## Directory Structure

```text
labs/lab5-2240002170/
├── Task-1/ … Task-4/      # One source addition per guided task
├── Lab05Courses/          # Runnable app, compiles the Task folders
├── StudyPlanner/          # Semester App Part 2 snapshot
│   ├── app/src/main/java/sa/edu/iau/cshj/studyplanner/
│   │   ├── navigation/    # PlannerHome / TaskDetail typed routes and NavHost
│   │   └── ui/            # Stateless task list and detail screens
│   └── build.gradle.kts
└── README.md
```

The StudyPlanner directory here is the Part 2 snapshot built on the Lab 4 app. The next supplied snapshot, Part 4, is in `labs/lab7-2240002170/StudyPlanner/`.

The instructor-provided screens are divided across Task 1, Task 3, and Task 4. Their source appears once in the Task folders; Gradle points the runnable Lab05Courses app at those files.

---

## Section 1: Guided Tasks Writeup & Answers (Lab05Courses)

### Task 1 — Ask another app
- **1.1 Event parameters on `HomeScreen`:** `onWebsiteClick: () -> Unit`, `onCallClick: () -> Unit`, `onCoursesClick: () -> Unit`.
- **1.4 Implicit Intent Table:**
  | Button | Action | Data (Uri) | Scheme | App Opened |
  | :--- | :--- | :--- | :--- | :--- |
  | University website | `Intent.ACTION_VIEW` | `https://www.iau.edu.sa` | `https` | Web Browser |
  | Call the department | `Intent.ACTION_DIAL` | `tel:0138000000` | `tel` | Phone Dialer |

- **1.5 Changing URL to `"csc402://home"`:**
  - *Observation:* Toast pop-up message "No app can open this" appears on screen.
  - *Why app did not crash:* The `try { context.startActivity(intent) } catch (e: ActivityNotFoundException)` block intercepted the exception raised when no application registered handling for `csc402://`.

- **1.6 Removing `try/catch` block and tapping `"csc402://home"`:**
  - *Observation:* App crashes instantly upon button click.
  - *Logcat Exception:* `android.content.ActivityNotFoundException: No Activity found to handle Intent { act=android.intent.action.VIEW dat=csc402://home }`

### Task 2 — Plan the screens
- **2.1 Screen List:** `Home`, `CourseList`, `CourseDetail`.
- **2.2 Screen needing extra info:** `CourseDetail` requires `code: String`.
- **2.3 Route Types:**
  - `@Serializable object Home`
  - `@Serializable object CourseList`
  - `@Serializable data class CourseDetail(val code: String)`

### Task 3 — Connect the screens
- **3.3 Code shown on detail screen when tapping CSC 231:** Displays "CSC 231".
  - *Line carrying data:* `navController.navigate(CourseDetail(code = code))` in `CourseListScreen` callback and `backStackEntry.toRoute<CourseDetail>()` in `NavHost`.
- **3.4 System Back gesture twice from detail screen:**
  - *Path:* `CourseDetail` -> `CourseList` -> `Home`.
  - *Handler:* Android Navigation Compose `NavController` automatically manages stack popping.
- **3.5 Does `CourseListScreen` know `NavController` exists?** No. `CourseListScreen` is completely decoupled and reports user taps via `onCourseClick: (String) -> Unit`.

### Task 4 — Share sheet, back stack trace & broken route experiment
- **4.2 Share sheet apps:** Messages, Email / Gmail, Bluetooth, Drive. No `try/catch` is needed for `Intent.createChooser` because the Android system chooser UI is guaranteed to present safely.
- **4.3 Back Stack Trace Table:**
  | Step | User Action | Back Stack (Bottom -> Top) |
  | :--- | :--- | :--- |
  | 1 | App opens | `Home` |
  | 2 | Tap "Browse courses" | `Home`, `CourseList` |
  | 3 | Tap "CSC 402" | `Home`, `CourseList`, `CourseDetail("CSC 402")` |
  | 4 | Tap on-screen "Back" button | `Home`, `CourseList` |
  | 5 | Tap "CSC 231" | `Home`, `CourseList`, `CourseDetail("CSC 231")` |

- **4.4 Removing `@Serializable` from `CourseDetail`:**
  - *Compiler Error:* `Serializer has not been found for class CourseDetail` on `composable<CourseDetail>`.
  - *Logcat Exception:* `kotlinx.serialization.SerializationException: Serializer for class 'CourseDetail' is not found. Mark the class as @Serializable or provide the serializer explicitly.`

---

## Section 2: Semester App — Part 2 Implementation (StudyPlanner)

### Summary of Part 2 Extensions
1. **Typed Navigation Routes (`navigation/Routes.kt`):**
   - `@Serializable object PlannerHome`
   - `@Serializable data class TaskDetail(val title: String)`
2. **Home list:** `PlannerUiState` carries at least three sample task titles; `PlannerHomeScreen` reports taps through `onTaskClick(title)`.
3. **Stateless `TaskDetailScreen` & `TaskDetailRoute`:**
   - Displays the task title, Share button, and Back button; includes two title previews.
4. **Implicit Share Intent (`ACTION_SEND`):**
   - Built inside `TaskDetailRoute` using `Intent(Intent.ACTION_SEND)`.
   - Sets `EXTRA_TEXT` ("Today I'm studying: $title") and `type = "text/plain"`.
   - Wrapped in `Intent.createChooser(send, "Share via")`.
5. **App Container (`StudyPlannerApp`):**
   - Contains `NavHost(navController, startDestination = PlannerHome)`.
   - Handles navigation transitions with `navigate(TaskDetail(taskId))` and `popBackStack()`.
   - Screen composables remain 100% free of `NavController` references.

---

## Section 3: Paper Sketch & Navigation Map (P2.1 Outline)

```text
+------------------------------------+       +------------------------------------+
|            PlannerHome             | ----> |            TaskDetail              |
|                                    | (tap) |                                    |
| Greeting: "Hello, Narjes!"         |       | Title: "Lab 4 report"              |
| Your study tasks:                  |       |                                    |
| - Lab 4 report                     | <---- | [ Share ]   [ Back ]               |
| - Review Lecture 5                 | (back)|                                    |
| - Prepare CSC 402 notes            |       |                                    |
+------------------------------------+       +------------------------------------+
```

---

## Section 4: Screenshot Capture Guide

To capture evidence images in Android Studio / Emulator:
1. The running Lab05Courses home, list, detail, and share sheet captures are in `submission-evidence/lab05/` at repository root.
2. The StudyPlanner Part 2 home, detail, and share chooser captures are `lab05_studyplanner_part2_home.png`, `lab05_studyplanner_part2_detail.png`, and `lab05_studyplanner_part2_share_sheet.png` in the same folder.
3. Both `TaskDetailScreen` previews rendered in Android Studio and are captured at `submission-evidence/lab05/lab05_studyplanner_part2_compose_previews.jpg`.



