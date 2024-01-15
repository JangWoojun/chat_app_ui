package com.woojun.chatappui.util

data class Space(
    val top: Int = 0,
    val left: Int = 0,
    val right: Int = 0,
    val bottom: Int = 0
)

data class Chat(
    val massage: String = "",
    val isUser: Boolean = true,
    val date: String = ""
)