# CSC 402 · Lab 7: AndroidView and LazyColumn

Task-by-task implementation and evidence map: [`TASKS.md`](TASKS.md).

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

The code includes three Compose previews for the Part 4 task list, two detail previews, and one Activity. Emulator captures for the integrated Lab 7 app and Part 4 StudyPlanner list/detail are in `submission-evidence/lab07/` at the repository root. The three task list previews rendered in Android Studio are captured at `submission-evidence/lab07/lab07_studyplanner_part4_compose_previews.jpg`. A captured `Lab07` Logcat sample is in `submission-evidence/lab07/lab07_rating_logcat.txt`.

### Guided task checks

- **Task 1:** `setContentView` inflates the old XML into Views; `label.text = ...` is imperative because it directly mutates a View. The Fragment transaction's `addToBackStack` enabled returning to the prior screen; Compose replaces this with Navigation's back stack.
- **Task 2:** `StarRating` constructs its `RatingBar` once in `factory`, reflects Compose state into it in `update`, and only reports touch-originated changes (`fromUser`). The saved Logcat sample shows one `factory` line and subsequent `update` values, including `1.5`, `0.0`, and `4.0`. Reset returns both stars and text to zero. The deliberate removal of `update` would leave the View's stars out of sync with Route state. `rememberSaveable` is the implementation used for rotation restoration.
- **Task 3:** `CampusWebPage` keeps link navigation inside the WebView with `WebViewClient` and calls `loadUrl` once during View creation. Without the client, links can leave the app for a browser. Without INTERNET permission, the page cannot load from the network. Keeping `loadUrl` in `factory` avoids reloading the page on unrelated Compose state updates.
- **Task 4:** The integrated app has serializable routes and a single `CourseApp` NavHost. The back-stack sequence is `Home`; `Home → CourseRating`; `Home`; `Home → CampusNews`; `Home`. The manifest has one Activity, the UI uses Route/Screen separation, and only the NavHost accesses `navController`.

The Logcat excerpt is from the emulator session recorded on 30 October 2026. The source keeps the working implementations; deliberate broken variants are described here but are not left in the submitted code.

## AI assistance disclosure

Codex assistance is recorded in [`AI_USE_LOG.md`](AI_USE_LOG.md), including the WebView fix, builds, and emulator smoke checks on 30 October 2026.
