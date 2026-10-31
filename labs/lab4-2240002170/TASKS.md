# Lab 4 — task-by-task work map

Each guided task below is listed separately. Tasks 1–4 build on the same `Lab04Attendance` app, as the exercise sheet specifies. The individual Semester App Part 1 is a separate project snapshot in `StudyPlanner/`.

## Guided Task 1 — Find the way in

- **1.1–1.3:** Launcher Activity, manifest intent filter, and `onCreate` entry flow are in `Lab04Attendance/app/src/main/AndroidManifest.xml` and `Lab04Attendance/app/src/main/java/sa/edu/iau/cshj/lab04/MainActivity.kt`.
- **1.4–1.5:** The manifest retains `MAIN` and `LAUNCHER`; the app is left in its runnable launcher state. Expected observation when temporarily removing `LAUNCHER`: install still succeeds, but the launcher icon disappears; restoring it brings the icon back.
- **Checkpoint answer:** `MAIN` plus `LAUNCHER` declares launcher visibility; installability alone does not require a launcher entry.

## Guided Task 2 — Name the state

- **2.1–2.4:** `AttendanceUiState` holds session title, checked-in count, and checked-in flag. The user action is `onCheckIn`. All fields are immutable and defaulted.
- **Implementation:** `Lab04Attendance/app/src/main/java/sa/edu/iau/cshj/lab04/ui/AttendanceScreen.kt`.

## Guided Task 3 — Stateless screen and previews

- **3.1:** `AttendanceScreen` takes state and `onCheckIn`; it renders the count and disables the button after check-in.
- **3.2–3.4:** “Not checked in yet” and “Already checked in” previews are defined in the same screen file.
- **3.5:** The checked-in flag changes the button label/enabled state; the checked-in count also differs by one between sample states.
- **Evidence:** `submission-evidence/lab04/lab04_attendance_before_checkin.png` and `lab04_attendance_after_checkin.png`.

## Guided Task 4 — Route, state update, and broken-state exercise

- **4.1–4.3:** `AttendanceRoute` owns Compose state and handles a tap by replacing it with `copy(checkedInCount = …, isCheckedIn = true)`. `MainActivity` calls the route.
- **4.4 trace:** Button tap → `AttendanceScreen` invokes `onCheckIn` → `AttendanceRoute` creates new state → Compose redraws the screen.
- **4.5–4.7:** The intentionally broken expression computes a number without assigning it, so the screen remains unchanged. The committed source keeps the working `copy()` update.

## Semester App Part 1 — individual assignment

- **P1.1:** Paper sketch omitted at the student's request.
- **P1.2–P1.4:** `StudyPlanner/` contains the Part 1 project, immutable `PlannerUiState`, stateless `PlannerHomeScreen`, event lambda, and state-owning route.
- **P1.5:** Two previews show 0 of 3 and 3 of 3 tasks complete.
- **P1.6–P1.7:** Route updates via `copy()`; manifest has one launcher Activity and a StudyPlanner label.
- **Submission evidence:** `submission-evidence/lab04/lab04_studyplanner_part1_compose_previews.jpg`, `lab04_studyplanner_part1_running.png`, and `lab04_studyplanner_part1_after_tap.png`.

