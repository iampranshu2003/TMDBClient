plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")
}

android {
    namespace = "com.example.tmdbclient"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.tmdbclient"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String","API_KEY","\"078a27b15892f1e2f7b62279a9149e7e\"")
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
    dataBinding {
        enable = true
    }
    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    val lifecycle_version = "2.8.7"
    val arch_version = "2.2.0"
    val room_version = "2.6.1"
    val dagger_version = "2.28.1"
    implementation(libs.androidx.room.runtime)
    // ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    // LiveData
    implementation(libs.androidx.lifecycle.livedata.ktx)
    // Saved state module for ViewModel
    implementation(libs.androidx.lifecycle.viewmodel.savedstate)
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)
    kapt(libs.androidx.room.compiler)

    // Annotation processor
    kapt(libs.androidx.lifecycle.compiler)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    //coroutine dependency
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    //dagger dependency
    implementation(libs.dagger)
    kapt(libs.dagger.compiler)
    //retrofit dependency
    implementation(libs.retrofit)
    //gson dependency
    implementation(libs.converter.gson)
    //interceptor dependency for logging
    implementation(libs.logging.interceptor)
    //glide dependency
    implementation(libs.glide)
    kapt(libs.compiler)
}