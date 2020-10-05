package br.com.netshoesgistchallenge.ui.home.adapter

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.netshoesgistchallenge.R
import br.com.netshoesgistchallenge.database.GistRepository
import br.com.netshoesgistchallenge.entities.Gist
import br.com.netshoesgistchallenge.ui.details.DetailGistActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.layout_gist.view.*


class GistAdapter(var gist: List<Gist>, val context : Context) :
    RecyclerView.Adapter<GistAdapter.GistViewHolder>() {


    class GistViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val mvGist = view.imagview_owner

        fun bindItems(gist: Gist){
            itemView.txtview_ownername.text = gist.owner?.login
            Picasso.get().load(gist.owner?.avatarUrl).into(mvGist)

            if(gist.isFavorites!!){
                itemView.favorite_btn.setImageResource(R.drawable.ic_favorite_red)
            }else{
                itemView.favorite_btn.setImageResource(R.drawable.ic_favorite_shadow)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistViewHolder {
        return GistViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_gist, parent, false)
        )
    }

    override fun onBindViewHolder(holder: GistViewHolder, position: Int) {

        var item = gist.get(position)

        holder.bindItems(item)

        holder.itemView.favorite_btn.setOnClickListener{
            item.isFavorites = !item.isFavorites!!
            Thread{
                GistRepository(context).update(item)
                (context as Activity).runOnUiThread{
                    notifyDataSetChanged()
                }
            }.start()
        }

        holder.itemView.setOnClickListener {
            var ownerResponse = gist.get(position)
            var intent = Intent(context, DetailGistActivity::class.java)
            intent.putExtra("myKey", ownerResponse)
            context.startActivity(intent)
         }

    }

    override fun getItemCount() = gist.size

   }

