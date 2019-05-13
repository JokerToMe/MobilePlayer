package com.shinelaw.mobileplayer.ui.activity

import android.support.v7.widget.Toolbar
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.base.BaseActivity
import com.shinelaw.mobileplayer.util.ToolBarManager
import org.jetbrains.anko.find

class MainActivity : BaseActivity(),ToolBarManager{

    //惰性加载：线程安全，且只有在使用的时候才会被初始化
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        initMainToolBar()
    }
}
