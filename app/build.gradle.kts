plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    compileSdk = rootProject.extra["compileSdkVersion"] as Int

    defaultConfig {
        applicationId = "com.mironchik.multimodule"
        minSdk = rootProject.extra["minSdkVersion"] as Int
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = rootProject.extra["javaCompatibility"] as JavaVersion
        targetCompatibility = rootProject.extra["javaCompatibility"] as JavaVersion
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    namespace = "com.mironchik.multimodule"
}

dependencies {
    implementation(project(":modules:core:api_factory"))
    implementation(project(":modules:features:producer_impl"))
    implementation(project(":modules:features:receiver_impl"))
    implementation(project(":modules:features:screen"))

    implementation(platform(project(":modules:platform")))
    implementation("com.google.dagger:dagger")
    kapt("com.google.dagger:dagger-compiler:2.52")
}