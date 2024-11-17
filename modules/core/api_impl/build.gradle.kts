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
    implementation("com.google.dagger:dagger")
    kapt("com.google.dagger:dagger-compiler:2.52")
    implementation("javax.inject:javax.inject:1")
}