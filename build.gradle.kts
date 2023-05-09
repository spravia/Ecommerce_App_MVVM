buildscript {
    dependencies {
        classpath("com.android.tools.build:gradle:7.3.1")
    }
}
plugins {
    id("com.android.application").version("8.0.0").apply(false)
    id("com.android.library").version("8.0.0").apply(false)

    id("com.google.dagger.hilt.android").version("2.44").apply(false)

    kotlin("android").version("1.8.10").apply(false)
    kotlin("multiplatform").version("1.8.10").apply(false)
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
