package com.padcx.mealdelivery.datas.models

import android.graphics.Bitmap
import com.padcx.mealdelivery.datas.vos.CategoryVO
import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.datas.vos.RestaurantVO
import com.padcx.mealdelivery.network.FirebaseApi
import com.padcx.mealdelivery.network.impls.CloudFirestoreFirebaseApiImpl
import com.padcx.mealdelivery.network.remoteconfig.FirebaseRemoteConfigManager


object FoodDeliveryModelImpl : FoodDeliveryModel {

    override var mFirebaseApi: FirebaseApi = CloudFirestoreFirebaseApiImpl

    override  var mFirebaseRemoteConfigManager: FirebaseRemoteConfigManager = FirebaseRemoteConfigManager

    override fun setUpRemoteConfigWithDefaultValues() {
        mFirebaseRemoteConfigManager.setUpRemoteConfigWithDeaultValues()
    }

    override fun fetchRemoteConfigs() {
        mFirebaseRemoteConfigManager.fetchRemoteConfigs()
    }

    override fun getHomeScreenTypeStatusFromRemoteConfig(): Int {
        return  mFirebaseRemoteConfigManager.getHomeScreenViewTypeStatus()
    }

    override fun uploadPhotoToFirebaseStorage(image: Bitmap , onSuccess: (photoUrl : String) -> Unit, onFailure: (String) -> Unit) {
        mFirebaseApi.uploadPhotoToFirebaseStorage(image ,onSuccess,onFailure)
    }


    override fun getCategories(onSuccess: (List<CategoryVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getCategories(onSuccess, onFaiure)
    }

    override fun getRestaurants(onSuccess: (List<RestaurantVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getRestaurants(onSuccess, onFaiure)
    }



    override fun getFoodItems(
            documentId: String,
            onSuccess: (List<FoodItemVO>, RestaurantVO) -> Unit,
            onFaiure: (String) -> Unit
    ) {
        mFirebaseApi.getFoodItems(documentId,onSuccess, onFaiure)
    }

    override fun getPopularChoiceList(
            onSuccess: (List<FoodItemVO>) -> Unit,
            onFaiure: (String) -> Unit
    ) {
        mFirebaseApi.getPopularChoiceList(onSuccess, onFaiure)
    }

    override fun getOrderList(onSuccess: (List<FoodItemVO>) -> Unit, onFaiure: (String) -> Unit) {
        mFirebaseApi.getOrderList(onSuccess, onFaiure)
    }


    override fun addOrUpdateFoodItem(foodItemVO: FoodItemVO) {
        mFirebaseApi.addOrUpdateFoodItem(foodItemVO)
    }

    override fun removeFoodItem(id: String) {
        mFirebaseApi.deleteFoodItem(id)
    }


}