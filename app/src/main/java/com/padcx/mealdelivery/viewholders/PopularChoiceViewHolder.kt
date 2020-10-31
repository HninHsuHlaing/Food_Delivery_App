package com.padcx.mealdelivery.viewholders

import android.view.View
import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.delegates.PopularViewItemActionDelegate
import com.padcx.shared.util.ImageUtils
import com.padcx.shared.view.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_popular_choice.view.*



class PopularChoiceViewHolder(itemView: View, private val mDelegate: PopularViewItemActionDelegate) :
    BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {
        data?.let {
          //  itemView.tv_restaurant_name.text = data.
            itemView.tv_food_description.text =data.food_description
            itemView.tv_food_rating.text =data.food_rating+"Stars"
            data?.food_image?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_fooditem,it)
            }
        }
    }
}