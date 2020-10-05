package br.com.netshoesgistchallenge.ui.home.presenter

import android.content.Context
import br.com.netshoesgistchallenge.entities.Gist

class FavoriteContract {

    interface View {
        fun showList(gists: ArrayList<Gist>)
        fun showMessage(message: String)
        fun getContext(): Context
    }

    interface UserActionsListener {
        fun loadDataStorage()
    }
}