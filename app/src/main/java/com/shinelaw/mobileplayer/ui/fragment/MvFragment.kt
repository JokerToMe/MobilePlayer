package com.shinelaw.mobileplayer.ui.fragment

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.View
import com.flyco.tablayout.listener.OnTabSelectListener
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.adapter.MvPagerAdapter
import com.shinelaw.mobileplayer.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_mv.*

class MvFragment : BaseFragment() {

    private val mTitles by lazy { listOf("Android", "iOS", "Web", "Other","JS") }
    private val mFragments by lazy { ArrayList<BaseFragment>() }
    private val mImageArray by lazy { listOf(R.mipmap.bg_android,
        R.mipmap.bg_ios,
        R.mipmap.bg_js,
        R.mipmap.bg_other) }
    private val mColorArray by lazy { listOf(android.R.color.holo_blue_light,
        android.R.color.holo_red_light,
        android.R.color.holo_orange_light,
        android.R.color.holo_green_light) }
    private val mPagerAdapter by lazy { MvPagerAdapter(fragmentManager, mFragments, mTitles) }

    override fun initView(): View? {
        return layoutInflater.inflate(R.layout.fragment_mv, null)
    }

    override fun initListener() {
        initFragments()
        initViewPager()
    }

    private fun initViewPager() {
        vp.adapter = mPagerAdapter
        tl_2.setTabData(mTitles.toTypedArray())
//        tl_2.setOnTabSelectListener(object :OnTabSelectListener{
//
//            override fun onTabSelect(position: Int) {
//                toast("onTabSelect&position--->$position")
//                vp.currentItem = position
//            }
//
//            override fun onTabReselect(position: Int) {
//                toast("onTabReselect&position--->$position")
//            }
//
//        })
        tl_2.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                vp.currentItem = position
            }

            override fun onTabReselect(position: Int) {}
        })
        vp.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{

            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {

            }

            override fun onPageSelected(p0: Int) {
                tl_2.currentTab = p0
            }

        })
    }

    private fun initFragments() {
        for (title in mTitles) {
            val b = Bundle()
            b.putString("title", title)
            val fragment = MvPagerFragment()
            fragment.arguments = b
            mFragments.add(fragment)
        }
    }

}
