package com.padcx.mealdelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mealdelivery.datas.vos.FoodItemVO

import com.padcx.mealdelivery.mvp.presenters.DetailPresenter
import com.padcx.mealdelivery.mvp.views.DetailView
import com.padcx.mealdelivery.datas.models.FoodDeliveryModel
import com.padcx.mealdelivery.datas.models.FoodDeliveryModelImpl
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class DetailPresenterImpl : DetailPresenter, AbstractBasePresenter<DetailView>() {

    private val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        foodDeliveryModel.getCartItemCount(
                onSuccess = {
                    mView?.showViewCartCount(it)
                },
                onFialure = {
                    mView?.showError(it)
                })
    }

    override fun onTapAddToCartAction(data: FoodItemVO) {

        var totalAmount= data.itemCount * data.food_price.toLong()
        data.totalAmount= totalAmount
        foodDeliveryModel.addOrUpdateFoodItem(data)

        foodDeliveryModel.getCartItemCount(
                onSuccess = {
                    mView?.showViewCartCount(it)
                },
                onFialure = {
                    mView?.showError(it)
                })
    }

    override fun onRestaurantRecieved(owner: LifecycleOwner, documentId: String) {

        foodDeliveryModel.getFoodItems(
                documentId,
                onSuccess = {
                    dataList, restaurant,pFoodlist ->
                    val plist : MutableList<FoodItemVO>
                    mView.showPopularChoicesFoodItem(
                            pFoodlist
                    )
                    mView.showRestaurantData(restaurant)
                    mView.showFoodItemList(dataList)
                },
                onFaiure = {
                    mView?.showError(it)
                })
    }

    override fun onTapPopularChoiceDelegateAction() {}
}
