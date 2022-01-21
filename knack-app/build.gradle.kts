
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
    implementation(project(":knack-vdom"))
    implementation(project(":knack-html"))
    implementation(project(":knack-effects"))
    testImplementation(kotlin("test-js"))
}

kotlin {
    js {
        browser {
        }
    }
}
