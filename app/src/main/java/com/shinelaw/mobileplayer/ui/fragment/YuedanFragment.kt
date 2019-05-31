package com.shinelaw.mobileplayer.ui.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.jcodecraeer.xrecyclerview.ProgressStyle
import com.jcodecraeer.xrecyclerview.XRecyclerView
import com.shinelaw.mobileplayer.R
import com.shinelaw.mobileplayer.adapter.YuedanAdapter
import com.shinelaw.mobileplayer.base.BaseFragment
import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.presenter.impl.YuedanPresenterImpl
import com.shinelaw.mobileplayer.view.YuedanView
import kotlinx.android.synthetic.main.fragment_home.*
import org.jetbrains.anko.support.v4.toast

/**
 * @description 悦单
 * @date: 2019/5/16 15:29
 * @author: ShineLaw
 * @param
 * @return
 */
class YuedanFragment : BaseFragment(),YuedanView {

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

    private val adapter by lazy { YuedanAdapter() }
    val presenter by lazy { YuedanPresenterImpl(this) }

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
        recyclerview.setLoadingListener(object : XRecyclerView.LoadingListener{

            override fun onLoadMore() {
                presenter.loadMoreDatas()
            }

            override fun onRefresh() {
                presenter.loadDatas()
            }

        })
    }

}
