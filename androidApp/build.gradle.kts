plugins {
    id(androidApp)
    kotlin(androidPlugin)
}

android {
    compileSdk = compileSdk
    defaultConfig {
        applicationId = "com.github.ryutaro.kmm_sample.android"
        minSdk = minSdk
        targetSdk = targetSdk
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.3.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.0")

    with(Deps.Coroutine) {
        implementation(coroutineCore)
        implementation(coroutineAndroid)
        testImplementation(coroutineTest)
    }
}