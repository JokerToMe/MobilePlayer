package com.shinelaw.mobileplayer.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.shinelaw.mobileplayer.base.BaseFragment

/**
 * @Package:        com.shinelaw.mobileplayer.adapter
 * @ClassName:      MvPagerAdapter
 * @Description:    java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/30 15:14
 */
class MvPagerAdapter(fm:FragmentManager?, private val mFragments:List<BaseFragment>, private val mTitles:List<String>): FragmentPagerAdapter(fm) {

    override fun getItem(p0: Int): Fragment {
        return mFragments[p0]
    }

    override fun getCount(): Int {
        return mFragments.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mTitles[position]
    }
}