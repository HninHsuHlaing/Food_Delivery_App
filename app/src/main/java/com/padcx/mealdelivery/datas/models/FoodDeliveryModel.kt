package com.padcx.mealdelivery.datas.models

import android.graphics.Bitmap
import com.padcx.mealdelivery.datas.vos.CategoryVO
import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.datas.vos.RestaurantVO
import com.padcx.mealdelivery.network.FirebaseApi
import com.padcx.mealdelivery.network.remoteconfig.FirebaseRemoteConfigManager

interface FoodDeliveryModel {

    var mFirebaseApi : FirebaseApi

    var mFirebaseRemoteConfigManager : FirebaseRemoteConfigManager

    fun setUpRemoteConfigWithDefaultValues()

    fun fetchRemoteConfigs()

    fun getHomeScreenTypeStatusFromRemoteConfig() : Int

    fun uploadPhotoToFirebaseStorage( image : Bitmap , onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit)

    fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getFoodItems(documentId: String, onSuccess: (List<FoodItemVO>,RestaurantVO,List<FoodItemVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getPopularChoiceList(onSuccess: (List<FoodItemVO>) -> Unit, onFaiure: (String) -> Unit)

    fun getOrderList(onSuccess: (List<FoodItemVO>) -> Unit, onFaiure: (String) -> Unit)

    fun addOrUpdateFoodItem(foodItemVO: FoodItemVO)

    fun removeFoodItem(name: String)

    fun getCartItemCount(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit)

    fun getTotalPrice(onSuccess: (cartCount: Long) -> Unit, onFialure: (String) -> Unit)

}