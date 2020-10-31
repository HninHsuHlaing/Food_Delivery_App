package com.padcx.mealdelivery.viewholders

import android.view.View
import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.delegates.PopularChoiceDeatilViewItemActionDelegate
import com.padcx.shared.util.ImageUtils
import com.padcx.shared.view.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_popular_choice_detail_layout.view.*


class PopularDetailViewHolder(itemView: View, private val mDelegate: PopularChoiceDeatilViewItemActionDelegate) :
    BaseViewHolder<FoodItemVO>(itemView) {

    override fun bindData(data: FoodItemVO) {
        data?.let {
            itemView.tv_detail_popularchoice_name.text =data?.food_name
            itemView.tv_detail_popularchoice_price.text =data?.food_price+"$"
            data?.food_image?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_detail_popularchoice,it)
            }
        }
    }
}