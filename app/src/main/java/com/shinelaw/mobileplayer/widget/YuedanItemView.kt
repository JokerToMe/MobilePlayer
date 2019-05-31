package com.shinelaw.mobileplayer.widget

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import com.bumptech.glide.Glide
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.model.HomeItemBean
import kotlinx.android.synthetic.main.item_home.view.*

/**
 * @Package:        com.shinelaw.mobileplayer.widget
 * @ClassName:      YuedanItemview
 * @Description:    悦单界面条目自定义View
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/31 10:25
 */
class YuedanItemView:RelativeLayout {

    /**
     * @description 刷新每一条View
     * @date: 2019/5/15 16:44
     * @author: ShineLaw
     * @param
     * @return
     */
    fun setData(data: HomeItemBean) {
        //歌手
        song.setText(data.artists[0].artistName)
        //简介
        desc.setText(data.title)
        //图片
        Glide
            .with(context)
            .load("http:"+data.image)
            .centerCrop()
            .placeholder(R.mipmap.placeholder)
            .into(bg);
    }

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        View.inflate(context, R.layout.item_yuedan,this)
    }
}