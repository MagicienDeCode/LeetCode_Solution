import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "8.1.0"
    kotlin("jvm") version "1.3.70"
}

group = "fr.magiciendecode"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.4.2"
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.openjfx:javafx-base:11:linux")
    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-params:$junitVersion")

    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
        events = mutableSetOf(TestLogEvent.FAILED, TestLogEvent.SKIPPED)
        showStandardStreams = true
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}
