package com.padcx.mealdelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.padcx.mealdelivery.datas.vos.RestaurantVO
import com.padcx.mealdelivery.delegates.RestaurantViewItemActionDelegate
import com.padcx.mealdelivery.viewholders.RestaurantViewHolder
import com.padcx.mealdelivery.R
import com.padcx.shared.adapter.BaseRecyclerAdapter



class RestaurantAdapter(private val mDelegate: RestaurantViewItemActionDelegate, private val mviewType: Int) :
        BaseRecyclerAdapter<RestaurantViewHolder, RestaurantVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        return when (mviewType) {
            0 -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_restaurant_horizontal_viewtype, parent, false)
                RestaurantViewHolder(view, mDelegate)
            }

            else -> {
                val view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.view_holder_restaurant_vertical_viewtype, parent, false)
                RestaurantViewHolder(view, mDelegate)
            }
        }
    }
}


