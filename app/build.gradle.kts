plugins {
    id("com.android.application")
    kotlin("android")
}

android {
    namespace = "free.ssharyk.themoviedatabaseclient"

    defaultConfig {
        applicationId = "free.ssharyk.themoviedatabaseclient"
    }
}

dependencies {

    implementation(libs.core)
    implementation(libs.appcompat)
    implementation(libs.material)

    implementation(libs.bundles.navigation)

    implementation(project(":domain"))
    implementation(project(":features:popular"))
    implementation(project(":features:search"))
    implementation(project(":features:profile"))

    testImplementation(libs.tests.junit)
    androidTestImplementation(libs.bundles.uiTests)
}