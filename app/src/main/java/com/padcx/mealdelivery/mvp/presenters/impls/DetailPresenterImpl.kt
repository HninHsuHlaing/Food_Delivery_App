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

    override fun onUiReady(owner: LifecycleOwner) {}
    override fun onTapAddToCartAction(data: FoodItemVO) {

    }

    override fun onfetchReastaurantData(owner: LifecycleOwner, documentId: String) {

        foodDeliveryModel.getFoodItems(
                documentId,
                onSuccess = {
                    dataList, restaurant ->
                    mView.showPopularChoicesFoodItem(
                            dataList.filter{
                                data -> data.popular == "1"
                            }
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
