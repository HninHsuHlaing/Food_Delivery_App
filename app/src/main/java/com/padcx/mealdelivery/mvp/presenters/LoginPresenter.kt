package com.padcx.mealdelivery.mvp.presenters

import com.padcx.mealdelivery.mvp.views.LoginView
import mk.padc.share.mvp.presenters.BasePresenter

interface LoginPresenter : BasePresenter<LoginView> {
    fun onTapLogin(email: String, password: String)
    fun onTapRegister()
}