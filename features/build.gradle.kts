plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "free.ssharyk.themoviedatabaseclient.features"
}

dependencies {
    implementation(libs.core)
    implementation(libs.appcompat)
    implementation(libs.material)

    implementation(libs.lifecycle.runtime)

    testImplementation(libs.tests.junit)
    androidTestImplementation(libs.bundles.uiTests)
}