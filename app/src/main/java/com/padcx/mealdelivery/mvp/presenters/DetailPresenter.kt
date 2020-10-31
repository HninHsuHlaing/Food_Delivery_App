package com.padcx.mealdelivery.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.mealdelivery.delegates.DetailViewItemActionDelegate
import com.padcx.mealdelivery.delegates.PopularChoiceDeatilViewItemActionDelegate
import com.padcx.mealdelivery.mvp.views.DetailView
import mk.padc.share.mvp.presenters.BasePresenter

interface DetailPresenter : BasePresenter<DetailView>, DetailViewItemActionDelegate,
        PopularChoiceDeatilViewItemActionDelegate {
    fun onfetchReastaurantData(lifecycleOwner: LifecycleOwner, documentId : String)
}