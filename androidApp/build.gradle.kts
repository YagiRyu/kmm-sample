plugins {
    id(androidApp)
    kotlin(androidPlugin)
}

android {
    compileSdk = Version.compileSdk
    defaultConfig {
        applicationId = "com.github.ryutaro.kmm_sample.android"
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.appcompat:appcompat:1.4.2")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    with(Deps.Coroutine) {
        implementation(coroutineCore)
        implementation(coroutineAndroid)
        testImplementation(coroutineTest)
    }

    with(Deps.Koin) {
        implementation(koinCore)
        implementation(koinAndroid)
    }

    implementation(Deps.napier)

}