package com.shinelaw.mobileplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.shinelaw.mobileplayer.R

/**
 * @Package:        com.shinelaw.mobileplayer.widget
 * @ClassName:      HomeItemView
 * @Description:     java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/14 14:04
 */
class HomeItemView : RelativeLayout {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    /**
     * @description 初始化方法，调用构造方法的时候会执行
     * @date: 2019/5/14 14:09
     * @author: ShineLaw
     * @param
     * @return
     */
    init {
        //传入了this，不用再调addView去添加
        View.inflate(context, R.layout.item_home, this)
    }
}