package com.shinelaw.mobileplayer.net

import com.shinelaw.mobileplayer.model.HomeItemBean

/**
 * @Package:        com.shinelaw.mobileplayer.net
 * @ClassName:      HomeRequest
 * @Description:    首页数据请求类
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/16 14:30
 */
class HomeRequest(type:Int,url: String, handler: ResponseHandler<List<HomeItemBean>>) :
    MRequest<List<HomeItemBean>>(type,url, handler) {

}