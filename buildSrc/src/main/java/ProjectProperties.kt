import org.gradle.api.JavaVersion

object ProjectProperties {
    const val AndroidVersion = "7.4.2"
    const val JetbrainsKotlin = "1.7.10"

    const val ApplicationId = "com.example.dus"
    const val CompileSdk = 33
    const val MinSdk = 26
    const val TargetSdk = 33
    const val VersionCode = 1
    const val VersionName = "1.0"
    const val TestRunner = "androidx.test.runner.AndroidJUnitRunner"

    const val ProguardName = "proguard-android-optimize.txt"
    const val ProguardFile = "proguard-rules.pro"

    val JAVA_VERSION = JavaVersion.VERSION_1_8

    const val JvmTarget = "1.8"
    const val ComposeVersion = "1.2.0"

    const val Excludes = "/META-INF/{AL2.0,LGPL2.1}"

    const val projectPath = ":dotori-components"
    const val Path = "path"

    const val GroupId = "com.github.dus"
    const val ArtifactId = "DUS"
}