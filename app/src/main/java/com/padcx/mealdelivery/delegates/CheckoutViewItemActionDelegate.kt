package com.padcx.mealdelivery.delegates

import com.padcx.mealdelivery.datas.vos.FoodItemVO


interface CheckoutViewItemActionDelegate {
    fun onTapIncreaseAddToCartItem(foodItemVO: FoodItemVO)
    fun onTapDecreaseAddToCartItem(foodItemVO: FoodItemVO)
    fun onTapRemoveAddToCartItem(foodItemVO: FoodItemVO)
}