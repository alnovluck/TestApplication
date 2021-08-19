package dependencies

import dependencies.Version.appCompat
import dependencies.Version.constraintLayout
import dependencies.Version.navigation
import dependencies.Version.okhttp

object Dependencies {

    private const val path = "../commonFiles/gradleScript/"
    const val dependency = "./gradleScript/dependencies.gradle"
    const val common = "${path}common.gradle"

    object ClassPaths {
        const val gradleClasspath = "com.android.tools.build:gradle:${Version.gradleVersion}"
        const val kotlinGradlePluginClasspath =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    }

    object Plugins {
        const val ANDROID_APPLICATION = "com.android.application"
        const val ANDROID_LIBRARY = "com.android.library"
        const val GOOGLE_SERVICES = "com.google.gms.google-services"
        const val FIREBASE_PREF = "com.google.firebase.firebase-perf"
        const val KOTLIN_ANDROID = "kotlin-android"
        const val KOTLIN_KAPT = "kotlin-kapt"
        const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
    }

    object Lifecycle {
        const val viewmodel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
        const val extension =
            "androidx.lifecycle:lifecycle-extensions:${Version.lifecycleVersion}"
    }

    object Shimmer {
        const val shimmer = "com.facebook.shimmer:shimmer:${Version.shimmer}"
    }

    object Gson {
        const val gson = "com.google.code.gson:gson:${Version.gson}"
    }

    object Scarlet {
        const val scarlet = "com.tinder.scarlet:scarlet:${Version.scarlet}"
        const val websocket = "com.tinder.scarlet:protocol-websocket-okhttp:${Version.scarlet}"
        const val streamAdapter = "com.tinder.scarlet:stream-adapter-coroutines:${Version.scarlet}"
        const val messageAdapter = "com.tinder.scarlet:message-adapter-gson:${Version.scarlet}"
        const val lifecycle = "com.tinder.scarlet:lifecycle-android:${Version.scarlet}"
    }

    object Kotlin {
        const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib:${Version.kotlin}"
        const val kotlin_script = "org.jetbrains.kotlin:kotlin-script-runtime:${Version.kotlin}"
    }

    object OkHttp3 {
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:${Version.interceptor}"
        const val okHttp3 = "com.squareup.okhttp3:okhttp:${okhttp}"
    }

    object Retrofit2 {
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Version.retrofit}"
        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
    }

    object AndroidX {
        const val fragment = "androidx.fragment:fragment:${Version.androidx}"
        const val core = "androidx.core:core:${Version.androidx}"
        const val constraintlayout =
            "androidx.constraintlayout:constraintlayout:$constraintLayout"
        const val materialDesign = "com.google.android.material:material:${Version.materialDesign}"
        const val recyclerview =
            "androidx.recyclerview:recyclerview:${Version.recyclerView}"
        const val appcompat = "androidx.appcompat:appcompat:${appCompat}"
        const val legacySupport = "androidx.legacy:legacy-support-v4:${Version.legacySupport}"
        const val swipeRefresh =
            "androidx.swiperefreshlayout:swiperefreshlayout:${Version.swipeRefresh}"
    }

    object Navigation {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${navigation}"
    }

    object Coroutine {
        const val coroutine = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.coroutine}"
        const val coroutinesAndroidLibs = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutine}"

    }

    object Koin {
        const val koin = "org.koin:koin-androidx-viewmodel:${Version.koin}"
    }

    object Form {
        const val formValidator = "com.afollestad:vvalidator:${Version.formValidator}"
    }

    object Timber {
        const val timber = "com.jakewharton.timber:timber:${Version.timber}"
    }
}
