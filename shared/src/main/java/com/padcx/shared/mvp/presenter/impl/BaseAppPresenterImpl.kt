package com.padcx.shared.mvp.presenter.impl

import com.padcx.shared.mvp.view.BaseView
import mk.padc.share.mvp.presenters.AbstractBasePresenter
import mk.padc.share.mvp.presenters.BasePresenter


abstract class BaseAppPresenterImpl<V : BaseView> : AbstractBasePresenter<V>(), BasePresenter<V>
