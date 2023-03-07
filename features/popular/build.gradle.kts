plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "free.ssharyk.themoviedatabaseclient.features.popular"
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(libs.core)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.bundles.fragmentsUi)
    implementation(libs.coil)

    implementation(libs.coroutines.android)

    implementation(libs.epoxy)
    kapt(libs.epoxy.kapt)

    implementation(libs.bundles.retrofit)

    implementation(libs.hilt.android)
    kapt(libs.hilt.kapt)

    implementation(project(":domain"))
    implementation(project(":data:network"))
    implementation(project(":features"))
    implementation(project(":testing"))

    debugImplementation(libs.bundles.hyperion)

    testImplementation(libs.tests.junit)
    testImplementation(libs.coroutines.test)

    androidTestImplementation(libs.bundles.uiTests)
}