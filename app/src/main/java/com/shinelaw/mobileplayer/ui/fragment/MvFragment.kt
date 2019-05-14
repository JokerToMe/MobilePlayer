package com.shinelaw.mobileplayer.ui.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shinelaw.mobileplayer.R
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

    override fun initView(): View? {
        return layoutInflater.inflate(R.layout.fragment_mv,null)
    }

}
