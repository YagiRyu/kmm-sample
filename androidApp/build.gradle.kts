plugins {
    id(androidApp)
    id(androidKotlin)
    kotlin("kapt")
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
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.core:core-ktx:1.8.0")
    implementation("androidx.recyclerview:recyclerview:1.2.1")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation("androidx.cardview:cardview:1.0.0")

    implementation("androidx.lifecycle:lifecycle-extensions:2.2.0")
    implementation("androidx.fragment:fragment-ktx:1.5.0")

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
