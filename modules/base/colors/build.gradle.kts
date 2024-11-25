plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.mironchik.multimodule.base.colors"
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

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core")
    implementation("androidx.appcompat:appcompat")
}