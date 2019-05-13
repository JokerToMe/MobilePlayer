package com.shinelaw.mobileplayer.ui.activity

import android.support.v4.view.ViewCompat
import android.support.v4.view.ViewPropertyAnimatorListener
import android.view.View
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.base.BaseActivity
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : BaseActivity(), ViewPropertyAnimatorListener {

    override fun onAnimationEnd(p0: View?) {
        startActivityAndFinish<MainActivity>()
    }

    override fun onAnimationCancel(p0: View?) {
    }

    override fun onAnimationStart(p0: View?) {
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_splash
    }

    override fun initData() {
//        由于anko库的使用，此处只需要放入控件的id即可，不需要findviewByid的操作
        ViewCompat.animate(iv).scaleX(1.0f).scaleY(1.0f).setDuration(2000)
//                需要监听动画结束，然后执行跳转到主页面的操作
            .setListener(this)
    }

}
