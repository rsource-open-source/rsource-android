package com.rsource.apis.strafesnet

import com.rsource.apis.strafesnet.Utils

class Time {
    val x = Utils.getHttpRequest("https://strafes.net/api/v1/time")
}