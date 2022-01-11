package com.rsource.apis

enum class StyleID {
    AUTOHOP, SCROLL, SIDEWAYS, HALF_SIDEWAYS, W_ONLY, A_ONLY, BACKWARDS
}

interface Time {
    val id  : Int
    val time: Int
    val user: Int
    val map : Int
    val Date: Int
    val Style: StyleID

}