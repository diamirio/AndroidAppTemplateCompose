import org.gradle.api.JavaVersion

enum class JvmVersion(
    version: JavaVersion
) {
    JVM_11(JavaVersion.VERSION_11),
    JVM_17(JavaVersion.VERSION_17);

    val jvmTarget: String = version.majorVersion
    val sourceCompatibility: JavaVersion = version
    val targetCompatibility: JavaVersion = version
}