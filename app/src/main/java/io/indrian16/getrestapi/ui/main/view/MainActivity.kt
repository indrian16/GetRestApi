package io.indrian16.getrestapi.ui.main.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.indrian16.getrestapi.R
import io.indrian16.getrestapi.util.setupActionBar
import io.indrian16.getrestapi.util.setupViewPager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {

        setupActionBar(R.id.toolbar) {

            supportActionBar?.title = resources.getString(R.string.app_name)
        }
        setupViewPager(R.id.view_pager, R.id.tab_layout)
    }

}
