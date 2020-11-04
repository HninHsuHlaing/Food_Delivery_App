package com.padcx.mealdelivery.mvp.views

import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.shared.mvp.view.BaseView

interface CheckoutView : BaseView {
    fun showOrderList(orderList: List<FoodItemVO>)
    fun showCalculationCharge(totalAmount: Long)

}