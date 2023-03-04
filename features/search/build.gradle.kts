plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "free.ssharyk.themoviedatabaseclient.features.search"
}

dependencies {
    implementation(libs.core)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.bundles.fragmentsUi)

    implementation(project(":features"))

    testImplementation(libs.tests.junit)
    androidTestImplementation(libs.bundles.uiTests)
}