package mk.padc.share.mvp.presenters
import androidx.lifecycle.LifecycleOwner
import com.padcx.shared.mvp.view.BaseView


interface BasePresenter<T : BaseView> {
    fun initPresenter(view: T)
    fun onUiReady(owner: LifecycleOwner)
}