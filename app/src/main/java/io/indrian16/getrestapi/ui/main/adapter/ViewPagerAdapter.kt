package io.indrian16.getrestapi.ui.main.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import io.indrian16.getrestapi.ui.post.PostFragment
import io.indrian16.getrestapi.ui.todo.TodoFragment
import io.indrian16.getrestapi.ui.user.UserFragment
import io.indrian16.getrestapi.util.AppConstant

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when (position) {

            0 -> PostFragment()
            1 -> TodoFragment()
            2 -> UserFragment()

            else -> PostFragment()
        }
    }

    override fun getCount(): Int = AppConstant.NUM_PAGE

    override fun getPageTitle(position: Int): CharSequence? {

        return when(position) {

            0 -> AppConstant.Fragment_TITLE_0
            1 -> AppConstant.Fragment_TITLE_1
            2 -> AppConstant.Fragment_TITLE_2

            else -> AppConstant.Fragment_TITLE_0
        }
    }
}