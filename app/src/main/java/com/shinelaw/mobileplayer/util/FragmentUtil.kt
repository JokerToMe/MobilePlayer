package com.shinelaw.mobileplayer.util

import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.base.BaseFragment
import com.shinelaw.mobileplayer.ui.fragment.HomeFragment
import com.shinelaw.mobileplayer.ui.fragment.MvFragment
import com.shinelaw.mobileplayer.ui.fragment.VbangFragment
import com.shinelaw.mobileplayer.ui.fragment.YuedanFragment

/**
 * @Package:        com.shinelaw.mobileplayer.util
 * @ClassName:      FragmentUtil
 * @Description:    管理fragment的Util类
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/14 10:34
 */
class FragmentUtil private constructor() { //私有化构造方法

    val homeFragment by lazy { HomeFragment() }
    val mvFragment by lazy { MvFragment() }
    val vbangFragment by lazy { VbangFragment() }
    val yuedanFragment by lazy { YuedanFragment() }

    //相当于java的static关键字
    companion object {
        val fragmentUtil by lazy { FragmentUtil() }
    }

    /**
     * @description 根据tabId获取对应的fragment
     * @date: 2019/5/14 10:40
     * @author: ShineLaw
     * @param
     * @return
     */
    fun getFragment(tabId: Int): BaseFragment? {
        when (tabId) {
            R.id.tab_home -> return homeFragment
            R.id.tab_mv -> return mvFragment
            R.id.tab_vbang -> return vbangFragment
            R.id.tab_yuedan -> return yuedanFragment
        }
        return null
    }
}