package com.padcx.mealdelivery.viewholders

import android.view.View
import com.padcx.mealdelivery.datas.vos.RestaurantVO
import com.padcx.mealdelivery.delegates.RestaurantViewItemActionDelegate
import com.padcx.shared.util.ImageUtils
import com.padcx.shared.view.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.view.img_restaurant
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.view.ll_restaurant
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.view.tv_restaurant_description
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.view.tv_restaurant_name
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.view.tv_restaurant_rating



class RestaurantViewHolder(itemView: View, private val mDelegate: RestaurantViewItemActionDelegate) :
        BaseViewHolder<RestaurantVO>(itemView) {

    override fun bindData(data: RestaurantVO) {
        data?.let {
            itemView.tv_restaurant_name.text =data?.name
            itemView.tv_restaurant_description.text = data?.description
            itemView.tv_restaurant_rating.text =data?.rating
            data?.image_url?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_restaurant,it)
            }
        }
        itemView.ll_restaurant.setOnClickListener {
            data?.id.let{mDelegate.onTapRestaurentListItem(it.toString())}
        }

    }
}