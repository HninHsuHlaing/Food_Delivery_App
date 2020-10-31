package com.padcx.mealdelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mealdelivery.mvp.presenters.RegisterPresenter
import com.padcx.mealdelivery.mvp.views.RegisterView
import com.padcx.mealdelivery.datas.models.AuthenticationModel
import com.padcx.mealdelivery.datas.models.AuthenticationModelImpl
import mk.padc.share.mvp.presenters.AbstractBasePresenter


class RegisterPresenterImpl : RegisterPresenter, AbstractBasePresenter<RegisterView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    override fun onTapRegister(username: String, email: String, password: String, phone : String) {
        mAuthenticationModel.register(username, email, password,phone, onSuccess = {
            mView.navigateToToLoginScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun navigateToLoginScreen() {
        mView.navigateToToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {}
}