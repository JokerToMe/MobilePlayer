package com.shinelaw.mobileplayer.ui.fragment

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.adapter.HomeAdapter
import com.shinelaw.mobileplayer.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import java.io.IOException

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [HomeFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class HomeFragment : BaseFragment() {

    override fun initView(): View? {
        return layoutInflater.inflate(R.layout.fragment_home,null)
    }

    override fun initListener() {
        //初始化recyclerView
        recycleView.layoutManager = LinearLayoutManager(context)
        //适配
        val adapter = HomeAdapter()
        recycleView.adapter = adapter
    }

    override fun initData() {
        //初始化数据
        loadDatas()
    }

    private fun loadDatas() {
        val path = "http://wmapi.yinyuetai.com/component/prefecture.json?&screen=2&type=1"
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(path)
            .get()
            .build()
        client.newCall(request).enqueue(object:Callback{
            /**
             * 子线程调用
             */
            override fun onFailure(call: Call, e: IOException) {
                myToast("获取数据失败")
            }

            override fun onResponse(call: Call, response: Response) {
                myToast("获取数据成功")
                val s = response.body().toString()
                println("返回数据为：$s")
            }
        })
    }
}
