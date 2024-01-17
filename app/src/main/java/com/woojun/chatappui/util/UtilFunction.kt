package com.woojun.chatappui.util

import android.content.Context

object UtilFunction {
    fun dpToPx(context: Context, dp: Int): Int {
        return (dp * context.resources.displayMetrics.density).toInt()
    }
}