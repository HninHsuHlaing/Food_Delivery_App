import android.graphics.Bitmap
import androidx.lifecycle.LifecycleOwner

import com.padcx.mealdelivery.mvp.presenters.ProfilePresenter
import com.padcx.mealdelivery.mvp.views.ProfileView
import com.padcx.mealdelivery.datas.models.AuthenticationModel
import com.padcx.mealdelivery.datas.models.AuthenticationModelImpl
import com.padcx.mealdelivery.datas.models.FoodDeliveryModel
import com.padcx.mealdelivery.datas.models.FoodDeliveryModelImpl
import mk.padc.share.mvp.presenters.AbstractBasePresenter

class ProfilePresenterImpl : ProfilePresenter, AbstractBasePresenter<ProfileView>() {

    private val mAuthenticationModel: AuthenticationModel = AuthenticationModelImpl

    private  val foodDeliveryModel : FoodDeliveryModel = FoodDeliveryModelImpl

    override fun updateUserProfile(bitmap: Bitmap) {
        foodDeliveryModel.uploadPhotoToFirebaseStorage(bitmap,
                onSuccess = {
                    mView?.onTapSaveUserData()
                    mAuthenticationModel.updateProfile(it,onSuccess = {}, onFailure = {})
                },
                onFailure = {
                    mView?.showError("Profile Updat Failed")
                })

    }

    override fun onTapCancelUserData() {
        mView?.onTapCancelUserData()
    }

    override fun onTapEditProfileImage() {
        mView?.onTapEditProfileImage()
    }

    override fun onUiReady(owner: LifecycleOwner) {
        mAuthenticationModel?.userData(
                onSuccess = {
                    mView?.displayUserData(it)
                },
                onFailure = {}
        )
    }
}



