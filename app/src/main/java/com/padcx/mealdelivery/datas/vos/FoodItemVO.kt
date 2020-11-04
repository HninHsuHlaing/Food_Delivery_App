package com.padcx.mealdelivery.datas.vos

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class FoodItemVO(
        var food_name: String?= "",
        var food_description: String? = "",
        var food_price: String = "",
        var food_rating: String? = "",
        var food_image: String? = "",
        var popular: Boolean = false,
        var itemCount: Long =1,
        var totalAmount: Long =0
)