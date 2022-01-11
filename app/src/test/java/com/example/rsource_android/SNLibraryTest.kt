package com.example.rsource_android

import com.rsource.apis.strafesnet.Utils
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SNLibraryTest {
    @Test
    fun getHttpRequest_body_response_test() {
        Utils.getHttpRequest(Utils.SN_API_URL + "user/27676" + Utils.SN_API_KEY)
    }
}