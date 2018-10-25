package io.indrian16.getrestapi.ui.post.presenter

import io.indrian16.getrestapi.network.ApiService
import io.indrian16.getrestapi.ui.post.view.PostView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class PostPresenterImpl(private val postView: PostView) : PostPresenter {

    private var subscription: Disposable? = null

    override fun loadPost() {

        subscription = ApiService.create()
                .getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe{postView.showLoading()}
                .doOnTerminate { postView.hideLoading() }
                .subscribe(

                        {postList -> postView.updatePost(postList)},
                        {error -> postView.showError(error)}
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
}