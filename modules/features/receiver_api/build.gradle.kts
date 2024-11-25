plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mironchik.multimodule.features.receiver_api"
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int
    }

    compileOptions {
        sourceCompatibility = rootProject.extra["javaCompatibility"] as JavaVersion
        targetCompatibility = rootProject.extra["javaCompatibility"] as JavaVersion
    }
}

dependencies {
    implementation(platform(project(":modules:platform")))

    implementation("androidx.appcompat:appcompat")
}