rootProject.name = "TheMovieDatabaseClient"
include(":app")
include(":domain")
include(":data", ":data:network")
include(":features", ":features:popular", ":features:search", ":features:profile")
include(":testing")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("core", "androidx.core", "core-ktx").version("1.9.0")
            library("appcompat", "androidx.appcompat", "appcompat").version("1.6.1")
            library("material", "com.google.android.material", "material").version("1.8.0")

            library("fragment", "androidx.fragment", "fragment-ktx").version("1.5.5")
            bundle("fragmentsUi", listOf("fragment"))

            library("coil", "io.coil-kt:coil:2.2.2")

            version("epoxy", "4.6.2")
            library("epoxy", "com.airbnb.android", "epoxy").versionRef("epoxy")
            library("epoxy-kapt", "com.airbnb.android", "epoxy-processor").versionRef("epoxy")

            version("lifecycle", "2.5.1")
            library("lifecycle-livedata", "androidx.lifecycle", "lifecycle-livedata-ktx").versionRef("lifecycle")
            library("lifecycle-runtime", "androidx.lifecycle", "lifecycle-runtime-ktx").versionRef("lifecycle")

            version("navigation", "2.5.3")
            library("navigation-fragment", "androidx.navigation", "navigation-fragment-ktx").versionRef("navigation")
            library("navigation-ui", "androidx.navigation", "navigation-ui-ktx").versionRef("navigation")
            bundle("navigation", listOf("navigation-fragment", "navigation-ui"))

            version("coroutines", "1.6.4")
            library("coroutines-android", "org.jetbrains.kotlinx", "kotlinx-coroutines-android").versionRef("coroutines")
            library("coroutines-test", "org.jetbrains.kotlinx", "kotlinx-coroutines-test").versionRef("coroutines")

            version("hilt", "2.44.2")
            library("hilt-android",  "com.google.dagger", "hilt-android").versionRef("hilt")
            library("hilt-kapt",  "com.google.dagger", "hilt-android-compiler").versionRef("hilt")

            version("retrofit", "2.9.0")
            library("retrofit", "com.squareup.retrofit2", "retrofit").versionRef("retrofit")
            library("retrofit-serialization", "com.squareup.retrofit2", "converter-moshi").versionRef("retrofit")
            library("retrofit-http-logging", "com.squareup.okhttp3:logging-interceptor:4.10.0")
            version("moshi", "1.14.0")
            library("moshi", "com.squareup.moshi", "moshi").versionRef("moshi")
            library("moshi-kt", "com.squareup.moshi", "moshi-kotlin").versionRef("moshi")
            library("moshi-codegen", "com.squareup.moshi", "moshi-kotlin-codegen").versionRef("moshi")
            bundle("retrofit", listOf("retrofit", "retrofit-serialization", "moshi", "moshi-kt"))

            version("hyperion", "0.9.34")
            library("hyperion-core", "com.willowtreeapps.hyperion", "hyperion-core").versionRef("hyperion")
            library("hyperion-attr", "com.willowtreeapps.hyperion", "hyperion-attr").versionRef("hyperion")
            library("hyperion-crash", "com.willowtreeapps.hyperion", "hyperion-crash").versionRef("hyperion")
            bundle("hyperion", listOf("hyperion-core", "hyperion-attr", "hyperion-crash"))

            library("tests.junit", "junit", "junit").version("4.13.2")

            library("uiTests-core", "androidx.test.ext", "junit").version("1.1.5")
            library("uiTests-espresso", "androidx.test.espresso", "espresso-core").version("3.5.1")
            bundle("uiTests", listOf("uiTests-core", "uiTests-espresso"))
        }
    }
}