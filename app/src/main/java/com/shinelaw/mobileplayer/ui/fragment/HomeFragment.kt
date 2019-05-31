package com.shinelaw.mobileplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jcodecraeer.xrecyclerview.ProgressStyle
import com.jcodecraeer.xrecyclerview.XRecyclerView
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
        recyclerview.refreshComplete()
        recyclerview.loadMoreComplete()
        adapter.loadMore(videoList!!)
    }

    override fun onError(message: String?) {
        toast("数据请求失败")
        recyclerview.refreshComplete()
        recyclerview.loadMoreComplete()
    }

    override fun loadSuccess(videoList: List<HomeItemBean>?) {
        toast("数据请求成功")
        recyclerview.refreshComplete()
        recyclerview.loadMoreComplete()
        adapter.updateList(videoList!!)
    }

    val adapter by lazy { HomeAdapter() }
    val presenter by lazy { HomePresenterImpl(this) }

    override fun initView(): View? {
        return layoutInflater.inflate(R.layout.fragment_home, null)
    }

    override fun initListener() {
        recyclerview.layoutManager = LinearLayoutManager(context)
        recyclerview.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerview.setLoadingMoreProgressStyle(ProgressStyle.BallGridBeat);
        recyclerview.setArrowImageView(R.mipmap.iconfont_downgrey);
        recyclerview.defaultRefreshHeaderView.setRefreshTimeVisible(true)
        recyclerview.setLimitNumberToCallLoadMore(2)
        recyclerview.adapter = adapter
        recyclerview.setLoadingListener(object :XRecyclerView.LoadingListener{

            override fun onLoadMore() {
                presenter.loadMoreDatas()
            }

            override fun onRefresh() {
                presenter.loadDatas()
            }

        })
    }

    override fun initData() {
        //初始化数据
        presenter.loadDatas()
    }

}
