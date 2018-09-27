package io.indrian16.getrestapi.ui.user

import io.indrian16.getrestapi.BasePresenter
import io.indrian16.getrestapi.BaseView
import io.indrian16.getrestapi.model.User

interface UserContract {

    interface Presenter : BasePresenter {

        fun loadUser()

        fun unSubscribe()
    }

    interface View : BaseView<Presenter> {

        fun showLoading()

        fun hideLoading()

        fun updatePosts(userList: List<User>)

        fun showError(throwable: Throwable)
    }
}