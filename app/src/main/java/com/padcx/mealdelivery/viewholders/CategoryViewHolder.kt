package com.padcx.mealdelivery.viewholders

import android.view.View
import com.padcx.mealdelivery.datas.vos.CategoryVO
import com.padcx.mealdelivery.delegates.CategoryViewItemActionDelegate
import com.padcx.shared.util.ImageUtils
import com.padcx.shared.view.viewholder.BaseViewHolder
import kotlinx.android.synthetic.main.view_holder_category_item.view.*

class CategoryViewHolder(itemView: View, private val mDelegate: CategoryViewItemActionDelegate) :
        BaseViewHolder<CategoryVO>(itemView) {

    override fun bindData(data: CategoryVO) {
        data?.let {
            itemView.tv_category.text =data.category_name
            data?.category_image?.let{
                ImageUtils().showImageWithoutCrop(itemView.img_category,it)
            }

        }
    }
}