package com.shinelaw.mobileplayer.ui.fragment

import android.support.v4.app.Fragment
import android.view.View
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.base.BaseFragment

 /**
  * @description 悦单
  * @date: 2019/5/16 15:29
  * @author: ShineLaw
  * @param
  * @return
  */
class YuedanFragment : BaseFragment() {

    override fun initView(): View? {
        return layoutInflater.inflate(R.layout.fragment_yuedan, null)
    }

}
