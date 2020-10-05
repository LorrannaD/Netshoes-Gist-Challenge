package br.com.netshoesgistchallenge.ui.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.netshoesgistchallenge.R
import br.com.netshoesgistchallenge.entities.Gist


import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_gist.*

class DetailGistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_gist)

        var gistResponse: Gist
        gistResponse = intent.getSerializableExtra("myKey") as Gist
        if (gistResponse != null) {
            textview_ownername_detail.text = "Login: " + gistResponse.owner?.login
            textview_html_url_detail.text = "GitHub: " + gistResponse.owner?.htmlUrl
            textview_description_detail.text = "Descrição: " + gistResponse.description


            var photo = gistResponse.owner?.avatarUrl
            Picasso.get().load(photo)
                .placeholder(R.drawable.ic_baseline_replay_24)
                .error(R.drawable.ic_baseline_error_24)
                .into(imageView_detail)

            getActionBar()?.setTitle("Detalhes do Usuário")
            getSupportActionBar()?.setTitle("Detalhes do Usuário")
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)

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
}