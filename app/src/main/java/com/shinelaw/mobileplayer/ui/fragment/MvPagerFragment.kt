package com.shinelaw.mobileplayer.ui.fragment

import android.view.Gravity
import android.view.View
import android.widget.TextView
import com.shinelaw.mobileplayer.base.BaseFragment

/**
 * @Package:        com.shinelaw.mobileplayer.ui.fragment
 * @ClassName:      MvPagerFragment
 * @Description:    java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/30 15:20
 */
class MvPagerFragment:BaseFragment() {

    override fun initView(): View? {
        val tv:TextView = TextView(context)
        tv.gravity = Gravity.CENTER
        tv.text = arguments?.getString("title") ?: ""
        return tv
    }

}