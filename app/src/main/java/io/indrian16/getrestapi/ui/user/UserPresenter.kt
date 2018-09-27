package io.indrian16.getrestapi.ui.user

import io.indrian16.getrestapi.network.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class UserPresenter(private val userView: UserContract.View) : UserContract.Presenter {

    private var subscription: Disposable? = null

    override fun loadUser() {

        subscription = ApiService.create()
                .getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { userView.showLoading() }
                .doOnTerminate { userView.hideLoading() }
                .subscribe(

                        {userList -> userView.updatePosts(userList)},
                        {throwable -> userView.showError(throwable)}
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

        loadUser()
    }
}