# ToDo App ✅

A simple yet modern **ToDo app built with Kotlin and Jetpack Compose**, showcasing a clean MVVM-ish presentation layer with state-driven UI and Material 3 styling.

---

## Features

- Add tasks via a rounded text field and **floating add button**
- Visual **empty state** when there are no tasks
- Mark tasks as **done/undone** with a checkbox
- Completed tasks are shown with a **strikethrough** style
- Uses **Jetpack Compose Material 3** with a light/dark theme setup

---

## Tech Stack

- **Language:** Kotlin  
- **UI Toolkit:** Jetpack Compose (Material 3, Compose BOM)  
- **Architecture (UI):** ViewModel + Compose (state hoisting with `mutableStateOf`)  
- **Android:**  
  - `minSdk = 24`  
  - `targetSdk = 36`  
  - Edge‑to‑edge layout  
- **Testing:** JUnit, AndroidX Test, Espresso, Compose UI test

---

## Project Structure

```text
todo-app/
│
├─ app/
│  ├─ src/main/
│  │  ├─ AndroidManifest.xml
│  │  ├─ java/com/sirwacheski/todo/
│  │  │  ├─ MainActivity.kt
│  │  │  └─ presentation/
│  │  │     ├─ theme/
│  │  │     │  ├─ Theme.kt
│  │  │     │  ├─ Color.kt
│  │  │     │  └─ Type.kt
│  │  │     ├─ view/
│  │  │     │  └─ MainScreen.kt
│  │  │     └─ viewmodel/
│  │  │        └─ MainScreenViewModel.kt
│  │  └─ res/...
│  └─ build.gradle.kts
└─ settings.gradle.kts
