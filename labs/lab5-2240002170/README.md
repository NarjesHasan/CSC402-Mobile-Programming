# CSC 402 · Lab 5: Leaving the Screen: Intents and Navigation

**Student Name:** Narjes Hasan  
**Student ID:** 2240002170  
**Repository Subfolder:** `labs/lab5-2240002170`

---

## Directory Structure

```text
labs/lab5-2240002170/
├── Lab05Courses/          # Guided Tasks Application
│   ├── app/src/main/
│   │   ├── AndroidManifest.xml
│   │   └── java/sa/edu/iau/cshj/lab05/
│   │       ├── MainActivity.kt
│   │       ├── navigation/
│   │       │   ├── CourseApp.kt
│   │       │   └── Routes.kt
│   │       └── ui/
│   │           ├── CourseScreens.kt
│   │           └── theme/
│   └── build.gradle.kts
└── README.md
```

> **Note on StudyPlanner:** As required by the semester assignment architecture, `StudyPlanner` is maintained as a single, continuous codebase under `labs/lab4-2240002170/StudyPlanner/`. Part 2 additions (Navigation Compose, `TaskDetailScreen`, `ACTION_SEND` Intent sharing, typed routes) have been integrated into `labs/lab4-2240002170/StudyPlanner/`.

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
2. **Stateless `TaskDetailScreen` & `TaskDetailRoute`:**
   - Displays task title, Share button, and Back button.
   - Accepts `TaskDetailUiState(val title: String)`.
3. **Implicit Share Intent (`ACTION_SEND`):**
   - Built inside `TaskDetailRoute` using `Intent(Intent.ACTION_SEND)`.
   - Sets `EXTRA_TEXT` ("Today I'm studying: $title") and `type = "text/plain"`.
   - Wrapped in `Intent.createChooser(sendIntent, "Share task via")`.
4. **App Container (`StudyPlannerApp`):**
   - Contains `NavHost(navController, startDestination = PlannerHome)`.
   - Handles navigation transitions with `navigate(TaskDetail(title))` and `popBackStack()`.
   - Screen composables remain 100% free of `NavController` references.

---

## Section 3: Paper Sketch & Navigation Map (P2.1 Outline)

```text
+------------------------------------+       +------------------------------------+
|            PlannerHome             | ----> |            TaskDetail              |
|                                    | (tap) |                                    |
| Greeting: "Hello, Student!"        |       | Title: "CSC 402 - Mobile App..."   |
| Progress: "0 of 3 done"            |       |                                    |
| Tasks:                             | <---- | [ Share ]   [ Back ]               |
| - CSC 402 Lecture slides review    | (back)|                                    |
+------------------------------------+       +------------------------------------+
```

---

## Section 4: Screenshot Capture Guide

To capture evidence images in Android Studio / Emulator:
1. **StudyPlanner Home Screen (showing >= 3 tasks):** Run `StudyPlanner` -> Capture home screen. Save as `evidence/studyplanner_home.png`.
2. **Task Detail Screen (selected task title):** Tap a task (e.g. "CSC 402 Lecture slides review") -> Capture detail screen. Save as `evidence/task_detail.png`.
3. **Android Share Sheet:** On task detail screen, tap "Share" -> Capture system share dialog. Save as `evidence/share_sheet.png`.
4. **TaskDetailScreen Preview #1:** In `TaskDetailScreen.kt`, render preview `TaskDetailPreview1`. Save as `evidence/task_detail_preview1.png`.
5. **TaskDetailScreen Preview #2:** In `TaskDetailScreen.kt`, render preview `TaskDetailPreview2`. Save as `evidence/task_detail_preview2.png`.
