package io.indrian16.getrestapi.base

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.indrian16.getrestapi.R
import io.indrian16.getrestapi.util.setupActionBar
import io.indrian16.getrestapi.util.setupViewPager

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)

        initView()
    }

    private fun initView() {

        setupActionBar(R.id.toolbar) {

            supportActionBar?.title = resources.getString(R.string.app_name)
        }
        setupViewPager(R.id.view_pager, R.id.tab_layout)
    }

}
