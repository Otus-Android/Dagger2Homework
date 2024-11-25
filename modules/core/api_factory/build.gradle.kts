plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.mironchik.multimodule.core.api_factory"
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
    implementation(project(":modules:core:api_impl"))
}