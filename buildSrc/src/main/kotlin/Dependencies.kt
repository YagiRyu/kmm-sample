const val androidPlugin = "android"
const val androidApp = "com.android.application"
const val androidKotlin = "org.jetbrains.kotlin.android"
const val androidLib = "com.android.library"
const val multiplatform = "multiplatform"
const val composePlugin = "org.jetbrains.compose"
const val cocoapods = "native.cocoapods"
const val serializationPlugin = "plugin.serialization"
const val sqldelightPlugin = "com.squareup.sqldelight"

object Version {
    const val minSdk = 21
    const val targetSdk = 32
    const val compileSdk = 32

    const val kotlin = "1.7.0"
    const val kotlin_gradle_plugin = "1.7.0"
    const val android_gradle_plugin = "7.2.1"

    const val coroutine = "1.6.2-native-mt"
    const val napier = "2.6.1"
    const val junit5 = "1.5.10"
    const val frameworkName = "shared"
    const val ktor = "2.0.3"
    const val koin = "3.2.0"
    const val compose = "1.2.0"
    const val serialization = "1.3.3"
    const val sqldelight = "1.5.3"
}

object Deps {
    const val android_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin_gradle_plugin}"
    const val android_build_gradle_plugin = "com.android.tools.build:gradle:${Version.android_gradle_plugin}"
    const val sqldelight_plugin = "com.squareup.sqldelight:gradle-plugin:${Version.sqldelight}"

    const val napier = "io.github.aakira:napier:${Version.napier}"

    const val serialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:${Version.serialization}"

    const val kotlinCommon = "org.jetbrains.kotlin:kotlin-stdlib-common:${Version.kotlin}"

    object Coroutine {
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
        const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
        const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutine}"
    }

    object Ktor {
        const val ktorCore = "io.ktor:ktor-client-core:${Version.ktor}"
        const val ktorJson = "io.ktor:ktor-client-json:${Version.ktor}"
        const val ktorSerialization = "io.ktor:ktor-serialization-kotlinx-json:${Version.ktor}"
        const val ktorContentNegotiation = "io.ktor:ktor-client-content-negotiation:${Version.ktor}"
        const val ktorAndroid = "io.ktor:ktor-client-android:${Version.ktor}"
        const val ktorIos = "io.ktor:ktor-client-darwin:${Version.ktor}"
        const val ktorLogging = "io.ktor:ktor-client-logging:${Version.ktor}"
        const val ktorOkHttp = "io.ktor:ktor-client-okhttp:${Version.ktor}"
    }

    object Koin {
        const val koinCore = "io.insert-koin:koin-core:${Version.koin}"
        const val koinTest = "io.insert-koin:koin-test:${Version.koin}"
        const val koinAndroid = "io.insert-koin:koin-android:${Version.koin}"
    }

    object Sqldelight {
        const val sqldelightAndroid = "com.squareup.sqldelight:android-driver:${Version.sqldelight}"
        const val sqldelightNative = "com.squareup.sqldelight:native-driver:${Version.sqldelight}"
        const val sqldelightRuntime = "com.squareup.sqldelight:runtime:${Version.sqldelight}"
    }
}
