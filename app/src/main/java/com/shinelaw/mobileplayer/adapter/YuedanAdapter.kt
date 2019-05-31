package com.shinelaw.mobileplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.shinelaw.mobileplayer.model.HomeItemBean
import com.shinelaw.mobileplayer.widget.HomeItemView
import com.shinelaw.mobileplayer.widget.LoadMoreView
import com.shinelaw.mobileplayer.widget.YuedanItemView

/**
 * @Package:        com.shinelaw.mobileplayer.adapter
 * @ClassName:      YuedanAdapter
 * @Description:    YuedanAdapter
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/14 14:29
 */
class YuedanAdapter : RecyclerView.Adapter<YuedanAdapter.YuedanHolder>() {

    private var list = ArrayList<HomeItemBean>()

    /**
     * @description 刷新数据
     * @date: 2019/5/16 10:40
     * @author: ShineLaw
     * @param
     * @return
     */
    fun updateList(list: List<HomeItemBean>) {
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
    fun loadMore(list: List<HomeItemBean>) {
        this.list.addAll(list)
        //刷新数据
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): YuedanAdapter.YuedanHolder {
        return YuedanAdapter.YuedanHolder(YuedanItemView(p0.context))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: YuedanAdapter.YuedanHolder, p1: Int) {
        //item数据
        val data = list.get(p1)
        //itemView
        val itemView = p0.itemView as YuedanItemView
        //item刷新
        itemView.setData(data)
    }

    class YuedanHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }
}