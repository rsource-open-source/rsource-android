package com.rsource.apis.strafesnet

import io.github.cdimascio.dotenv.dotenv
import okhttp3.*


object Utils {
    private val dotenv = dotenv {
        directory = System.getProperty("user.dir")!! + "/assets"
        filename = "env"
    }

    private val API_KEY = dotenv["API_KEY"]
    // private val DB_KEY = dotenv["DB_KEY"]

    private const val SN_API_URL = "https://api.strafes.net/v1/"

    private val client = OkHttpClient()

    fun buildUrl(str: String): String {
        return "$SN_API_URL$str"
    }

    fun getHttpRequest(url: String) : String {

        val request: Request = Request.Builder()
            .url(url)
            .header("api-key", API_KEY)
            .build()

        val response: Response = client.newCall(request).execute()
        return response.body!!.string()
    }
}