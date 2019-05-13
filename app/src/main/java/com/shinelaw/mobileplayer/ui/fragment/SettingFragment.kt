package com.shinelaw.mobileplayer.ui.fragment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.preference.PreferenceFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.base.BaseFragment

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SettingFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SettingFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class SettingFragment : PreferenceFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //通过PreferenceFragment来布局
        addPreferencesFromResource(R.xml.setting)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
