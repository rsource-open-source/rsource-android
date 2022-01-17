package com.example.rsource_android

import com.rsource.apis.KRecentTime
import com.rsource.apis.KTime
import com.rsource.apis.strafesnet.Time
import org.junit.Test


class SNLibraryTest {
    @Test
    fun getTimeFromId_test() {
        val time : KTime? = Time.getTimeFromId(190220)
        assert(time!!.ID == 190220)
        assert(time.Time == 121400)
        assert(time.User == 39619)
        assert(time.Map == 5692152358)
    }
    @Test
    fun getRankFromTimeId_test() {
        val rank : Int? = Time.getRankFromTimeId(190220)
        assert(rank == 2431)
    }
    @Test
    fun getRecentTimes_test() {
        val times : List<KRecentTime>? = Time.getRecentTimes(null,null,null,null)
        assert(times!!.size == 50)
    }
    @Test
    fun getRecentWRs_test() {
        val times : List<KTime>? = Time.getRecentWRs(1, 1, null)
        assert(times!!.size == 10)
    }
}