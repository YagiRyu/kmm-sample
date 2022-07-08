plugins {
    kotlin(multiplatform)
    kotlin(cocoapods)
    kotlin(serializationPlugin) version Version.kotlin
    id(sqldelightPlugin)
    id(androidLib)
}

version = "1.0"

kotlin {
    android()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "14.1"
        podfile = project.file("../iosApp/Podfile")
        framework {
            baseName = "shared"
        }
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                with(Deps.Ktor) {
                    implementation(ktorCore)
                    implementation(ktorSerialization)
                    implementation(ktorLogging)
                    implementation(ktorContentNegotiation)
                }
                with(Deps.Koin) {
                    implementation(koinCore)
                    implementation(koinTest)
                }
                implementation(Deps.serialization)
                implementation(Deps.napier)
                implementation(Deps.kotlinCommon)
                implementation(Deps.Coroutine.coroutineCore)
                implementation(Deps.Sqldelight.sqldelightRuntime)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.Ktor.ktorAndroid)
                implementation(Deps.Ktor.ktorOkHttp)
                implementation(Deps.Coroutine.coroutineAndroid)
                implementation(Deps.Sqldelight.sqldelightAndroid)
            }
        }
        val androidTest by getting
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)
            dependencies {
                implementation(Deps.Ktor.ktorIos)
                implementation(Deps.Sqldelight.sqldelightNative)
            }
        }
        val iosX64Test by getting
        val iosArm64Test by getting
        val iosSimulatorArm64Test by getting
        val iosTest by creating {
            dependsOn(commonTest)
            iosX64Test.dependsOn(this)
            iosArm64Test.dependsOn(this)
            iosSimulatorArm64Test.dependsOn(this)
        }
    }
}

android {
    compileSdk = Version.compileSdk
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = Version.minSdk
        targetSdk = Version.targetSdk
    }
}
dependencies {
    testImplementation("junit:junit:4.12")
}

sqldelight {
    database("AppDatabase") {
        packageName = "com.github.ryutaro.kmm_sample.shared.cache"
    }
}
