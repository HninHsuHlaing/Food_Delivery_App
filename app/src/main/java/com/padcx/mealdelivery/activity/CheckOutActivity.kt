package com.padcx.mealdelivery.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.mealdelivery.datas.vos.FoodItemVO
import com.padcx.mealdelivery.dialog.BottomSheetFragment
import com.padcx.mealdelivery.mvp.presenters.CheckoutPresenter
import com.padcx.mealdelivery.mvp.presenters.impls.CheckoutPresenterImpl
import com.padcx.mealdelivery.mvp.views.CheckoutView
import com.padcx.mealdelivery.R
import com.padcx.mealdelivery.adapters.CheckOutAdapter
import com.padcx.shared.util.ImageUtils
import kotlinx.android.synthetic.main.activity_check_out.*
import kotlinx.android.synthetic.main.view_holder_restaurant_vertical_viewtype.*

import mk.padc.share.activities.BaseActivity

class CheckOutActivity : BaseActivity() , CheckoutView {

    private lateinit var mPresenter: CheckoutPresenter
    private lateinit var mAdapter: CheckOutAdapter

    companion object {
        const val PARM_RESTAURANT_IMAGE = "PARM_RESTAURANT_IMAGE"
        const val PARM_RESTAURANT_NAME = "PARM_RESTAURANT_NAME"
        const val PARM_RESTAURANT_DESRIPTION = "PARM_RESTAURANT_DESRIPTION"
        const val PARM_RESTAURANT_RATING= "PARM_RESTAURANT_RATING"
        fun newIntent(context: Context,
                      restaurant_name: String?, restaurant_description: String?,
                      restaurant_image: String?, restaurant_rating: String?
        ) : Intent {
            val intent = Intent(context, CheckOutActivity::class.java)
            intent.putExtra(PARM_RESTAURANT_IMAGE, restaurant_image)
            intent.putExtra(PARM_RESTAURANT_NAME, restaurant_name)
            intent.putExtra(PARM_RESTAURANT_DESRIPTION, restaurant_description)
            intent.putExtra(PARM_RESTAURANT_RATING, restaurant_rating)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out)
        setUpPresenter()
        initView()
        setUpRecyclerView()
        setUpActionListener()
    }
    private fun initView()
    {
        tv_restaurant_name.text =    intent.getStringExtra(PARM_RESTAURANT_NAME).toString()
        tv_restaurant_description.text =     intent.getStringExtra(PARM_RESTAURANT_DESRIPTION).toString()
        tv_restaurant_rating.text =    intent.getStringExtra(PARM_RESTAURANT_RATING).toString()
        intent.getStringExtra(PARM_RESTAURANT_IMAGE)?.let{
            ImageUtils().showImageWithoutCrop(img_restaurant,it)
        }
    }
    private fun setUpActionListener()
    {
        btn_checkout.setOnClickListener{
            showBottomSheetDialogFragment()
        }
        ll_backpress.setOnClickListener{
            onBackPressed()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
    private fun showBottomSheetDialogFragment() {
        val bottomSheetFragment = BottomSheetFragment()
        bottomSheetFragment.show(supportFragmentManager, bottomSheetFragment.tag)
    }

    private fun setUpRecyclerView() {

        rc_orderList.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        mAdapter = CheckOutAdapter (mPresenter)
        rc_orderList.adapter = mAdapter

    }


    private fun setUpPresenter() {
        mPresenter = getPresenter<CheckoutPresenterImpl, CheckoutView>()
        mPresenter.onUiReady(this)

    }

    override fun showOrderList(orderList: List<FoodItemVO>) {
        mAdapter.setNewData(orderList as MutableList<FoodItemVO>)
    }

    override fun showCalculationCharge() {
        //tv_totalamount
    }
}