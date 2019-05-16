package com.shinelaw.mobileplayer.presenter.impl

import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.net.HomeRequest
import com.shinelaw.mobileplayer.net.ResponseHandler
import com.shinelaw.mobileplayer.presenter.interf.HomePresenter
import com.shinelaw.mobileplayer.presenter.interf.HomePresenter.Companion.typeInitOrRefresh
import com.shinelaw.mobileplayer.presenter.interf.HomePresenter.Companion.typeLoadMore
import com.shinelaw.mobileplayer.presenter.interf.HomePresenter.Companion.url
import com.shinelaw.mobileplayer.view.HomeView

/**
 * @Package:        com.shinelaw.mobileplayer.presenter.impl
 * @ClassName:      HomePresenterImpl
 * @Description:    java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/16 11:04
 */
class HomePresenterImpl(var homeView: HomeView?) : HomePresenter, ResponseHandler<List<HomeItemBean>> {

     /**
      * @description 解绑View层和Presenter层
      * @date: 2019/5/16 15:21
      * @author: ShineLaw
      * @param
      * @return
      */
    fun destoryView(){
        if (homeView != null){
            homeView = null
        }
    }

    override fun onError(type: Int, msg: String) {
        homeView?.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {
        when (type) {
            typeInitOrRefresh -> homeView?.loadSuccess(result)
            typeLoadMore -> homeView?.loadMoreSuccess(result)
        }
    }


    override fun loadDatas() {
        //定义一个HomeRequest
        HomeRequest(typeInitOrRefresh, url, this).execute()
    }

    override fun loadMoreDatas() {
        //定义一个HomeRequest
        HomeRequest(typeLoadMore, url, this).execute()
    }
}