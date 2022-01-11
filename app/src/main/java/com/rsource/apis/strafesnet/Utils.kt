package com.rsource.apis.strafesnet

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.Callback
import okhttp3.Call
import io.github.cdimascio.dotenv.dotenv
import java.io.IOException

object Utils {
    private val dotenv = dotenv {
        directory = System.getProperty("user.dir") + "/assets"
        filename = "env"
    }

    private val API_KEY = dotenv["API_KEY"]
    // private val DB_KEY = dotenv["DB_KEY"]

    var SN_API_URL = "https://api.strafes.net/v1/uashgjkdsf?api-key=$API_KEY"

    private var client = OkHttpClient()

    fun getHttpRequest(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                println('a')
                response.use {
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                    println("Response: ${response.body?.string()}")
                    println(response.body!!.string())
                }
            }
        })
    }
}

// anti here
// insyri here
// ur mom here