rootProject.name = "TheMovieDatabaseClient"
include(":app")
include(":domain")
include(":features")
include(":network")
include(":features:popular")
include(":features:search")
include(":features:auth")

dependencyResolutionManagement {
    versionCatalogs {
        create("libs") {
            library("core", "androidx.core", "core-ktx").version("1.9.0")
            library("appcompat", "androidx.appcompat", "appcompat").version("1.6.1")
            library("material", "com.google.android.material", "material").version("1.8.0")

            library("tests.junit", "junit", "junit").version("4.13.2")

            library("uiTests-core", "androidx.test.ext", "junit").version("1.1.5")
            library("uiTests-espresso", "androidx.test.espresso", "espresso-core").version("3.5.1")
            bundle("uiTests", listOf("uiTests-core", "uiTests-espresso"))
        }
    }
}