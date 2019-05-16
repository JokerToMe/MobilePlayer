package com.shinelaw.mobileplayer.net

import com.shinelaw.mobileplayer.util.ThreadUtil
import okhttp3.*
import java.io.IOException

/**
 * @Package:        com.shinelaw.mobileplayer.net
 * @ClassName:      NetManager
 * @Description:    发送网络请求的类
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/16 14:05
 */
object NetManager {

    val client by lazy { OkHttpClient() }

    /**
     * @description 发送网络请求
     * @date: 2019/5/16 14:07
     * @author: ShineLaw
     * @param
     * @return
     */
    fun <RESPONSE> sendRequest(type: Int, req: MRequest<RESPONSE>) {
        val request = Request.Builder()
            .url(req.url)
            .get()
            .build()
        client.newCall(request).enqueue(object : Callback {
            /**
             * 子线程调用
             */
            override fun onFailure(call: Call, e: IOException) {
                ThreadUtil.runOnUIThread(Runnable {
                    req.handler.onError(type, e.message!!)
                })
            }

            override fun onResponse(call: Call, response: Response) {
                val s = response.body()?.string()
                val parseResult = req.parseResult(s)
                //在主线程中刷新视图
                ThreadUtil.runOnUIThread(Runnable {
                    req.handler.onSuccess(type, parseResult)
                })
            }
        })
    }
}