package com.padcx.mealdelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.delegates.DetailViewItemActionDelegate
import com.padcx.mealdelivery.viewholders.DetailViewHolder
import com.padcx.mealdelivery.R
import com.padcx.shared.adapter.BaseRecyclerAdapter


class DetailAdapter(private val mDelegate: DetailViewItemActionDelegate) :
        BaseRecyclerAdapter<DetailViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.viewholder_detail_fooditem_layout, parent, false)
        return DetailViewHolder(view, mDelegate)

    }
}
