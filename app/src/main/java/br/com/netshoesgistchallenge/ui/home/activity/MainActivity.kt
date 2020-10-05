package br.com.netshoesgistchallenge.ui.home.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuItemCompat
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.netshoesgistchallenge.R
import br.com.netshoesgistchallenge.entities.Gist
import br.com.netshoesgistchallenge.ui.favorite.FavoriteListActivity
import br.com.netshoesgistchallenge.ui.home.adapter.GistAdapter
import br.com.netshoesgistchallenge.ui.home.presenter.MainContract
import br.com.netshoesgistchallenge.ui.home.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.View {

    var presenter: MainContract.UserActionsListener? = null

    override fun getContext(): Context = this
    var listGit = ArrayList<Gist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this)

        getActionBar()?.setTitle("Usuários")
        getSupportActionBar()?.setTitle("Usuários")

        recyclerViewGist.layoutManager = LinearLayoutManager(this)
        recyclerViewGist.adapter =
            GistAdapter(
                listGit,
                this
            )

        presenter?.loadDataStorage()
        presenter?.getOwner()
    }

    private fun search(query: String) {
        var filtro = ArrayList<Gist>()
        listGit?.filter { it?.owner?.login!!.contains(query, true) }?.map {
            filtro.add(it)
        }
        (recyclerViewGist.adapter as GistAdapter).gist = filtro
        recyclerViewGist.adapter!!.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_item, menu)
        val menuItem = menu!!.findItem(R.id.action_search)
        if (menuItem != null) {
            val searchView = menuItem.actionView as SearchView

            val searchItem: MenuItem = menu.findItem(R.id.action_search)
            MenuItemCompat.setOnActionExpandListener(
                searchItem,
                object : MenuItemCompat.OnActionExpandListener {
                    override fun onMenuItemActionExpand(item: MenuItem?): Boolean {
                        return true
                    }

                    override fun onMenuItemActionCollapse(item: MenuItem?): Boolean {
                        (recyclerViewGist.adapter as GistAdapter).gist = listGit
                        recyclerViewGist.adapter!!.notifyDataSetChanged()
                        return true
                    }
                })


            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    search(query!!)
                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    return true
                }
            })

        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun showList(gists: ArrayList<Gist>) {
        this.listGit = gists
        runOnUiThread {
            (recyclerViewGist.adapter as GistAdapter).gist = gists
            recyclerViewGist.adapter!!.notifyDataSetChanged()
        }
    }

    override fun showMessage(message: String) {
        runOnUiThread {
            Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
        }
    }

    private fun openStatistics() {
        val intent = Intent(this, FavoriteListActivity::class.java)
        startActivity(intent)
    }

    override
    fun onOptionsItemSelected(item: MenuItem): Boolean {
        openStatistics()
        return super.onOptionsItemSelected(item)
    }
}