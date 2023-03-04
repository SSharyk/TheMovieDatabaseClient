plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "free.ssharyk.themoviedatabaseclient.features.popular"
}

dependencies {
    implementation(libs.core)
    implementation(libs.appcompat)
    implementation(libs.material)

    testImplementation(libs.tests.junit)
    androidTestImplementation(libs.bundles.uiTests)
}