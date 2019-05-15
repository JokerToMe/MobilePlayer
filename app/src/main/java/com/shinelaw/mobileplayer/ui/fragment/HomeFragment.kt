package com.shinelaw.mobileplayer.ui.fragment

import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.adapter.HomeAdapter
import com.shinelaw.mobileplayer.base.BaseFragment
import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.util.ThreadUtil
import kotlinx.android.synthetic.main.fragment_home.*
import okhttp3.*
import org.json.JSONObject
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

    val adapter by lazy { HomeAdapter() }

    override fun initView(): View? {
        return layoutInflater.inflate(R.layout.fragment_home,null)
    }

    override fun initListener() {
        //初始化recyclerView
        recycleView.layoutManager = LinearLayoutManager(context)
        //适配
        recycleView.adapter = adapter
    }

    override fun initData() {
        //初始化数据
        loadDatas()
    }

    private fun loadDatas() {
        val path = "http://www.yinyuetai.com/mv/get-guess?size=18&callback=jsonp7"
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
                val s = response.body()?.string()
                println("s=$s")
                val s2 = s?.substring(7, s?.length-1)
                val gson = Gson()
                println("s=${s2}")
                val data = JSONObject(s2)
                val video = data.getJSONArray("video")
                //将JsonString转化为Bean类
                val videoList = gson.fromJson<List<HomeItemBean>>(video.toString(),object :TypeToken<List<HomeItemBean>>(){}.type)
                println("videoList.size=${videoList.size}")
                //在主线程中刷新视图
                ThreadUtil.runOnUIThread(object :Runnable{

                    override fun run() {
                        adapter.updateList(videoList)
                    }
                })
            }
        })
    }
}
