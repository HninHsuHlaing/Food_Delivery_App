package com.padcx.mealdelivery.mvp.presenters

import com.padcx.mealdelivery.delegates.CategoryViewItemActionDelegate
import com.padcx.mealdelivery.delegates.PopularViewItemActionDelegate
import com.padcx.mealdelivery.delegates.RestaurantViewItemActionDelegate
import com.padcx.mealdelivery.mvp.views.MainView
import mk.padc.share.mvp.presenters.BasePresenter


interface MainPresenter : BasePresenter<MainView> , CategoryViewItemActionDelegate, RestaurantViewItemActionDelegate,
        PopularViewItemActionDelegate {
  fun onNavigateDetailScreen(documentId: String)
}