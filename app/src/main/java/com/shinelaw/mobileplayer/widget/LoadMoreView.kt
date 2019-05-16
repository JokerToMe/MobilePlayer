package com.shinelaw.mobileplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.shinelaw.mobileplayer.R

/**
 * @Package:        com.shinelaw.mobileplayer.widget
 * @ClassName:      LoadMoreView
 * @Description:    下拉加载更多自定义View
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/16 10:03
 */
class LoadMoreView:RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.view_loadmore,this)
    }
}