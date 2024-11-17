plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = rootProject.extra["namespace"] as String
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int
    }
}

dependencies {
    implementation(platform(project(":modules:platform")))

    implementation("com.google.dagger:dagger")
    kapt("com.google.dagger:dagger-compiler")
}