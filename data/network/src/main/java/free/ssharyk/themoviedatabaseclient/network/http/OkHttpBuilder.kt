package free.ssharyk.themoviedatabaseclient.network.http

import free.ssharyk.themoviedatabaseclient.network.BuildConfig
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

/**
 * Класс, который порождает [OkHttpClient] в соответствии с принятым контрактом на передачу данных
 * между клиентом и сервером
 */
internal class OkHttpBuilder {

    companion object {
        private const val API_KEY = "02b113b496621e5a49428c55c55a3ccc"
    }

    fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            addInterceptor { chain ->
                val request = chain.request()

                val urlString = request.url.toString()
                    .replace("%26", "&")
                    .replace("%3D", "=")
                val url = urlString.toHttpUrl().newBuilder()
                url.addQueryParameter("api_key", API_KEY)

                val finalizedRequest = request.newBuilder().url(url.build()).build()
                chain.proceed(finalizedRequest)
            }

            if (BuildConfig.DEBUG) {
                addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            }
        }.build()
    }

}