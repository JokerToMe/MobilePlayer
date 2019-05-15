package com.shinelaw.mobileplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.widget.HomeItemView

/**
 * @Package:        com.shinelaw.mobileplayer.adapter
 * @ClassName:      HomeAdapter
 * @Description:    HomeAdapter
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/14 14:29
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    private var list = ArrayList<HomeItemBean>()

    fun updateList(list:List<HomeItemBean>){
        this.list.clear()
        this.list.addAll(list)
        //刷新数据
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeHolder {
        return HomeHolder(HomeItemView(p0.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: HomeHolder, p1: Int) {
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