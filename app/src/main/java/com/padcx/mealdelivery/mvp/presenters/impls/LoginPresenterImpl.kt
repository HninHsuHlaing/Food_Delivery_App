package com.padcx.mealdelivery.mvp.presenters.impls

import android.util.Log
import androidx.lifecycle.LifecycleOwner

import com.padcx.mealdelivery.mvp.presenters.LoginPresenter
import com.padcx.mealdelivery.mvp.views.LoginView
import com.padcx.mealdelivery.datas.models.AuthenticationModel
import com.padcx.mealdelivery.datas.models.AuthenticationModelImpl
import com.padcx.mealdelivery.datas.models.FoodDeliveryModel
import com.padcx.mealdelivery.datas.models.FoodDeliveryModelImpl
import mk.padc.share.mvp.presenters.AbstractBasePresenter


class LoginPresenterImpl : LoginPresenter, AbstractBasePresenter<LoginView>() {

    private val mAuthenticatioModel: AuthenticationModel = AuthenticationModelImpl

    private  val mFoodDeliveryModel : FoodDeliveryModel =FoodDeliveryModelImpl

    override fun onUiReady(owner: LifecycleOwner) {
        Log.e("Firebase","login ui ready")
        mFoodDeliveryModel.setUpRemoteConfigWithDefaultValues()
        mFoodDeliveryModel.fetchRemoteConfigs()
    }

    override fun onTapLogin(email: String, password: String) {
        mAuthenticatioModel.login(email, password, onSuccess = {
            mView.navigateToHomeScreen()
        }, onFailure = {
            mView.showError(it)
        })
    }

    override fun onTapRegister() {
        mView.navigateToRegisterScreen()
    }
}