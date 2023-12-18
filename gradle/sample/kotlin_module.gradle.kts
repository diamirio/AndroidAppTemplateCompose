plugins {
    alias(libs.plugins.kotlin.jvm)
    `java-library`
    alias(libs.plugins.jmailen.kotlinter)
}

sourceSets {
    named("main") {
        java {
            srcDirs(Config.mainSourceSet)
        }
    }
    named("test") {
        java {
            srcDirs(Config.testSourceSet)
        }
    }
}

java {
    sourceCompatibility = Config.jvmVersion.sourceCompatibility
    targetCompatibility = Config.jvmVersion.targetCompatibility
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = Config.jvmVersion.jvmTarget
    }
}

dependencies {
    // place your modules here
}