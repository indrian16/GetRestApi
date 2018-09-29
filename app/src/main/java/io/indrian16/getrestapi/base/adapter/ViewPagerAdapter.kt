package io.indrian16.getrestapi.base.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import io.indrian16.getrestapi.ui.post.PostFragment
import io.indrian16.getrestapi.ui.todo.TodoFragment
import io.indrian16.getrestapi.ui.user.UserFragment
import io.indrian16.getrestapi.util.Constant.Companion.Fragment_TITLE_0
import io.indrian16.getrestapi.util.Constant.Companion.Fragment_TITLE_1
import io.indrian16.getrestapi.util.Constant.Companion.Fragment_TITLE_2
import io.indrian16.getrestapi.util.Constant.Companion.NUM_PAGE

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when (position) {

            0 -> PostFragment()
            1 -> TodoFragment()
            2 -> UserFragment()

            else -> PostFragment()
        }
    }

    override fun getCount(): Int = NUM_PAGE

    override fun getPageTitle(position: Int): CharSequence? {

        return when(position) {

            0 -> Fragment_TITLE_0
            1 -> Fragment_TITLE_1
            2 -> Fragment_TITLE_2

            else -> Fragment_TITLE_0
        }
    }
}