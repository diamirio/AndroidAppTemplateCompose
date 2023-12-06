plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.jmailen.kotlinter)
}

android {
    namespace = "${Config.applicationId}.core"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
    }

    sourceSets {
        named("main") { java { srcDirs(Config.mainSourceSet) } }
        named("test") { java { srcDirs(Config.testSourceSet) } }
        named("androidTest") { java { srcDirs(Config.androidTestSourceSet) } }
    }

    compileOptions {
        sourceCompatibility = Config.jvmVersion.sourceCompatibility
        targetCompatibility = Config.jvmVersion.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Config.jvmVersion.jvmTarget
        freeCompilerArgs += Config.kotlinFreeCompilerArgs
    }

    lint {
        warningsAsErrors = Config.lintWarningsAsErrors
        abortOnError = Config.lintAbortOnError
    }
}

dependencies {
    // place your dependencies here
}