# AI Use & Disclosure Log — Lab 5

**Student Name:** Narjes Hasan  
**Student ID:** 2240002170  
**Course:** CSC 402 — Mobile Application Programming  
**Lab:** Lab 5 (Intents and Navigation)

---

| Date | Tool / Assistant Used | Task / Prompt | Output Received | Modifications Made |
| :--- | :--- | :--- | :--- | :--- |
| Oct 16, 2026 | Android Studio AI Assistant (Agent Mode) | Assist with Navigation Compose setup, `@Serializable` typed routes, implicit intents (`ACTION_VIEW`, `ACTION_DIAL`, `ACTION_SEND`), and StudyPlanner Part 2 extension. | Generated route structures, `NavHost` wiring, `Intent` creation logic with `createChooser`, and exception handling for `ActivityNotFoundException`. | Verified architecture compliance (no screen takes `NavController`, intents built in routes), tested build compilation, and documented broken route/intent experiments. |
| Oct 30, 2026 | OpenAI Codex | Compare Lab 5 implementation against the instructor's exercise sheet and provided `CourseScreens.kt`. | Found the course app TODOs already implemented and the StudyPlanner Part 2 snapshot missing from the Lab 5 folder. | Kept and reviewed the instructor starter screens, added a Lab 5 StudyPlanner snapshot with title-based routes, three home tasks, detail previews, and share chooser; built the app. |
| Oct 31, 2026 | OpenAI Codex | Audit non-paper Lab 5 requirements and submission evidence against the supplied exercise sheet and starter file. | Confirmed the typed routes, event-driven navigation, safe browser/dial intents, share chooser, and required screenshot set are present. | Re-rendered and added the two detail previews screenshot; updated its README capture reference. No implementation changes were needed. |
| Oct 31, 2026 | OpenAI Codex | Organize Lab 5 guided code by task and remove duplicated source snapshots. | Split home/intents, routes, course list/navigation, and course detail/share into Task folders. | Pointed the runnable guided app at those single source files; `:app:assembleDebug` succeeded. |
