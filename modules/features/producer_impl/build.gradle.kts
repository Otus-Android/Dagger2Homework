plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.mironchik.multimodule.features.producer_impl"
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
    api(project(":modules:core:api"))
    api(project(":modules:base:colors"))
    api(project(":modules:features:producer_api"))

    implementation(platform(project(":modules:platform")))
    implementation("com.google.dagger:dagger")
    kapt("com.google.dagger:dagger-compiler:2.52")
    implementation("androidx.appcompat:appcompat")
    implementation("androidx.constraintlayout:constraintlayout")
}