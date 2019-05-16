package com.shinelaw.mobileplayer.view

import com.shinelaw.mobileplayer.model.HomeItemBean

/**
 * @Package:        com.shinelaw.mobileplayer.view
 * @ClassName:      HomeView
 * @Description:    home界面与presenter层交互
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/16 10:57
 */
interface HomeView {
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