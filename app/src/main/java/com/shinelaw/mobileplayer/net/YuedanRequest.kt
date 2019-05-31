package com.shinelaw.mobileplayer.net

import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.util.ThreadUtil.handler

/**
 * @Package:        com.shinelaw.mobileplayer.net
 * @ClassName:      YuedanRequest
 * @Description:    java类作用描述
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/31 14:46
 */
class YuedanRequest(type:Int,url: String, handler: ResponseHandler<List<HomeItemBean>>):
    MRequest<List<HomeItemBean>>(type,url, handler)  {
}