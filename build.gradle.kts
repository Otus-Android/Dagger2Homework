buildscript {
    repositories {
        mavenCentral()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.5.0")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
    }
}

val namespace by extra { "com.mironchik.multimodule" }
val compileSdkVersion by extra { 34 }
val minSdkVersion by extra { 23 }
val targetSdkVersion by extra { 34 }
val javaCompatibility by extra { JavaVersion.VERSION_17 }

allprojects {
    repositories {
        mavenCentral()
        google()
    }
}
