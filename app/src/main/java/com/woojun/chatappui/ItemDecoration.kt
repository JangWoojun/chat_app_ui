package com.woojun.chatappui

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class ItemDecoration(private val space: Space) : RecyclerView.ItemDecoration() {
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.top = space.top
        outRect.left = space.left
        outRect.right = space.right
        outRect.bottom = space.bottom
    }

}