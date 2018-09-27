package io.indrian16.getrestapi.ui.todo

import io.indrian16.getrestapi.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class TodoPresenter(private val todoView: TodoContract.View) : TodoContract.Presenter {

    private var subscription: Disposable? = null

    override fun loadPost() {

        subscription = ApiService.create()
                .getTodos()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { todoView.showLoading() }
                .doOnTerminate { todoView.hideLoading() }
                .subscribe(

                        {todoList -> todoView.updatePosts(todoList)},
                        {throwable -> todoView.showError(throwable)}
                )
    }

    private fun safelyDispose(disposable: Disposable?) {

        if (disposable != null && disposable.isDisposed) {

            disposable.dispose()
        }
    }

    override fun unSubscribe() {

        safelyDispose(subscription)
    }

    override fun start() {

        loadPost()
    }
}