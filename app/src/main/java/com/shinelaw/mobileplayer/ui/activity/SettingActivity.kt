package com.shinelaw.mobileplayer.ui.activity

import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import android.util.Log
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.base.BaseActivity
import com.shinelaw.mobileplayer.util.ToolBarManager
import org.jetbrains.anko.find

class SettingActivity : BaseActivity(),ToolBarManager {

    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_setting
    }

    override fun initData() {
        initSettingToolBar()
        //获取推送通知有没有被选中
        val preferences = PreferenceManager.getDefaultSharedPreferences(this)
        val push = preferences.getBoolean("push", false)
        println("push=$push")
    }
}
