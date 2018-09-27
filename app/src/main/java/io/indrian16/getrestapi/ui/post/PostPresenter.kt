package io.indrian16.getrestapi.ui.post

import io.indrian16.getrestapi.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PostPresenter(private val postView: PostContract.View) : PostContract.Presenter {

    private var subscription: Disposable? = null

    override fun loadPost() {

        subscription = ApiService.create()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { postView.showLoading() }
                .doOnTerminate { postView.hideLoading() }
                .subscribe(

                        { postList -> postView.updatePosts(postList) },
                        { throwable -> postView.showError(throwable) }
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