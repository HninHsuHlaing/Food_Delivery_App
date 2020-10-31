package com.padcx.mealdelivery.mvp.presenters.impls

import androidx.lifecycle.LifecycleOwner
import com.padcx.mealdelivery.mvp.presenters.IntroPresenter
import com.padcx.mealdelivery.mvp.views.IntroView
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class IntroPresenterImpl : IntroPresenter, AbstractBasePresenter<IntroView>() {
    override fun onTapGettingStarted() {
        mView?.navigateToLoginScreen()
    }

    override fun onUiReady(owner: LifecycleOwner) {}
}

