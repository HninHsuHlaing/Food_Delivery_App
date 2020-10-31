package com.padcx.mealdelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.delegates.PopularViewItemActionDelegate
import com.padcx.mealdelivery.viewholders.PopularChoiceViewHolder
import com.padcx.mealdelivery.R
import com.padcx.shared.adapter.BaseRecyclerAdapter


class PopularChoiceAdapter(private val mDelegate: PopularViewItemActionDelegate) :
        BaseRecyclerAdapter<PopularChoiceViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularChoiceViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_popular_choice, parent, false)
        return PopularChoiceViewHolder(view, mDelegate)

    }
}

