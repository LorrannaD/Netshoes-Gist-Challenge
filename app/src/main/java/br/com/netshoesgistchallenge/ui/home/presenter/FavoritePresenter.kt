package br.com.netshoesgistchallenge.ui.home.presenter

import br.com.netshoesgistchallenge.database.GistRepository


class FavoritePresenter(var bookDetalheView: FavoriteContract.View) :
    FavoriteContract.UserActionsListener {


    override fun loadDataStorage() {
        Thread {
            var listGit = GistRepository(bookDetalheView.getContext()).fetchFavorites()
            bookDetalheView.showList(listGit)
        }.start()
    }

}



