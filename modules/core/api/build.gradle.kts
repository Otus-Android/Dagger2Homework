plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = rootProject.extra["namespace"] as String
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig {
        minSdk = rootProject.extra["minSdkVersion"] as Int
    }

    compileOptions {
        sourceCompatibility = rootProject.extra["javaCompileVersion"] as JavaVersion
        targetCompatibility = rootProject.extra["javaCompileVersion"] as JavaVersion
    }
}

dependencies {
    implementation("javax.inject:javax.inject:1")
}