package com.shinelaw.mobileplayer.util

import android.support.v7.widget.Toolbar
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.ui.activity.SettingActivity
import org.jetbrains.anko.startActivity

/**
 * @Package:        com.shinelaw.mobileplayer.util
 * @ClassName:      ToolBarManager
 * @Description:    所有界面ToolBar的管理类
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/13 15:42
 */
interface ToolBarManager {

    val toolbar: Toolbar

    /**
     * @description 初始化主界面中的ToolBar
     * @date: 2019/5/13 15:43
     * @author: ShineLaw
     * @param
     * @return
     */
    fun initMainToolBar() {
        toolbar.setTitle("黑马影音")
        toolbar.inflateMenu(R.menu.main)
//        toobar.setOnMenuItemClickListener(object:Toolbar.OnMenuItemClickListener{
//            override fun onMenuItemClick(p0: MenuItem?): Boolean {
//                when(p0?.itemId){
//                    R.id.setting -> {
//                        Toast.makeText(toobar.context,"点击了setting按钮",Toast.LENGTH_SHORT).show()
//                    }
//                }
//                //消费点击事件
//                return true
//            }
//        })
        toolbar.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.setting -> {
                    //跳转到设置界面
                    toolbar.context.startActivity<SettingActivity>()
                }
            }
            true
        }
    }

    /**
     * @description 初始化设置界面中的ToolBar
     * @date: 2019/5/13 15:43
     * @author: ShineLaw
     * @param
     * @return
     */
    fun initSettingToolBar() {
        toolbar.setTitle("设置")
    }

}