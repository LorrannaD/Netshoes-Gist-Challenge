package br.com.netshoesgistchallenge.ui.favorite

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.netshoesgistchallenge.R
import br.com.netshoesgistchallenge.entities.Gist
import br.com.netshoesgistchallenge.ui.home.adapter.GistAdapter
import br.com.netshoesgistchallenge.ui.home.presenter.FavoriteContract
import br.com.netshoesgistchallenge.ui.home.presenter.FavoritePresenter
import kotlinx.android.synthetic.main.activity_favorite_list.*
import kotlinx.android.synthetic.main.activity_main.*

class FavoriteListActivity : AppCompatActivity(), FavoriteContract.View {

    var presenter: FavoriteContract.UserActionsListener? = null
    override fun getContext(): Context = this
    var listGit = ArrayList<Gist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorite_list)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        presenter = FavoritePresenter(this)

        recyclerViewFavorite.layoutManager = LinearLayoutManager(this)
        recyclerViewFavorite.adapter = GistAdapter(listGit, this)

        presenter?.loadDataStorage()

        getActionBar()?.setTitle("Favoritos")
        getSupportActionBar()?.setTitle("Favoritos")
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun showList(gists: ArrayList<Gist>) {
        this.listGit = gists
        runOnUiThread {
            (recyclerViewFavorite.adapter as GistAdapter).gist = gists
            recyclerViewFavorite.adapter!!.notifyDataSetChanged()
        }
    }

    override fun showMessage(message: String) {
        runOnUiThread {
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }

}