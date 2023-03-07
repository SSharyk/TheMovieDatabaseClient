package free.ssharyk.themoviedatabaseclient.network.http

import free.ssharyk.themoviedatabaseclient.network.jsonparser.ResponseParser
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject

class NetworkRequestExecutor<Api> {

    suspend fun makeRequest(api: Api, action: suspend Api.() -> JSONObject): JSONObject {
        return try {
            api.action()
        } catch (e: Exception) {
            processException(e)
            return ResponseParser.connectionErrorJson
        }
    }

    suspend fun makePostRequest(
        api: Api,
        params: List<Pair<String, Any>>,
        action: suspend Api.(RequestBody) -> JSONObject
    ): JSONObject {
        val jsonObject = JSONObject()
        for ((k, v) in params) {
            jsonObject.put(k, v)
        }

        val requestBody = jsonObject.toString().toRequestBody("application/json".toMediaTypeOrNull())

        return try {
            api.action(requestBody)
        } catch (e: Exception) {
            processException(e)
            ResponseParser.connectionErrorJson
        }
    }

    private fun processException(e: Exception): Nothing? {
        e.printStackTrace()
        return null
    }

}