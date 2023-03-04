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

    implementation(project(":domain"))

    testImplementation(libs.tests.junit)
    androidTestImplementation(libs.bundles.uiTests)
}