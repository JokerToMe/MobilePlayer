package com.shinelaw.mobileplayer.ui.fragment

import android.os.Bundle
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceScreen
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.ui.activity.AboutActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

class SettingFragment : PreferenceFragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //通过PreferenceFragment来布局
        addPreferencesFromResource(R.xml.setting)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onPreferenceTreeClick(preferenceScreen: PreferenceScreen?, preference: Preference?): Boolean {
        val key = preference?.key
        when(key){
            "clear_cache" -> toast("清除缓存")
            "about" -> activity.startActivity<AboutActivity>()
        }
        return super.onPreferenceTreeClick(preferenceScreen, preference)
    }
}
