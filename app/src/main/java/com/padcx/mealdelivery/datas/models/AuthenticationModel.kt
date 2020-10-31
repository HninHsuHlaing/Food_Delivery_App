package com.padcx.mealdelivery.datas.models

import com.padcx.mealdelivery.datas.vos.UserVO
import com.padcx.mealdelivery.network.auth.AuthManager


interface AuthenticationModel {

    var mAuthManager: AuthManager

    fun login(email: String, password: String, onSuccess: () -> Unit, onFailure: (String) -> Unit)

    fun register(
            username: String,
            email: String,
            password: String,
            phone: String,
            onSuccess: () -> Unit,
            onFailure: (String) -> Unit
    )
    fun userData(
            onSuccess: (userVO : UserVO) -> Unit,
            onFailure: (String) -> Unit
    )

    fun updateProfile(
            photoUrl : String,
            onSuccess: () -> Unit,
            onFailure: (String) -> Unit
    )

}