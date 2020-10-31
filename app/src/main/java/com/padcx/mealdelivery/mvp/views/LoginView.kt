package com.padcx.mealdelivery.mvp.views

import com.padcx.shared.mvp.view.BaseView


interface LoginView : BaseView {
    fun navigateToHomeScreen()
    fun navigateToRegisterScreen()
}