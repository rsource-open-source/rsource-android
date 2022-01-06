package com.rsource.apis.strafesnet

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import io.github.cdimascio.dotenv.dotenv

object Utils {
    private val dotenv = dotenv {
        directory = "/assets"
        filename = "env"
    }
    private var API_KEY = dotenv["API_KEY"]
    // private var DB_KEY = dotenv["DB_KEY"]

    var SN_API_URL = "https://api.strafes.net/v1/uashgjkdsf?api-key=$API_KEY"

    private var client = OkHttpClient()

    fun getHttpRequest(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: java.io.IOException) {
                println("Failed to execute request")
                e.printStackTrace()
            }

            override fun onResponse(call: okhttp3.Call, response: Response) {
                println("Response: ${response.body!!.string()}")
            }
        })
    }
}
