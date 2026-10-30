# CSC 402 — Lab 4: Activities, Composables, and State

**Student:** Narjes Hasan · **ID:** 2240002170

## Projects

- `Lab04Attendance/` — guided Activity, immutable UI state, stateless screen, previews, and state-owning route.
- `StudyPlanner/` — Semester App Part 1 home screen. Part 2 is in `labs/lab5-2240002170/StudyPlanner/`; Part 4 is in `labs/lab7-2240002170/StudyPlanner/`.

## Lab04Attendance checklist

- One launcher Activity with `MAIN` and `LAUNCHER` in the manifest.
- `AttendanceUiState` contains the session title, checked-in count, and checked-in flag; all fields are immutable and defaulted.
- `AttendanceScreen` is stateless, reports `onCheckIn`, and disables the button after check-in.
- Two previews show the before and after states.
- `AttendanceRoute` owns the state and replaces it with `copy()` after the tap.

The implementation and guided-task observations are in `Lab04Attendance/app/src/main/java/sa/edu/iau/cshj/lab04/ui/AttendanceScreen.kt`. Attendance emulator captures and Part 1 running-app captures are under `submission-evidence/lab04/` at the repository root (`lab04_studyplanner_part1_running.png`, `lab04_studyplanner_part1_after_tap.png`).

## Semester App Part 1 checklist

- `PlannerUiState` has a greeting, total task count, and completed count with defaults.
- `PlannerHomeScreen` receives state, reports `onMarkTaskDone`, and has a defaulted modifier last.
- Two previews are defined for “Nothing done yet” and “Everything done”.
- `PlannerHomeRoute` owns and updates state with `copy()`.
- The manifest declares one launcher Activity with the StudyPlanner label.

```text
+----------------------------------+
| Hello, Narjes!                   |
| 0 of 3 done                      |
| [ Mark a task done ]             |
+----------------------------------+
```

The text diagram in this README is a digital reference sketch. The assignment also requests a photo of the student's own paper sketch and state list; that photo is not part of this repository. Android Studio Preview screenshots are also still needed for submission.

## Build

Open either project folder in Android Studio, sync Gradle, select an emulator, and run the `app` configuration. Or run `gradlew.bat :app:assembleDebug` from the project folder.

## AI disclosure

See [`AI_USE_LOG.md`](AI_USE_LOG.md). AI assistance is recorded there as required by the exercise sheet.
