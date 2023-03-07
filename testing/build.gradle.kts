plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "free.ssharyk.themoviedatabaseclient.testing"
}

dependencies {
    implementation(libs.coroutines.android)

    implementation(libs.tests.junit)
    implementation(libs.coroutines.test)
}