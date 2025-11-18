import org.gradle.kotlin.dsl.androidTestImplementation
import org.gradle.kotlin.dsl.coreLibraryDesugaring
import org.gradle.kotlin.dsl.debugImplementation
import org.gradle.kotlin.dsl.implementation
import org.gradle.kotlin.dsl.testImplementation

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)



    alias(libs.plugins.kotlin.compose)







    id("com.google.devtools.ksp")

}

android {
    namespace = "com.fire.stonks"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.fire.stonks"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}


dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.room.common.jvm)
    implementation(libs.androidx.navigation.safe.args.generator)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.ktx)
    implementation(libs.androidx.room.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)

    // ksp
    ksp("androidx.room:room-compiler:2.8.3")
    ksp("com.google.dagger:hilt-android-compiler:2.51.1")
    ksp("androidx.hilt:hilt-compiler:1.2.0")
    ksp("io.github.raamcosta.compose-destinations:ksp:2.0.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.14")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // ✅ Compose Destinations (fixed versions)
    implementation("io.github.raamcosta.compose-destinations:core:2.0.0")

    // ✅ Navigation for Compose
    implementation("androidx.navigation:navigation-compose:2.8.0")

    // ✅ ViewModel for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.6")

    // ✅ Replace deprecated Accompanist SwipeRefresh with new pull-to-refresh
    // Remove this:
    // implementation("com.google.accompanist:accompanist-swiperefresh:<latest_version>")
    // Add this instead (official API):

    // or if you use Material3:
    // implementation("androidx.compose.material3:material3-pulltorefresh:1.3.1")
    implementation("androidx.compose.ui:ui-tooling:1.9.4")

    // Dagger - Hilt
    implementation("com.google.dagger:hilt-android:2.57.2")
    implementation("androidx.hilt:hilt-navigation-compose:1.3.0")
    ksp("com.google.dagger:hilt-compiler:2.57.2")

        implementation ("io.github.raamcosta.compose-destinations:core:2.3.0")
        ksp("io.github.raamcosta.compose-destinations:ksp:2.3.0")
//open csv
    implementation("com.opencsv:opencsv:5.12.0")



    // Compose dependencies

    // OpenCSV


    // Compose dependencies
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.9.4")
    implementation( "androidx.compose.material:material-icons-extended:1.7.8")
    
    implementation ("com.google.accompanist:accompanist-swiperefresh:0.36.0")

    // Compose Nav Destinations
    implementation ("io.github.raamcosta.compose-destinations:core:2.3.0")
    ksp ("io.github.raamcosta.compose-destinations:ksp:2.3.0")


    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:3.0.0")
    implementation ("com.squareup.retrofit2:converter-moshi:3.0.0")
    implementation( "com.squareup.okhttp3:okhttp:5.3.1")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.3.0")



    // Kotlin Extensions and Coroutines support for Room
    implementation( "androidx.room:room-ktx:2.4.2")


}
