plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jmailen.kotlinter)
    alias(libs.plugins.kotlin.android)
}

android {
    compileSdk = Config.compileSdk
    namespace = Config.namespace

    defaultConfig {
        versionCode = Config.versionCode
        versionName = Config.versionName

        applicationId = Config.applicationId
        setProperty("archivesBaseName", Config.archiveName)

        targetSdk = Config.targetSdk
        minSdk = Config.minSdk
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    signingConfigs {
        create("release") {
            keyAlias = "mykeyalias"
            keyPassword = "mykeypassword"
            storeFile = file("../keystore.jks")
            storePassword = "mykeystorepassword"
        }
    }

    buildTypes {
        getByName("debug") {
            versionNameSuffix = "-DEBUG"
            isMinifyEnabled = false
        }
        getByName("release") {
            signingConfig = signingConfigs.getByName("release")
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    flavorDimensions += "main"
    productFlavors {
        create("dev") {
            applicationIdSuffix = ".dev"
            resValue("string", "app_name", "${Config.appName} Dev")
            resValue("string", "leak_canary_display_activity_label", "${Config.appName} Leaks")
            buildConfigField("String", "BASE_URL", "\"https://jobs.diamir.io/\"")
            dimension = "main"
        }
        create("prod") {
            resValue("string", "app_name", Config.appName)
            buildConfigField("String", "BASE_URL", "\"https://jobs.diamir.io/\"")
            dimension = "main"
        }
    }

    @Suppress("UnstableApiUsage")
    testOptions {
        unitTests {
            isReturnDefaultValues = true
        }
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

    // more infos: https://developer.android.com/guide/app-bundle/configure-base#disable_config_apks
    bundle {
        language {
            @Suppress("UnstableApiUsage")
            enableSplit = false
        }
        density {
            @Suppress("UnstableApiUsage")
            enableSplit = false
        }
        abi {
            @Suppress("UnstableApiUsage")
            enableSplit = true
        }
    }

    compileOptions {
        sourceCompatibility = Config.jvmVersion.sourceCompatibility
        targetCompatibility = Config.jvmVersion.targetCompatibility
    }

    kotlinOptions {
        jvmTarget = Config.jvmVersion.jvmTarget
        freeCompilerArgs += Config.kotlinFreeCompilerArgs
    }

    buildFeatures {
        compose = true
        buildConfig = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }

    lint {
        warningsAsErrors = Config.lintWarningsAsErrors
        abortOnError = Config.lintAbortOnError
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":base-ui"))

    testImplementation(libs.junit)
    testImplementation(libs.koin.test)
    testImplementation(libs.kotlin.test)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mock)

    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    androidTestImplementation(libs.androidx.lifecycle.runtime.testing)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.espresso.contrib)
    androidTestImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.espresso.intents)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.androidx.test.rules)
    androidTestImplementation(libs.androidx.test.runner)
    androidTestImplementation(libs.kotlin.test)
    androidTestImplementation(libs.kotlinx.coroutines.test)
}
