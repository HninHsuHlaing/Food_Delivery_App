package com.padcx.mealdelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mealdelivery.mvp.presenters.CheckoutPresenter
import com.padcx.mealdelivery.mvp.views.CheckoutView
import com.padcx.mealdelivery.datas.models.FoodDeliveryModel
import com.padcx.mealdelivery.datas.models.FoodDeliveryModelImpl
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class CheckoutPresenterImpl : CheckoutPresenter, AbstractBasePresenter<CheckoutView>() {

    private val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        foodDeliveryModel.getOrderList(
                onSuccess = {
                    mView.showOrderList(it)
                    mView.showCalculationCharge()
                },
                onFaiure = {
                    mView?.showError(it)
                })
    }

    override fun onTap() {

    }


}