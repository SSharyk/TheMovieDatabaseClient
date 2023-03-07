plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.google.devtools.ksp")
}

android {
    namespace = "free.ssharyk.themoviedatabaseclient.network"
}

kapt {
    correctErrorTypes = true
}

dependencies {

    compileOnly(libs.retrofit.http.logging)
    debugImplementation(libs.retrofit.http.logging)
    implementation(libs.bundles.retrofit)
    ksp(libs.moshi.codegen)

    implementation(project(":domain"))

    implementation(libs.hilt.android)

    kapt(libs.hilt.kapt)
}