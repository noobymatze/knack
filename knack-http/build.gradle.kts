
plugins {
    kotlin("js") version "1.6.20"
}

group = "io.noobymatze"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js")
    implementation(project(":knack-effects"))
    testImplementation("org.jetbrains.kotlin:kotlin-test-js")
}

kotlin {
    js {
        browser {

        }
    }
}
