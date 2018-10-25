package io.indrian16.getrestapi.ui.main.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import io.indrian16.getrestapi.R
import io.indrian16.getrestapi.ui.main.presenter.MainPresenterImpl
import io.indrian16.getrestapi.util.CommonUtil
import io.indrian16.getrestapi.util.setupActionBar
import io.indrian16.getrestapi.util.setupViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter = MainPresenterImpl(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        presenter.checkInternetStatus()
    }

    private fun initView() {

        setupActionBar(R.id.toolbar) {

            supportActionBar?.title = resources.getString(R.string.app_name)
        }
        setupViewPager(R.id.view_pager, R.id.tab_layout)
    }

    override fun showOnlineStatus() {

        CommonUtil.showOnlineStatus(main_view, baseContext).show()
    }

    override fun showOfflineStatus() {

        CommonUtil.showOfflineStatus(main_view, baseContext).show()
    }

    override fun showError(error: Throwable) {

        Toast.makeText(baseContext, error.message, Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unSubscribe()
    }
}
