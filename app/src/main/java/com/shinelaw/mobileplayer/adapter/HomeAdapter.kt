package com.shinelaw.mobileplayer.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.shinelaw.mobileplayer.widget.HomeItemView

/**
 * @Package:        com.shinelaw.mobileplayer.adapter
 * @ClassName:      HomeAdapter
 * @Description:    HomeAdapter
 * @Author:         ShineLaw
 * @CreateDate:     2019/5/14 14:29
 */
class HomeAdapter : RecyclerView.Adapter<HomeAdapter.HomeHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HomeHolder {
        return HomeHolder(HomeItemView(p0.context))
    }

    override fun getItemCount(): Int {
        return 20
    }

    override fun onBindViewHolder(p0: HomeHolder, p1: Int) {

    }

    class HomeHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}