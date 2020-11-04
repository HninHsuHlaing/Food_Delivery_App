package com.padcx.mealdelivery.mvp.presenters

import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.mvp.views.CheckoutView
import com.padcx.mealdelivery.delegates.CheckoutViewItemActionDelegate
import mk.padc.share.mvp.presenters.BasePresenter

interface CheckoutPresenter : BasePresenter<CheckoutView>,CheckoutViewItemActionDelegate {
    fun onTapCheckout(orderList: List<FoodItemVO>)
}