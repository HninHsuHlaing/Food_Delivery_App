package com.padcx.mealdelivery.mvp.views

import com.padcx.mealdelivery.datas.vos.CategoryVO
import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.datas.vos.RestaurantVO
import com.padcx.shared.mvp.view.BaseView



interface MainView : BaseView {
    fun changeHomeScreenViewType( viewType : Int)
    fun navigateToDetailScreen(documentId: String)
    fun showErrorMessage(message: String)
    fun showCategories(categoryList: List<CategoryVO>)
    fun showRestaurants(restaurantList: List<RestaurantVO>)
    fun showPopularChoicesFoodItems(popularChoiceList: List<FoodItemVO>)
}