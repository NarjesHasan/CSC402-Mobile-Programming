# Lab 7 — task-by-task work map

Each guided task has its own section. Tasks 2 and 3 are standalone projects; Task 4 integrates them in `Lab07CourseFeedback/`. Semester App Part 4 is a separate `StudyPlanner/` project.

## Guided Task 1 — Read the old code

- **1.1–1.4:** The worksheet answers compare XML inflation and imperative View updates with Compose, explain Fragment back-stack behavior, and map the old RatingBar, Activity, label, WebView Fragment, and transaction to today's Compose components.
- **Checkpoint:** `findViewById` and Fragment are removed; RatingBar remains an Android View wrapped by `AndroidView`.

## Guided Task 2 — Wrap the RatingBar

- **2.1–2.2:** `StarRating` uses `AndroidView`; `factory` creates a five-star, half-step RatingBar once; the listener reports only `fromUser` changes; `update` copies Compose state into `view.rating`. The screen is stateless and the Route uses `rememberSaveable` with Reset.
- **2.3–2.4:** MainActivity opens the rating route. Rating and label synchronize; Reset returns them to zero.
- **2.5:** `Lab07` Logcat evidence is saved at `submission-evidence/lab07/lab07_rating_logcat.txt`. The recorded session has one `factory` event and `update` values `0.0`, `1.5`, `0.0`, and `4.0`.
- **2.6–2.8:** The source retains the correct `update` line and `rememberSaveable`. README documents the intentional broken-update and rotation comparison outcomes; broken code is not left in the project.
- **Implementation:** `Lab07CourseFeedback/app/src/main/java/sa/edu/iau/cshj/lab07/ui/components/StarRating.kt` and `ui/CourseRating.kt`.

## Guided Task 3 — A web page inside a screen

- **3.1–3.2:** INTERNET permission is declared; `CampusWebPage` creates a WebView, installs `WebViewClient`, and loads the URL inside `factory`.
- **3.3:** University site running inside the app is captured in `submission-evidence/lab07/lab07_campus_news_webview.png`.
- **3.4–3.6:** README records the expected behavior without WebViewClient/INTERNET permission and why `loadUrl` belongs in `factory`.
- **Implementation:** `Lab07CourseFeedback/app/src/main/java/sa/edu/iau/cshj/lab07/ui/CampusNews.kt`.

## Guided Task 4 — One Activity and one NavHost

- **4.1–4.3:** Navigation dependencies and serializable routes are configured; `CourseApp` is the only owner of `navController` and wires Home, CourseRating, and CampusNews.
- **4.4–4.5:** Back-stack sequence and the equivalence to Fragment transactions are recorded in the Lab 7 README.
- **4.6:** All three project manifests have one Activity and launcher; Lab 7 Kotlin sources contain no Fragment, `findViewById`, or RecyclerView.
- **Checkpoint evidence:** rating/reset, news, and home screenshots plus the Logcat text are in `submission-evidence/lab07/`.

## Semester App Part 4 — individual assignment

- **P4.1:** Paper sketch omitted at the student's request.
- **P4.2–P4.4:** `StudyPlanner/` has `StudyTask`, a task-backed `PlannerUiState`, computed progress, stateless `TaskItem`, and a keyed `LazyColumn`.
- **P4.5:** Route starts with five tasks; checkbox changes use `map` and `copy`; row taps navigate through the NavHost to detail.
- **P4.6:** Three previews cover incomplete row, completed row, and five-task list.
- **P4.7:** One launcher Activity; no Fragment, `findViewById`, or RecyclerView.
- **Submission evidence:** `submission-evidence/lab07/lab07_studyplanner_part4_compose_previews.jpg`, `lab07_studyplanner_part4_list.png`, and `lab07_studyplanner_part4_detail.png`.

