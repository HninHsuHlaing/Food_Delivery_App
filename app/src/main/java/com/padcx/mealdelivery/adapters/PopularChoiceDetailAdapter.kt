package com.padcx.mealdelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.delegates.PopularChoiceDeatilViewItemActionDelegate
import com.padcx.mealdelivery.viewholders.PopularDetailViewHolder
import com.padcx.mealdelivery.R
import com.padcx.shared.adapter.BaseRecyclerAdapter


class PopularChoiceDetailAdapter(private val mDelegate: PopularChoiceDeatilViewItemActionDelegate) :
        BaseRecyclerAdapter<PopularDetailViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularDetailViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_popular_choice_detail_layout, parent, false)
        return PopularDetailViewHolder(view, mDelegate)

    }
}