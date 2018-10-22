package io.indrian16.getrestapi.network

import io.indrian16.getrestapi.model.Post
import io.indrian16.getrestapi.model.Todo
import io.indrian16.getrestapi.model.User
import io.indrian16.getrestapi.util.AppConstant
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("/posts")
    fun getPosts(): Observable<List<Post>>

    @GET("/todos")
    fun getTodos(): Observable<List<Todo>>

    @GET("/users")
    fun getUsers(): Observable<List<User>>

    companion object {

        fun create(): ApiService {

            val retrofit = Retrofit.Builder()
                    .baseUrl(AppConstant.BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(MoshiConverterFactory.create())
                    .build()

            return retrofit.create(ApiService::class.java)
        }
    }
}