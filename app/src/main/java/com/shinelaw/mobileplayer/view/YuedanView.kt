package com.shinelaw.mobileplayer.view

import com.shinelaw.mobileplayer.model.HomeItemBean

/**
 * @Package:        com.shinelaw.mobileplayer.view
 * @ClassName:      YuedanView
 * @Description:    java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/31 14:20
 */
interface YuedanView {

    /**
     * @description 加载更多时回调处理
     * @date: 2019/5/16 13:45
     * @author: ShineLaw
     * @param
     * @return
     */
    fun loadMoreSuccess(videoList: List<HomeItemBean>?)

    /**
     * @description 请求失败时回调处理
     * @date: 2019/5/16 13:46
     * @author: ShineLaw
     * @param
     * @return
     */
    fun onError(message: String?)

    /**
     * @description 刷新数据时回调处理
     * @date: 2019/5/16 13:46
     * @author: ShineLaw
     * @param
     * @return
     */
    fun loadSuccess(videoList: List<HomeItemBean>?)
}