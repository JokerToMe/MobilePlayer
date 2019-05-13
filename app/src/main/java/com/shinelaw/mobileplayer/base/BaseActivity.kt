package com.shinelaw.mobileplayer.base

import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.ui.activity.MainActivity
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * @Package:        com.shinelaw.mobileplayer.base
 * @Description:    java类作用描述
 * @Author:         Shine
 * @CreateDate:     2019/5/13 10:23
 */
abstract class BaseActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initListener()
        initData()
    }
    
     /**
      * @description 获取布局id
      * @date: 2019/5/13 10:27
      * @author: ShineLaw
      * @param 
      * @return 
      */
    abstract fun getLayoutId():Int

     /**
      * @description 初始化数据，加上了open关键字才能被覆写
      * @date: 2019/5/13 10:30
      * @author: ShineLaw
      * @param
      * @return
      */
    open protected fun initData() {

    }

     /**
      * @description adapter listener，加上了open关键字才能被覆写
      * @date: 2019/5/13 10:29
      * @author: ShineLaw
      * @param
      * @return
      */
    open protected fun initListener() {

    }

     /**
      * @description 在子线程中弹Toast，加上了open关键字才能被覆写
      * @date: 2019/5/13 10:33
      * @author: ShineLaw
      * @param
      * @return
      */
    open protected fun myToast(msg:String){
        runOnUiThread { toast(msg) }
    }

     /**
      * @description 开启一个Activity并且finish界面，reified和inline必须配套使用
      * @date: 2019/5/13 14:16
      * @author: ShineLaw
      * @param
      * @return
      */
    inline fun <reified T:BaseActivity>startActivityAndFinish(){
         startActivity<T>()
         finish()
    }
}
