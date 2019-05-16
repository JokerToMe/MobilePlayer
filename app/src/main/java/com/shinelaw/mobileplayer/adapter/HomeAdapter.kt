package com.shinelaw.mobileplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.widget.HomeItemView
import com.shinelaw.mobileplayer.widget.LoadMoreView

/**
 * @Package:        com.shinelaw.mobileplayer.adapter
 * @ClassName:      HomeAdapter
 * @Description:    HomeAdapter
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/14 14:29
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var list = ArrayList<HomeItemBean>()

     /**
      * @description 刷新数据
      * @date: 2019/5/16 10:40
      * @author: ShineLaw
      * @param
      * @return
      */
    fun updateList(list:List<HomeItemBean>){
        this.list.clear()
        this.list.addAll(list)
        //刷新数据
        notifyDataSetChanged()
    }

     /**
      * @description 加载更多数据
      * @date: 2019/5/16 10:40
      * @author: ShineLaw
      * @param
      * @return
      */
    fun loadMore(list:List<HomeItemBean>){
        this.list.addAll(list)
        //刷新数据
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeHolder {
        return if (p1 == 1){
            //最后一条
            HomeHolder(LoadMoreView(p0.context))
        }else{
            //普通item
            HomeHolder(HomeItemView(p0.context))
        }
    }

    override fun getItemCount(): Int {
        return list.size + 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == list.size){
            1
        }else{
            0
        }
    }

    override fun onBindViewHolder(p0: HomeHolder, p1: Int) {
        if (p1 == list.size){
            //最后一条
            return
        }
        //item数据
        val data = list.get(p1)
        //itemView
        val itemView = p0.itemView as HomeItemView
        //item刷新
        itemView.setData(data)
    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }
}