package com.shinelaw.mobileplayer.presenter.impl

import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.net.ResponseHandler
import com.shinelaw.mobileplayer.net.YuedanRequest
import com.shinelaw.mobileplayer.presenter.interf.YuedanPresenter
import com.shinelaw.mobileplayer.view.YuedanView

/**
 * @Package:        com.shinelaw.mobileplayer.presenter.impl
 * @ClassName:      YuedanPresenterImpl
 * @Description:    java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/31 14:24
 */
class YuedanPresenterImpl(val view:YuedanView):YuedanPresenter, ResponseHandler<List<HomeItemBean>> {

    override fun onError(type: Int, msg: String) {
        view.onError(msg)
    }

    override fun onSuccess(type: Int, result: List<HomeItemBean>) {
        when (type) {
            YuedanPresenter.typeInitOrRefresh -> view.loadSuccess(result)
            YuedanPresenter.typeLoadMore -> view.loadMoreSuccess(result)
        }
    }

    override fun loadDatas() {
        YuedanRequest(YuedanPresenter.typeInitOrRefresh, YuedanPresenter.url, this).execute()
    }

    override fun loadMoreDatas() {
        YuedanRequest(YuedanPresenter.typeLoadMore, YuedanPresenter.url, this).execute()
    }
}