# CSC 402 · Lab 7: AndroidView and LazyColumn

## Projects

- `Lab7_Task2/`: Android `RatingBar` embedded with `AndroidView`, rating state synchronization, reset, and `Lab07` Logcat messages.
- `Lab7_Task3/`: university site displayed with `WebView` inside `AndroidView`; INTERNET permission is declared.
- `Lab07CourseFeedback/`: integrated home screen linking the course rating and campus news routes.
- `StudyPlanner/`: task list with `LazyColumn`, checkboxes, typed detail navigation, and system share chooser. The canonical Lab 4/5 StudyPlanner remains in `labs/lab4-2240002170/StudyPlanner/`.

## Run

Open any project folder containing `settings.gradle.kts` in Android Studio, allow Gradle sync, start an emulator, select the `app` run configuration, then press **Run**.

## Verification

Each project builds with `:app:assembleDebug`. The integrated app's rating screen supports 0.5-star increments and Reset. Campus news loads `https://www.iau.edu.sa` in the embedded WebView and its Back button returns to the app home screen.

The integrated app keeps rating state in `rememberSaveable` and emits `factory` and `update` messages under the `Lab07` Logcat tag.

## AI assistance disclosure

Codex assisted with project review, a WebView layout fix, builds, and emulator smoke checks on 30 October 2026. The source behavior and UI were reviewed after the changes.
