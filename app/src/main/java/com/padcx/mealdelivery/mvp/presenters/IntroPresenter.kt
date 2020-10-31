package com.padcx.mealdelivery.mvp.presenters

import com.padcx.mealdelivery.mvp.views.IntroView
import mk.padc.share.mvp.presenters.BasePresenter

interface IntroPresenter : BasePresenter<IntroView> {
    fun onTapGettingStarted()
}