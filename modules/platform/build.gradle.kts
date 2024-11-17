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
    }
}