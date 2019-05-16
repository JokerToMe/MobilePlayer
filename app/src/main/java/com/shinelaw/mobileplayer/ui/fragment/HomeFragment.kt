package com.shinelaw.mobileplayer.ui.fragment

import android.graphics.Color
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.adapter.HomeAdapter
import com.shinelaw.mobileplayer.base.BaseFragment
import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.presenter.impl.HomePresenterImpl
import com.shinelaw.mobileplayer.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast

 /**
  * @Package:        com.shinelaw.mobileplayer.ui.fragment
  * @Description:    首页
  * @Author:         Shine
  * @CreateDate:     2019/5/16 15:15
  */
class HomeFragment : BaseFragment(), HomeView {

    override fun loadMoreSuccess(videoList: List<HomeItemBean>?) {
        toast("数据请求成功")
        refreshLayout.isRefreshing = false
        adapter.loadMore(videoList!!)
    }

    override fun onError(message: String?) {
        toast("数据请求失败")
        refreshLayout.isRefreshing = false
    }

    override fun loadSuccess(videoList: List<HomeItemBean>?) {
        toast("数据请求成功")
        refreshLayout.isRefreshing = false
        adapter.updateList(videoList!!)
    }

    val adapter by lazy { HomeAdapter() }
    val presenter by lazy { HomePresenterImpl(this) }

    override fun initView(): View? {
        return layoutInflater.inflate(R.layout.fragment_home, null)
    }

    override fun initListener() {
        //初始化recyclerView
        recycleView.layoutManager = LinearLayoutManager(context)
        //适配
        recycleView.adapter = adapter
        //初始化刷新控件
        refreshLayout.setColorSchemeColors(Color.RED, Color.YELLOW, Color.GREEN)
        //刷新监听
        refreshLayout.setOnRefreshListener {
            presenter.loadDatas()
        }
        //监听列表滑动
        recycleView.addOnScrollListener(object : RecyclerView.OnScrollListener() {

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                println("dx=$dx,dy=$dy")
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
//                when(newState){
//                    //空闲状态
//                    RecyclerView.SCROLL_STATE_IDLE -> println("idle")
//                    //滑动状态
//                    RecyclerView.SCROLL_STATE_DRAGGING -> println("dragging")
//                    //滑动后自然沉降的状态
//                    RecyclerView.SCROLL_STATE_SETTLING -> println("settling")
//                }
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //判断是否是列表、网格还是瀑布流显示
                    if (recyclerView.layoutManager is LinearLayoutManager) {
                        //获取最后一个可见item
                        val manager: LinearLayoutManager = recyclerView.layoutManager as LinearLayoutManager
                        val position = manager.findLastVisibleItemPosition()
//                      //判断是否是最后一条
                        if (position == adapter.itemCount - 1) {
                            presenter.loadMoreDatas()
                        }
                    }
                }
            }
        })
    }

    override fun initData() {
        //初始化数据
        presenter.loadDatas()
    }

    private fun loadDatas() {

    }

    /**
     * @description 加载更多数据
     * @date: 2019/5/16 10:38
     * @author: ShineLaw
     * @param
     * @return
     */
    private fun loadMoreDatas() {

    }
}
