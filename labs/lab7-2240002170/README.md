# CSC 402 · Lab 7: AndroidView and LazyColumn

## Projects

- `Lab7_Task2/`: Android `RatingBar` embedded with `AndroidView`, rating state synchronization, reset, and `Lab07` Logcat messages.
- `Lab7_Task3/`: university site displayed with `WebView` inside `AndroidView`; INTERNET permission is declared.
- `Lab07CourseFeedback/`: integrated home screen linking the course rating and campus news routes.
- `StudyPlanner/`: Semester App Part 4 snapshot with task list, `LazyColumn`, checkboxes, typed detail navigation, and system share chooser. Earlier assignment stages are kept in the Lab 4 and Lab 5 folders.

## Run

Open any project folder containing `settings.gradle.kts` in Android Studio, allow Gradle sync, start an emulator, select the `app` run configuration, then press **Run**.

## Verification

Each project builds with `:app:assembleDebug`. The integrated app's rating screen supports 0.5-star increments and Reset. Campus news loads `https://www.iau.edu.sa` in the embedded WebView and its Back button returns to the app home screen.

The integrated app keeps rating state in `rememberSaveable` and emits `factory` and `update` messages under the `Lab07` Logcat tag.

The code includes three Compose previews for the Part 4 task list, two detail previews, and one Activity. Emulator captures for the integrated Lab 7 app and Part 4 StudyPlanner list/detail are in `submission-evidence/lab07/` at the repository root. The three task list previews rendered in Android Studio are captured at `submission-evidence/lab07/lab07_studyplanner_part4_compose_previews.jpg`. The exercise sheet also requests a photo of the student's paper sketch for the task row; that photo is not part of the repository.

## AI assistance disclosure

Codex assistance is recorded in [`AI_USE_LOG.md`](AI_USE_LOG.md), including the WebView fix, builds, and emulator smoke checks on 30 October 2026.
