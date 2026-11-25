# Adding the three lecture projects
Copy only the three folders inside `labs/` into your existing repository's `labs/` folder. Do not overwrite old labs.

Gradle wrapper binary is not bundled. Copy `gradlew`, `gradlew.bat` and `gradle/wrapper/gradle-wrapper.jar` from your existing Lab 8 into each project (keep the supplied wrapper properties). Alternatively, generate the wrapper with installed Gradle: `gradle wrapper --gradle-version 8.11.1`. Then open each project in Android Studio, sync and run.

Build versions selected for an AGP 8.9 / JDK 17 toolchain: Kotlin 2.1.20, Room 2.7.2, WorkManager 2.10.1. They differ from the newer lecture guide versions; upgrade only if your instructor requires them and your toolchain supports them.

Suggested README index additions after verification:
| Lab 6 | Lifecycle, State Hoisting & ViewModel | [labs/lab6-2240002170/](labs/lab6-2240002170/) | Completed after testing |
| Lab 10 | Room, Coroutines & Flow | [labs/lab10-2240002170/](labs/lab10-2240002170/) | Completed after testing |
| Lab 12 | Broadcast Receivers & WorkManager | [labs/lab12-2240002170/](labs/lab12-2240002170/) | Completed after testing |

Lecture 6 required commit message: `Lecture 6: Study Planner Route, Screen and ViewModel`. Record AI use honestly; submit repository link in Blackboard. Lecture 10 and 12 GitHub submission not confirmed by the supplied guides.
