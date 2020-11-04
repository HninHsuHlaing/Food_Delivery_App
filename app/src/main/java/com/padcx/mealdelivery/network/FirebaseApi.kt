package com.padcx.mealdelivery.network

import android.graphics.Bitmap
import com.padcx.mealdelivery.datas.vos.CategoryVO
import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.datas.vos.RestaurantVO

interface FirebaseApi {
    fun uploadPhotoToFirebaseStorage(image : Bitmap, onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)
    fun getCategories(onSuccess: (categories: List<CategoryVO>) -> Unit, onFialure: (String) -> Unit)
    fun getRestaurants(onSuccess: (restaurants: List<RestaurantVO>) -> Unit, onFialure: (String) -> Unit)
    fun getFoodItems( documentId: String, onSuccess: (foodList: List<FoodItemVO>, restaurantVO : RestaurantVO,pfoodlist :List<FoodItemVO>) -> Unit, onFialure: (String) -> Unit)
    fun getPopularChoiceList(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFialure: (String) -> Unit)
    fun getOrderList(onSuccess: (restaurants: List<FoodItemVO>) -> Unit, onFialure: (String) -> Unit)
    fun addOrUpdateFoodItem(foodItemVO: FoodItemVO)
    fun deleteFoodItem(id: String)
    fun getCartItemCount(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit)
    fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit)
}