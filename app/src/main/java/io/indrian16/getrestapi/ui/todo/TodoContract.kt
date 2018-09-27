package io.indrian16.getrestapi.ui.todo

import io.indrian16.getrestapi.BasePresenter
import io.indrian16.getrestapi.BaseView
import io.indrian16.getrestapi.model.Todo

interface TodoContract {

    interface Presenter : BasePresenter {

        fun loadPost()

        fun unSubscribe()
    }

    interface View : BaseView<Presenter> {

        fun showLoading()

        fun hideLoading()

        fun updatePosts(todoList: List<Todo>)

        fun showError(throwable: Throwable)
    }
}