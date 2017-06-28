package com.example.hen.sichon.decorators

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by slava-android on 6/28/2017.
 * Falcore Ltd.
 */
class LanguageItemDecorator(spanCount: Int) : RecyclerView.ItemDecoration() {

    val mSpanCount = spanCount
    val PADDING = 20

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)

        val itemPosition = parent?.getChildLayoutPosition(view) as Int

        outRect?.bottom = 0
        outRect?.top = PADDING
        outRect?.right = PADDING
        outRect?.left = if (itemPosition % mSpanCount == 0) PADDING else 0
    }
}