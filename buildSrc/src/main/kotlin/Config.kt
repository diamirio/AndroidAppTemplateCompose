import org.gradle.api.JavaVersion

object Config {

    @JvmStatic
    val minSdk = 23

    @JvmStatic
    val compileSdk = 33

    @JvmStatic
    val targetSdk = 33

    @JvmStatic
    val versionCode = 1

    @JvmStatic
    val versionName = "0.0.1"

    @JvmStatic
    val appName = "AndroidAppTemplate"

    @JvmStatic
    val applicationId = "com.tailoredapps.androidapptemplate"

    @JvmStatic
    val archiveName = "$appName-v$versionName-b$versionCode"

    @JvmStatic
    val javaVersion = JavaVersion.VERSION_11

    @JvmStatic
    val kotlinFreeCompilerArgs = listOf(
        "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
        "-opt-in=kotlinx.coroutines.DelicateCoroutinesApi",
        "-opt-in=kotlinx.coroutines.FlowPreview",
        "-opt-in=kotlinx.serialization.ExperimentalSerializationApi",
        "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
        "-opt-in=androidx.compose.ui.ExperimentalComposeUiApi"
    )
}
