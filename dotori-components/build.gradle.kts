plugins {
    id(Plugins.androidLibrary)
    id(Plugins.kotlinAndroid)
    id(Plugins.kotlinKapt)
    id(Plugins.kotlinParcelize)
}

android {
    namespace = ProjectProperties.ApplicationId
    compileSdk = ProjectProperties.CompileSdk

    defaultConfig {
        minSdk = ProjectProperties.MinSdk
        targetSdk = ProjectProperties.TargetSdk

        testInstrumentationRunner = ProjectProperties.TestRunner
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile(ProjectProperties.ProguardName),
                ProjectProperties.ProguardFile
            )
        }
    }
    compileOptions {
        sourceCompatibility = ProjectProperties.JAVA_VERSION
        targetCompatibility = ProjectProperties.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = ProjectProperties.JvmTarget
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.COMPOSE_VERSION
    }
}

dependencies {
    implementation(AndroidX.CORE_KTX)
    implementation(AndroidX.LIFECYCLE_KTX)
    implementation(Compose.ACTIVITY_COMPOSE)
    implementation(Compose.UI_COMPOSE)
    implementation(Compose.FOUNDATION)

    implementation(Compose.MATERIAL_COMPOSE)

    implementation(AndroidX.APP_COMPAT)
    implementation(Compose.UI_TOOLING_PREVIEW)
    testImplementation(UnitTest.JUNIT)
    androidTestImplementation(AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(AndroidTest.ESPRESSO_CORE)
    androidTestImplementation(Compose.UI_TEST_JUNIT4)
    debugImplementation(Compose.UI_TOOLING)
    debugImplementation(Compose.UI_TEST_MANIFEST)

    // Pager
    implementation(Compose.PAGER_COMPOSE)
    implementation(Compose.PAGER_INDICATORS_COMPOSE)

    // Landscapist-glide
    implementation(Compose.LANDSCAPIST_COMPOSE)
    implementation(Compose.LANDSCAPIST_PLACEHOLDER_COMPOSE)
}