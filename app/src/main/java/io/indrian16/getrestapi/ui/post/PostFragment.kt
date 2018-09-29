package io.indrian16.getrestapi.ui.post


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast

import io.indrian16.getrestapi.R
import io.indrian16.getrestapi.model.Post
import io.indrian16.getrestapi.ui.post.adapter.PostAdapter

class PostFragment : PostContract.View, Fragment() {

    override val presenter = PostPresenter(this)

    override fun onResume() {
        super.onResume()
        presenter.start()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val root = inflater.inflate(R.layout.fragment_post, container, false)

        with(root) {

            recyclerView = findViewById(R.id.post_recycler_view)
            progressBar = findViewById(R.id.post_progressbar)
        }

        initView()
        return root
    }

    private fun initView() {

        recyclerView.layoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
        recyclerView.adapter = PostAdapter()
    }

    override fun showLoading() {

        progressBar.visibility = View.VISIBLE
    }

    override fun hideLoading() {

        progressBar.visibility = View.GONE
    }

    override fun updatePosts(postList: List<Post>) {

        (recyclerView.adapter as PostAdapter).addPost(postList)
    }

    override fun showError(throwable: Throwable) {

        Toast.makeText(context, throwable.message, Toast.LENGTH_LONG).show()
    }

    override fun onDetach() {
        super.onDetach()
        presenter.unSubscribe()
    }
}
