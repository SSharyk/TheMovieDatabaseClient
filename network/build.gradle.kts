plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    namespace = "free.ssharyk.themoviedatabaseclient.network"
}

dependencies {

    debugImplementation("com.squareup.okhttp3:logging-interceptor:4.10.0")
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")

}