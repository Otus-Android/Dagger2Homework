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

    compileOptions {
        sourceCompatibility = rootProject.extra["javaCompileVersion"] as JavaVersion
        targetCompatibility = rootProject.extra["javaCompileVersion"] as JavaVersion
    }
}

dependencies {
    implementation(platform(project(":modules:platform")))
    implementation(project(":modules:core:api"))
    implementation(project(":modules:core:api_impl"))
}