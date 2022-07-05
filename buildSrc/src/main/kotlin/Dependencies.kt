const val androidPlugin = "android"
const val androidApp = "com.android.application"
const val androidLib = "com.android.library"
const val multiplatform = "multiplatform"
const val composePlugin = "org.jetbrains.compose"
const val cocoapods = "native.cocoapods"

object Version {
    const val min_sdk = 21
    const val target_sdk = 32
    const val compiler_sdk = 32

    const val kotlin = "1.7.0"
    const val kotlin_gradle_plugin = "1.7.0"
    const val android_gradle_plugin = "7.2.1"
    const val compose_compiler_version = "1.2.0"
    const val compose_version = "1.2.0"

    const val coroutine = "1.6.10"
    const val napier = "2.6.1"
    const val junit5 = "1.5.10"
    const val frameworkName = "shared"
    const val ktor = "2.0.3"
}

object Deps {
    const val android_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin_gradle_plugin}"
    const val android_build_gradle_plugin = "com.android.tools.build:gradle:${Version.android_gradle_plugin}"

    const val napier = "io.github.aakira:napier:${Version.napier}"

    object Coroutine {
        const val coroutineCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
        const val coroutineAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"
        const val coroutineTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Version.coroutine}"
    }

    object Ktor {
        const val ktorCore = "io.ktor:ktor-client-core:${Version.ktor}"
        const val ktorOkhttp = "io.ktor:ktor-client-okhttp:${Version.ktor}"
        const val ktorDarwin = "io.ktor:ktor-client-darwin:${Version.ktor}"
    }
}
