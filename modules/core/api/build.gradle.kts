plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {
    namespace = "com.mironchik.multimotule.core.api"
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
    implementation("javax.inject:javax.inject:1")
}