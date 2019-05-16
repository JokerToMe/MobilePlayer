package com.shinelaw.mobileplayer.net

import com.google.gson.Gson
import org.json.JSONObject
import java.lang.reflect.ParameterizedType

/**
 * @Package:        com.shinelaw.mobileplayer.net
 * @ClassName:      MRequest
 * @Description:    所有请求的基类
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/16 13:59
 */
open class MRequest<RESPONSE>(val type: Int, val url: String, val handler: ResponseHandler<RESPONSE>) {

    /**
     * @description 解析网络请求的结果
     * @date: 2019/5/16 14:18
     * @author: ShineLaw
     * @param
     * @return
     */
    fun parseResult(s: String?): RESPONSE {
        println("s=$s")
        val s2 = s?.substring(7, s?.length - 1)
        val gson = Gson()
        println("s=${s2}")
        val data = JSONObject(s2)
        val video = data.getJSONArray("video")
        //获取泛型类型的type（可能有多个泛型，所以是一个数组）
        val type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        //将JsonString转化为Bean类
        val videoList = gson.fromJson<RESPONSE>(video.toString(), type)
        return videoList
    }

    /**
     * @description 发送网络请求
     * @date: 2019/5/16 14:54
     * @author: ShineLaw
     * @param
     * @return
     */
    fun execute() {
        NetManager.sendRequest(type,this)
    }
}