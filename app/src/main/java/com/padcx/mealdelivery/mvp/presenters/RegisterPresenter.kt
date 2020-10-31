package com.padcx.mealdelivery.mvp.presenters

import com.padcx.mealdelivery.mvp.views.RegisterView
import mk.padc.share.mvp.presenters.BasePresenter


interface RegisterPresenter : BasePresenter<RegisterView> {
    fun onTapRegister(username: String, email: String, password: String,phone : String)
    fun navigateToLoginScreen()
}