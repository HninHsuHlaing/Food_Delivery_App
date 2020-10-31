package com.padcx.mealdelivery.delegates

import com.padcx.mealdelivery.datas.vos.FoodItemVO

interface DetailViewItemActionDelegate {
    fun onTapAddToCartAction(data: FoodItemVO)
}