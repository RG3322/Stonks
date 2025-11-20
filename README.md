📈 Stonks – Stock Market Analyzer App

A modern stock-tracking Android app built with Jetpack Compose, Kotlin, Hilt, Retrofit, and Room.

📸 Demo (GIF Coming Soon)



🚀 Overview

Stonks is a clean, fast, and modern Android app that helps users explore real-time market data, store stock entries locally, and analyze performance trends—all powered by Jetpack Compose and a robust MVVM architecture.

This project is part of the Right Node Media internship initiative.

⭐ Features

🔍 Real-Time Stock API Integration (Retrofit + Moshi)

💾 Local Storage using Room Database

🧭 Modern Navigation with Navigation Compose

🎨 Beautiful UI built entirely with Jetpack Compose

⚙️ Dependency Injection using Hilt

📊 CSV Export for stored stock data

🔁 Swipe-to-Refresh using Accompanist

🧭 Typed Navigation with Compose Destinations

🔐 Clean MVVM Architecture

🛠 Tech Stack
Frontend / UI

Jetpack Compose

Material 3

Accompanist

Architecture

MVVM

Kotlin Coroutines & Flow

Compose Destinations

Networking

Retrofit

OkHttp Logging Interceptor

Moshi Converter

Local Storage

Room Database

KSP for compiler processing

Dependency Injection

Hilt + Hilt Navigation Compose

📂 Project Structure
com.fire.stonks/
│
├── data/
│   ├── local/        # Room Database + DAO
│   ├── remote/       # Retrofit API
│   ├── repository/   # Data Repository
│
├── di/               # Hilt Modules
│
├── ui/               # Compose Screens
│
├── util/             # Helper classes & utilities
│
└── MainActivity.kt

📦 Installation
1. Clone the Repository
git clone https://github.com/yourusername/stonks.git
cd stonks

2. Open in Android Studio

Use Android Studio Ladybug or newer

Let Gradle sync automatically

3. Run the App

Set up a physical device or emulator

Click Run ▶️

🔧 Requirements

Android Studio Ladybug or Newer

JDK 17

Kotlin 1.9.25 or above

Android 7.0+ (API 24+)

🧪 Testing
./gradlew test
./gradlew connectedAndroidTest

🧩 Want to Contribute?

Contributions are welcome!

Fork the repo

Create a new branch

Submit a pull request

📝 License

This project is licensed under the MIT License.

👨‍💻 Developed By

rG33
