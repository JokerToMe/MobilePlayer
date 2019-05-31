package com.shinelaw.mobileplayer.ui.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.adapter.MvPagerAdapter
import com.shinelaw.mobileplayer.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [MvFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [MvFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class MvFragment : BaseFragment() {

    val mTitles by lazy { listOf("华语","韩流","欧美","日语","音乐","娱乐","综艺") }
    val mFragments by lazy { ArrayList<BaseFragment>() }
    val mImageArray by lazy { ArrayList<Int>() }
    val mColorArray by lazy { ArrayList<Int>() }

    override fun initView(): View? {
        return layoutInflater.inflate(R.layout.fragment_mv,null)
    }

    override fun initListener() {
        super.initListener()
    }

    private fun initFragments() {
        for (title in mTitles){
            val b = Bundle()
            b.putString("title",title)
            val fragment  = MvPagerFragment()
            fragment.arguments = b
            mFragments.add(fragment)
        }
    }

}
