package free.ssharyk.themoviedatabaseclient.network.http

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import free.ssharyk.themoviedatabaseclient.network.ApiConstant.BASE_URL
import free.ssharyk.themoviedatabaseclient.network.jsonparser.JSONObjectAdapter
import free.ssharyk.themoviedatabaseclient.network.jsonparser.ResponseParser
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class BaseHttpService<Api> {

    // region Fields and properties

    protected abstract val klazz: Class<Api>

    private val okHttpBuilder: OkHttpBuilder = OkHttpBuilder()

    private val retrofitInstance: Api by lazy { buildRetrofit() }

    private val requestExecutor = NetworkRequestExecutor<Api>()

    // endregion

    // region Builder

    private fun buildRetrofit(): Api {
        val moshi = Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .add(JSONObjectAdapter)
            .build()

        return Retrofit.Builder()
            .client(okHttpBuilder.getOkHttpClient())
            .baseUrl(BASE_URL.toHttpUrl())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(klazz)
    }

    // endregion

    // region Making requests

    protected suspend inline fun <reified T> makeRequest(noinline action: suspend Api.() -> JSONObject) =
        makeRequest(T::class.java, action)
    protected suspend fun <T> makeRequest(klazz: Class<T>, action: suspend Api.() -> JSONObject): Result<T> {
        val json = requestExecutor.makeRequest(retrofitInstance, action)
        val result = ResponseParser.parseResponse<T>(json, klazz)
        return if (result == null) {
            Result.failure(NetworkException("Cannot parse response"))
        } else {
            Result.success(result)
        }
    }

    protected suspend fun makePostRequest(vararg params: Pair<String, Any>, action: suspend Api.(RequestBody) -> JSONObject): JSONObject {
        return requestExecutor.makePostRequest(retrofitInstance, params.toList(), action)
    }

    // endregion

}