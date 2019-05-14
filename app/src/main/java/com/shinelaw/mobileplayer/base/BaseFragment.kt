package com.shinelaw.mobileplayer.base

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shinelaw.mobileplayer.R
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread
import org.jetbrains.anko.support.v4.runOnUiThread
import org.jetbrains.anko.support.v4.toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [BaseFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [BaseFragment.newInstance] factory method to
 * create an instance of this fragment.
 * 所有fragment的基类
 */
abstract class BaseFragment : Fragment(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

     /**
      * @description fragment初始化
      * @date: 2019/5/13 10:48
      * @author: ShineLaw
      * @param
      * @return
      */
    private fun init() {

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return initView()
    }

     /**
      * @description 获取布局View
      * @date: 2019/5/13 10:49
      * @author: ShineLaw
      * @param
      * @return
      */
    abstract fun initView(): View?

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initListener()
        initData()
    }

     /**
      * @description 初始化数据
      * @date: 2019/5/13 10:41
      * @author: ShineLaw
      * @param
      * @return
      */
    open protected fun initData() {

    }

    /**
      * @description adapter listener
      * @date: 2019/5/13 10:41
      * @author: ShineLaw
      * @param
      * @return
      */
    open protected fun initListener() {

    }

     /**
      * @description 处理子线程toast
      * @date: 2019/5/13 10:51
      * @author: ShineLaw
      * @param
      * @return
      */
    protected fun myToast(msg:String){
        context?.runOnUiThread { toast(msg) }
    }

}
