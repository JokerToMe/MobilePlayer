package com.shinelaw.mobileplayer.net

/**
 * @Package:        com.shinelaw.mobileplayer.net
 * @ClassName:      ResponseHandler
 * @Description:    请求回调
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/16 14:01
 */
interface ResponseHandler<RESPONSE> {

    fun onError(type: Int, msg: String)

    fun onSuccess(type: Int, result: RESPONSE)
}