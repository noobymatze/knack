plugins {
    kotlin("js") version "1.6.10"
}

group = "io.noobymatze"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js")
    testImplementation(kotlin("test-js"))
}

kotlin {
    js {
        browser()
    }
}
