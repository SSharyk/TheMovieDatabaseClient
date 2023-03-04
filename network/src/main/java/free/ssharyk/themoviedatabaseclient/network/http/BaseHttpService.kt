package free.ssharyk.themoviedatabaseclient.network.http

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import free.ssharyk.themoviedatabaseclient.network.jsonparser.JSONObjectAdapter
import okhttp3.HttpUrl.Companion.toHttpUrl
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

abstract class BaseHttpService<Api> {

    companion object {
        private const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    // region Fields and properties

    protected abstract val klazz: Class<Api>

    private val okHttpBuilder: OkHttpBuilder = OkHttpBuilder()

    @Volatile
    private var retrofitInstance: Api = buildRetrofit()

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

    protected suspend fun makeRequest(action: suspend Api.() -> JSONObject): JSONObject =
        requestExecutor.makeRequest(retrofitInstance, action)

    protected suspend fun makePostRequest(vararg params: Pair<String, Any>, action: suspend Api.(RequestBody) -> JSONObject): JSONObject {
        return requestExecutor.makePostRequest(retrofitInstance, params.toList(), action)
    }

    // endregion

}