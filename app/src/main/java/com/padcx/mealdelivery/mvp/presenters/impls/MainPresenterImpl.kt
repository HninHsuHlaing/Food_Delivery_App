package com.padcx.mealdelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mealdelivery.mvp.presenters.MainPresenter
import com.padcx.mealdelivery.mvp.views.MainView
import com.padcx.mealdelivery.datas.models.FoodDeliveryModel
import com.padcx.mealdelivery.datas.models.FoodDeliveryModelImpl
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class MainPresenterImpl : MainPresenter, AbstractBasePresenter<MainView>() {

    private val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onNavigateDetailScreen(documentId : String) {
        mView?.navigateToDetailScreen(documentId)
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mView?.changeHomeScreenViewType(foodDeliveryModel.getHomeScreenTypeStatusFromRemoteConfig())

        foodDeliveryModel.getCategories(
                onSuccess = {
                    mView.showCategories(it)
                },
                onFaiure = {
                    //       mView.showErrorMessage(it)
                })

        foodDeliveryModel.getRestaurants(
                onSuccess = {
                    mView.showRestaurants(it)
                },
                onFaiure = {
                    //       mView.showErrorMessage(it)
                })



        foodDeliveryModel.getPopularChoiceList(
                onSuccess = {
                    mView.showPopularChoicesFoodItems(it)
                },
                onFaiure = {
                    //       mView.showErrorMessage(it)
                })

    }

    override fun onTap() {

    }

    override fun onTapRestaurentListItem(documentId: String) {
        mView.navigateToDetailScreen(documentId)
    }

    override fun onTapPopularChoiceListItem() {
    }

}

