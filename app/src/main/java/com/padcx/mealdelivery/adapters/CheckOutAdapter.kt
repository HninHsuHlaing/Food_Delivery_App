package com.padcx.mealdelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup

import com.padcx.mealdelivery.datas.vos.FoodItemVO

import com.padcx.mealdelivery.R
import com.padcx.mealdelivery.delegates.CheckoutViewItemActionDelegate
import com.padcx.mealdelivery.viewholders.CheckoutViewHolder
import com.padcx.shared.adapter.BaseRecyclerAdapter


class CheckOutAdapter(private val mDelegate: CheckoutViewItemActionDelegate) :
        BaseRecyclerAdapter<CheckoutViewHolder, FoodItemVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_checkout, parent, false)
        return CheckoutViewHolder(view, mDelegate)

    }
}
