package com.shinelaw.mobileplayer.util

import android.os.Handler
import android.os.Looper

/**
 * @Package:        com.shinelaw.mobileplayer.util
 * @ClassName:      ThreadUtil
 * @Description:    在子线程中处理主线程的操作
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/15 16:27
 */
object ThreadUtil {

    val handler = Handler(Looper.getMainLooper())
     /**
      * @description 运行在主线程中
      * @date: 2019/5/15 16:29
      * @author: ShineLaw
      * @param
      * @return
      */
    fun runOnUIThread(runnable: Runnable){
        handler.post(runnable)
    }
}