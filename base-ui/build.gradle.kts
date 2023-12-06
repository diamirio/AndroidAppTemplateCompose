plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jmailen.kotlinter)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "${Config.applicationId}.base"
    compileSdk = Config.compileSdk

    defaultConfig {
        minSdk = Config.minSdk
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
        named("androidTest") {
            java {
                srcDirs(Config.androidTestSourceSet)
            }
        }
    }

    compileOptions {
        sourceCompatibility = Config.jvmVersion.sourceCompatibility
        targetCompatibility = Config.jvmVersion.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Config.jvmVersion.jvmTarget
        // Some Flow / Coroutine APIs we use are experimental and therefore would flood the build
        // log with warnings. Disabling those warnings here.
        freeCompilerArgs += Config.kotlinFreeCompilerArgs
    }

    lint {
        warningsAsErrors = Config.lintWarningsAsErrors
        abortOnError = Config.lintAbortOnError
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}

dependencies {
    api(libs.androidx.activity.compose)
    api(libs.androidx.activity.ktx)
    api(libs.androidx.compose.animation.core)
    api(libs.androidx.compose.ui.core)
    debugApi(libs.androidx.compose.ui.tooling.core)
    api(libs.androidx.compose.ui.tooling.preview)
    api(libs.androidx.compose.material.icons)
    api(libs.androidx.compose.material3.core)
    api(libs.androidx.compose.material3.window)
    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.runtime.compose)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.lifecycle.viewmodel.compose)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.navigation.compose)
    api(libs.coil.compose)
    api(libs.floschu.control.core)
    api(libs.google.material.core)
    api(libs.koin.android)
    api(libs.koin.androidx.compose)
    debugApi(libs.square.leakcanary.android)
    releaseApi(libs.square.leakcanary.objectwatcher)
    lintChecks(libs.slack.lint.compose)
}
