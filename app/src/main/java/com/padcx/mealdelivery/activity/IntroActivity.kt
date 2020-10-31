package com.padcx.mealdelivery.activity

import android.os.Bundle
import com.padcx.mealdelivery.mvp.presenters.IntroPresenter
import com.padcx.mealdelivery.mvp.presenters.impls.IntroPresenterImpl
import com.padcx.mealdelivery.mvp.views.IntroView
import com.padcx.mealdelivery.R

import kotlinx.android.synthetic.main.activity_intro_screeen.*
import mk.padc.share.activities.BaseActivity

class IntroActivity : BaseActivity() , IntroView {

    private lateinit var mPresenter: IntroPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro_screeen)
        setUpPresenter()
        setUpActionListeners()
    }
    private fun setUpActionListeners() {
        btn_get_started.setOnClickListener{
            mPresenter.onTapGettingStarted()
            this.finish()
        }
    }
    private fun setUpPresenter() {
        mPresenter = getPresenter<IntroPresenterImpl, IntroView>()
        mPresenter.onUiReady(this)
    }
    override fun navigateToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
    }
}