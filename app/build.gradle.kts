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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    //ksp
    ksp("androidx.room:room-compiler:2.8.3")


    //open csv
    implementation("com.github.dokar:kotlin-csv:1.5.0")

    //coil

    implementation("io.coil-kt:coil-compose:2.7.0")

    //compose nav destinations
    implementation("io.github.raamcosta.compose-destinations:core:2.3.0")
    ksp("io.github.raamcosta.compose-destinations:ksp:2.3.0")

   //dagger hilt
     implementation("com.google.dagger:hilt-android:2.57.2")
     ksp("com.google.dagger:hilt-android-compiler")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    ksp("androidx.hilt:hilt-compiler:1.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01")


    //compose dependencies
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.0-alpha01")
    implementation("androidx.activity:activity-compose:1.7.0-alpha01")
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.28.0 ")


    //Retrofit

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.11.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.14")


    // room
    
    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")


}