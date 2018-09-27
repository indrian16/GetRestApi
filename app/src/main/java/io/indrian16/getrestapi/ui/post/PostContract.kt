package io.indrian16.getrestapi.ui.post

import io.indrian16.getrestapi.BasePresenter
import io.indrian16.getrestapi.BaseView
import io.indrian16.getrestapi.model.Post

interface PostContract {

    interface Presenter : BasePresenter {

        fun loadPost()

        fun unSubscribe()
    }

    interface View : BaseView <Presenter> {

        fun showLoading()

        fun hideLoading()

        fun updatePosts(postList: List<Post>)

        fun showError(throwable: Throwable)
    }
}