package mk.padc.share.mvp.presenters
import androidx.lifecycle.ViewModel
import com.padcx.shared.mvp.view.BaseView


abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T>, ViewModel() {

    protected lateinit var mView : T

    override fun initPresenter(view: T) {
        mView = view
    }
}