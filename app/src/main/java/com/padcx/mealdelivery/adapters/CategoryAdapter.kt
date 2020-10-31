package com.padcx.mealdelivery.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.padcx.mealdelivery.datas.vos.CategoryVO
import com.padcx.mealdelivery.delegates.CategoryViewItemActionDelegate
import com.padcx.mealdelivery.viewholders.CategoryViewHolder
import com.padcx.mealdelivery.R
import com.padcx.shared.adapter.BaseRecyclerAdapter


class CategoryAdapter(private val mDelegate: CategoryViewItemActionDelegate) :
        BaseRecyclerAdapter<CategoryViewHolder, CategoryVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {

        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.view_holder_category_item, parent, false)
        return CategoryViewHolder(view, mDelegate)

    }
}

