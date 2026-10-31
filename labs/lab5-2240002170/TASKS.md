# Lab 5 — task-by-task work map

Guided Tasks 1–4 are separate sections below and build on one `Lab05Courses` app. The individual Semester App Part 2 is a separate `StudyPlanner/` snapshot.

## Guided Task 1 — Ask another app

- **1.1–1.4:** `HomeRoute` sends `ACTION_VIEW` to the university site and `ACTION_DIAL` to the department number. Both catch `ActivityNotFoundException` and show a Toast.
- **1.5:** The unsupported `csc402://home` URI is documented to produce the “No app can open this” Toast with the catch; without the catch, Android reports `ActivityNotFoundException`.
- **Implementation:** `Lab05Courses/app/src/main/java/sa/edu/iau/cshj/lab05/ui/CourseScreens.kt`.

## Guided Task 2 — Plan the screens and routes

- **2.1–2.3:** Home and course list need no route argument; course detail needs a course code.
- **2.4–2.5:** Navigation Compose and matching Kotlin serialization plugin are configured; `Routes.kt` declares serializable `Home`, `CourseList`, and `CourseDetail(code)`.
- **Implementation:** `Lab05Courses/app/src/main/java/sa/edu/iau/cshj/lab05/navigation/Routes.kt` and project Gradle files.

## Guided Task 3 — Connect the screens

- **3.1–3.2:** `CourseApp` owns the NavController, navigates from list to detail, reads the typed route with `toRoute()`, and pops on Back; `MainActivity` starts `CourseApp`.
- **3.3–3.5:** The selected course code appears on detail; system Back returns through the stack; `CourseListScreen` reports taps through a callback and has no NavController.
- **Implementation:** `Lab05Courses/app/src/main/java/sa/edu/iau/cshj/lab05/navigation/CourseApp.kt` and `ui/CourseScreens.kt`.

## Guided Task 4 — Share, back stack, and broken-route exercise

- **4.1–4.3:** Course detail shares text via `ACTION_SEND`, `text/plain`, and a “Share via” chooser. The README records the requested back-stack sequence.
- **4.4–4.5:** Removing `@Serializable` from `CourseDetail` is documented to cause the typed-route serializer error; the committed route keeps the annotation.
- **Evidence:** home, list, detail, and share-sheet screenshots are in `submission-evidence/lab05/`.

## Semester App Part 2 — individual assignment

- **P2.1:** Paper sketch omitted at the student's request.
- **P2.2–P2.4:** `StudyPlanner/` has serializable home/detail routes, three tasks, and click events carrying the selected title.
- **P2.5:** Stateless detail screen with Share and Back events plus two title previews.
- **P2.6–P2.7:** `TaskDetailRoute` shares title-containing text; `StudyPlannerApp` navigates using the tapped title and returns with `popBackStack()`.
- **Submission evidence:** `submission-evidence/lab05/lab05_studyplanner_part2_home.png`, `lab05_studyplanner_part2_detail.png`, `lab05_studyplanner_part2_share_sheet.png`, and `lab05_studyplanner_part2_compose_previews.jpg`.

