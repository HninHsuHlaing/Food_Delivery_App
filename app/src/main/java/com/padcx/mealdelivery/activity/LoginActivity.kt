package com.padcx.mealdelivery.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.padcx.mealdelivery.mvp.presenters.LoginPresenter
import com.padcx.mealdelivery.mvp.presenters.impls.LoginPresenterImpl
import com.padcx.mealdelivery.mvp.views.LoginView
import com.padcx.mealdelivery.R

import kotlinx.android.synthetic.main.activity_login.*
import mk.padc.share.activities.BaseActivity

class LoginActivity : BaseActivity() , LoginView {

    private lateinit var mPresenter: LoginPresenter

    companion object {
        fun newIntent(context: Context) : Intent {
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setUpPresenter()
        setUpActionListeners()
    }

    private fun setUpActionListeners() {
        btnLogin.setOnClickListener {
            mPresenter.onTapLogin(ed_email.text.toString(), ed_password.text.toString())
        }

        btnRegister.setOnClickListener {
            mPresenter.onTapRegister()
        }
    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
        mPresenter.onUiReady(this)
    }

    override fun navigateToHomeScreen() {
        startActivity(MainActivity.newIntent(this))
        this.finish()
    }

    override fun navigateToRegisterScreen() {
        startActivity(RegisterActivity.newIntent(this))
        this.finish()
    }

}