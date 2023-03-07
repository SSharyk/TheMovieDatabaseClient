package free.ssharyk.themoviedatabaseclient.network.jsonparser

import android.util.Log
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import free.ssharyk.themoviedatabaseclient.network.BuildConfig
import org.json.JSONObject
import java.lang.reflect.Type

object ResponseParser {

    private const val INTERNET_CONNECTION_ERROR = "INTERNET_CONNECTION_ERROR"

    val connectionErrorJson = JSONObject().apply {
        put("error", true)
        put("id", "ERRR_404")
        put("message", INTERNET_CONNECTION_ERROR)
    }


    fun <T> parseResponse(json: JSONObject, klazz: Class<T>): T? {
        val moshi = Moshi.Builder().build()
        val jsonAdapter = moshi.adapter(klazz)
        return try {
            jsonAdapter?.fromJson(json.toString())
        } catch (e: Exception) {
            if (BuildConfig.DEBUG) {
                Log.e("JSON_PARSE", "parse for $klazz", e)
            }
            null
        }
    }

    fun isEmpty(json: JSONObject): Boolean {
        return !json.keys().hasNext()
    }

}