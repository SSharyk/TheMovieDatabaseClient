package free.ssharyk.themoviedatabaseclient.network.jsonparser

import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import free.ssharyk.themoviedatabaseclient.network.BuildConfig
import org.json.JSONObject

object ResponseParser {

    private const val INTERNET_CONNECTION_ERROR = "INTERNET_CONNECTION_ERROR"

    val connectionErrorJson = JSONObject().apply {
        put("error", true)
        put("id", "ERRR_404")
        put("message", INTERNET_CONNECTION_ERROR)
    }


    inline fun <reified T> parseResponse(json: JSONObject): T? {
        val moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<T> = moshi.adapter(T::class.java)
        return try {
            jsonAdapter.fromJson(json.toString())
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                Log.e("JSON_PARSE", "parse for ${T::class.java}", e)
            }
            null
        }
    }

    fun isEmpty(json: JSONObject): Boolean {
        return !json.keys().hasNext()
    }

}