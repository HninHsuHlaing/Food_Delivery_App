package com.padcx.mealdelivery.mvp.views

import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.datas.vos.RestaurantVO
import com.padcx.shared.mvp.view.BaseView


interface DetailView : BaseView {
    fun showRestaurantData(restaurantVO: RestaurantVO)
    fun showPopularChoicesFoodItem(popularFoodList: List<FoodItemVO>)
    fun showFoodItemList(foodList: List<FoodItemVO>)
    fun showViewCartCount(cartCount : Long)
}