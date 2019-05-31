package com.shinelaw.mobileplayer.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

/**
 * @Package:        com.shinelaw.mobileplayer.adapter
 * @ClassName:      MvPagerAdapter
 * @Description:    java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/30 15:14
 */
class MvPagerAdapter(val fm:FragmentManager,val list:List<Int>): FragmentPagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getCount(): Int {
        return list.size
    }
}