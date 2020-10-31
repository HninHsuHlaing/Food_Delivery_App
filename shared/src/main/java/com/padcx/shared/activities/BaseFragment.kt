package mk.padc.share.activities

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.padcx.shared.mvp.view.BaseView
import mk.padc.share.mvp.presenters.AbstractBasePresenter


abstract class BaseFragment : Fragment(), BaseView
{
    override fun showError(error: String) {
     //   Snackbar.make(window.decorView, error, Snackbar.LENGTH_LONG).show()
    }
    inline fun <reified T : AbstractBasePresenter<W>, reified W: BaseView> getPresenter(): T {
        val presenter = ViewModelProviders.of(this).get(T::class.java)
        if (this is W) presenter.initPresenter(this)
        return presenter
    }
}