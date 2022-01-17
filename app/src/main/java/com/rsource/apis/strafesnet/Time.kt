package com.rsource.apis.strafesnet

import com.beust.klaxon.Klaxon
import com.rsource.apis.*

object Time {
    fun getTimeFromId(timeId: Int): KTime? {
        val timeEndpoint = Utils.buildUrl("time/${timeId}")
        val time = Utils.getHttpRequest(timeEndpoint)
        return Klaxon().parse<KTime>(time)
    }

    fun getRankFromTimeId(timeId: Int) : Int? {
        val rankEndpoint = Utils.buildUrl("time/${timeId}/rank")
        val rank = Utils.getHttpRequest(rankEndpoint)
        class KRankFromTimeId(val Rank: Int)
        return Klaxon().parse<KRankFromTimeId>(rank)?.Rank
    }

    fun getRecentTimes(date: Int?, style: StyleID?, game: GameID?, map: Int?) : List<KRecentTime>? {
        var args = ""
        if (date != null) {
            args += "?date=${date}"
        }
        if (style != null) {
            if (args.isNotEmpty()) {
                args += "&"
            }
            args += "style=${style}"
        }
        if (game != null) {
            if (args.isNotEmpty()) {
                args += "&"
            }
            args += "game=${game}"
        }
        if (map != null) {
            if (args.isNotEmpty()) {
                args += "&"
            }
            args += "map=${map}"
        }
        val recentTimesEndpoint = Utils.buildUrl("time/recent${args}")
        val recentTimes = Utils.getHttpRequest(recentTimesEndpoint)
        return Klaxon().parseArray(recentTimes)
    }

    fun getRecentWRs(style: Int, game: Int, whitelist: Boolean?): List<KTime>?{
        var args = "?style=${style}&game=${game}"
        if (whitelist != null) {
            args += "&whitelist=${whitelist}"
        }
        val recentWRsEndpoint = Utils.buildUrl("time/recent/wr${args}")
        println(recentWRsEndpoint)
        val recentWRs = Utils.getHttpRequest(recentWRsEndpoint)
        println(recentWRs)
        return Klaxon().parseArray(recentWRs)
    }
}
