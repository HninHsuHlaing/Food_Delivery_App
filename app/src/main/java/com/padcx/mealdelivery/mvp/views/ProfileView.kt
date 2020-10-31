package com.padcx.mealdelivery.mvp.views

import com.padcx.mealdelivery.datas.vos.UserVO
import com.padcx.shared.mvp.view.BaseView


interface ProfileView : BaseView {
    fun onTapSaveUserData()
    fun onTapCancelUserData()
    fun onTapEditProfileImage()
    fun displayUserData(userVO: UserVO)
}