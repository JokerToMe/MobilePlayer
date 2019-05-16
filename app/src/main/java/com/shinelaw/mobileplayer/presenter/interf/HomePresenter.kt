package com.shinelaw.mobileplayer.presenter.interf

/**
 * @Package:        com.shinelaw.mobileplayer.presenter.interf
 * @ClassName:      HomePresenter
 * @Description:    java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/16 11:04
 */
interface HomePresenter {

    companion object {
        val url by lazy { "http://www.yinyuetai.com/mv/get-guess?size=18&callback=jsonp7" }
        val typeInitOrRefresh by lazy { 1 }
        val typeLoadMore by lazy { 2 }
    }

    /**
     * @description 加载数据
     * @date: 2019/5/16 10:38
     * @author: ShineLaw
     * @param
     * @return
     */
    fun loadDatas()

    /**
     * @description 加载更多数据
     * @date: 2019/5/16 10:38
     * @author: ShineLaw
     * @param
     * @return
     */
    fun loadMoreDatas()

}