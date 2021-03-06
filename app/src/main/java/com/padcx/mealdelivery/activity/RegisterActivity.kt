package com.padcx.mealdelivery.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padcx.mealdelivery.mvp.presenters.RegisterPresenter
import com.padcx.mealdelivery.mvp.presenters.impls.RegisterPresenterImpl
import com.padcx.mealdelivery.mvp.views.RegisterView
import com.padcx.mealdelivery.R

import kotlinx.android.synthetic.main.activity_register.*
import mk.padc.share.activities.BaseActivity

class RegisterActivity : BaseActivity() , RegisterView {

    private lateinit var mPresenter: RegisterPresenter


    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, RegisterActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setUpPresenter()
        setUpActionListeners()
    }


    private fun setUpActionListeners() {
        btnRegister.setOnClickListener {
            mPresenter.onTapRegister(
                    etUserName.text.toString(),
                    etEmail.text.toString(),
                    etPassword.text.toString(),
                    etPhone.text.toString()
            )
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<RegisterPresenterImpl, RegisterView>()
        mPresenter.onUiReady(this)
    }

    override fun navigateToToLoginScreen() {
        startActivity(LoginActivity.newIntent(this))
        this.finish()
    }
}