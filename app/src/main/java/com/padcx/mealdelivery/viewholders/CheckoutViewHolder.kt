package com.padcx.mealdelivery.viewholders

import android.view.View
import com.padcx.mealdelivery.datas.vos.FoodItemVO

import com.padcx.mealdelivery.delegates.CheckoutViewItemActionDelegate
import com.padcx.shared.util.ImageUtils
import com.padcx.shared.view.viewholder.BaseViewHolder

import kotlinx.android.synthetic.main.viewholder_detail_fooditem_layout.view.*



class CheckoutViewHolder(itemView: View, private val mDelegate: CheckoutViewItemActionDelegate) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

        data?.let {
            itemView.tv_restaurant_name.text =data?.food_name
            itemView.tv_restaurant_description.text = data?.food_description
            itemView.tv_restaurant_rating.text =data?.food_rating
            itemView.tv_restaurant_price.text =data?.food_price+" $"
            data?.food_image?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_restaurant,it)
            }

        }
    }
}