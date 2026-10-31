# CSC 402 — Lab 4: Activities, Composables, and State

**Student:** Narjes Hasan · **ID:** 2240002170

Task-by-task implementation and evidence map: [`TASKS.md`](TASKS.md).

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

### Guided task answers and checks

- **Task 1:** `MainActivity` is the launcher Activity. The manifest's `MAIN` action and `LAUNCHER` category make its icon appear in the app drawer. Removing `LAUNCHER` does not stop installation, but removes the app's launcher entry; restoring it returns the entry. `onCreate` calls `super`, enables edge-to-edge, then calls `setContent` with the app theme and route.
- **Task 2:** Attendance screen state is the session title, checked-in count, and whether this user has checked in. The event is `onCheckIn`.
- **Task 3:** The two previews differ in count and in the checked-in flag; the latter controls the button's enabled state and label.
- **Task 4:** On tap, `AttendanceScreen` invokes `onCheckIn`, then `AttendanceRoute` creates the next immutable value with `copy`. The intentionally broken expression only calculates a number and discards it, so the UI does not change. The source keeps the working `copy` implementation.

For Semester App Part 1, tapping the button changed the running app from `0 of 3 done` to `1 of 3 done`; the before/after captures are in `submission-evidence/lab04/`.

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

The text diagram in this README is a digital reference sketch. Android Studio Preview captures are included at `submission-evidence/lab04/lab04_studyplanner_part1_compose_previews.jpg`.

## Build

Open either project folder in Android Studio, sync Gradle, select an emulator, and run the `app` configuration. Or run `gradlew.bat :app:assembleDebug` from the project folder.

## AI disclosure

See [`AI_USE_LOG.md`](AI_USE_LOG.md). AI assistance is recorded there as required by the exercise sheet.
