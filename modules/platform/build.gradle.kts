plugins {
    id("java-platform")
}

javaPlatform {
    allowDependencies()
}

dependencies {
    constraints {
        api("com.google.dagger:dagger:2.52")
        api("com.google.dagger:dagger-compiler:2.52")
        api("androidx.appcompat:appcompat:1.7.0")
        api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
        api("androidx.constraintlayout:constraintlayout:2.2.0")
        api("com.google.android.material:material:1.12.0")
    }
}