package com.padcx.mealdelivery.viewholders

import android.view.View
import com.padcx.mealdelivery.datas.vos.FoodItemVO

import com.padcx.mealdelivery.delegates.CheckoutViewItemActionDelegate
import com.padcx.shared.util.ImageUtils
import com.padcx.shared.view.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_checkout.view.*

import kotlinx.android.synthetic.main.viewholder_detail_fooditem_layout.view.*
import kotlinx.android.synthetic.main.viewholder_detail_fooditem_layout.view.btn_plus
import kotlinx.android.synthetic.main.viewholder_detail_fooditem_layout.view.img_restaurant
import kotlinx.android.synthetic.main.viewholder_detail_fooditem_layout.view.tv_restaurant_description
import kotlinx.android.synthetic.main.viewholder_detail_fooditem_layout.view.tv_restaurant_name
import kotlinx.android.synthetic.main.viewholder_detail_fooditem_layout.view.tv_restaurant_price
import kotlinx.android.synthetic.main.viewholder_detail_fooditem_layout.view.tv_restaurant_rating


class CheckoutViewHolder(itemView: View, private val mDelegate: CheckoutViewItemActionDelegate) :
        BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {

        data?.let {
            itemView.tv_restaurant_name.text =data?.food_name
            itemView.tv_restaurant_description.text = data?.food_description
            itemView.tv_restaurant_rating.text =data?.food_rating
            itemView.tv_restaurant_price.text =data?.food_price.toString()
            itemView.tv_totalamount.text = "Total  ${data?.totalAmount} "
            itemView.tv_itemCount.text =" * ${data?.itemCount}"
            data?.food_image?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_restaurant,it)
            }
            itemView.btn_plus.setOnClickListener{
                mDelegate.onTapIncreaseAddToCartItem(data)
            }
            itemView.btn_minus.setOnClickListener{
                mDelegate.onTapDecreaseAddToCartItem(data)
            }
            itemView.btn_delete.setOnClickListener{
                mDelegate.onTapRemoveAddToCartItem(data)
            }
        }
    }
}