package br.com.netshoesgistchallenge.ui.home.presenter

import br.com.netshoesgistchallenge.data.network.GistApi
import br.com.netshoesgistchallenge.data.network.GistResponse
import br.com.netshoesgistchallenge.database.GistRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainPresenter(var bookDetalheView: MainContract.View) : MainContract.UserActionsListener {

    override fun loadDataStorage() {
        Thread {
            var listGit = GistRepository(bookDetalheView.getContext()).fetchGists()
            bookDetalheView.showList(listGit)
        }.start()
    }


    override fun getOwner() {
        GistApi().getOwner()?.enqueue(object : Callback<List<GistResponse>> {
            override fun onFailure(call: Call<List<GistResponse>>, t: Throwable) {
                bookDetalheView.showMessage(t.message!!)
            }

            override fun onResponse(
                call: Call<List<GistResponse>>,
                response: Response<List<GistResponse>>
            ) {
                val listresponse = response.body()
                listresponse?.map {
                    var item = it.toGist()
                    GistRepository(bookDetalheView.getContext()).store(item)
                }

                loadDataStorage()

            }
        })
    }

}