package com.rsource.apis

import java.util.*

enum class StyleID {
    EMPTY, AUTOHOP, SCROLL, SIDEWAYS, HALF_SIDEWAYS, W_ONLY, A_ONLY, BACKWARDS
}

enum class GameID {
    EMPTY, BHOP, SURF
}

enum class UserState {
    NORMAL, WHITELISTED, BLACKLISTED, PENDING
}

//todo: match case (capitalize first letter)

interface User {
    val id: Int
    val username: String
    val state : UserState
}

interface Time {
    val id   : Int
    val time : Int
    val user : Int
    val map  : Int
    val date : Int
    val style: StyleID
    val mode : Int
    val game : GameID
}

interface Rank {
    val id   : Int
    val user : Int
    val style : StyleID
    val mode : Int
    val game : GameID
    val rank : Int
    val skill : Double
}

interface Map {
    val id : Int
    val name : String
    val creator : String
    val game : GameID
    val date : Date
    val play_count : Int
}

//Classes
class KTime (val ID: Int, val Time: Int, val User: Int , val Map: Long, val Date: Int, val Style: Int, val Mode: Int, val Game: Int)
class KRecentTime (val ID: Int, val Time: Int, val User: Long , val Map: Long, val Date: Long, val Style: Int, val Mode: Int, val Game: Int)
class KUser (val id : Int, val username : String, val state : UserState)
class KRank (val id : Int, val user : Int, val style : StyleID, val mode : Int, val game : GameID, val rank : Int, val skill : Double)
class KMap (val id : Int, val name : String, val creator : String, val game : GameID, val date : Date, val play_count : Int)
