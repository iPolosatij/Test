package space.digitallab.kotlinretrofitpicassospotsdialog.Adapter

import Top
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*
import space.digitallab.testappforarview.R


class GameListAdapter(private val context: Context,
                      private val listContains: List<Top>):RecyclerView.Adapter<GameListAdapter.AlbumContentHolder>() {

    class AlbumContentHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.image
        val name: TextView = itemView.name
        val chanelCount: TextView = itemView.chanel_count
        val viewersCount: TextView = itemView.viewers_count


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumContentHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return AlbumContentHolder(itemView)
    }

    override fun getItemCount() = listContains.size

    override fun onBindViewHolder(holder: AlbumContentHolder, position: Int) {


        Picasso.get().load(listContains[position].game.logo.small).into(holder.image)
        holder.name.text = listContains[position].game.name
        holder.chanelCount.text = listContains[position].channels.toString()
        holder.viewersCount.text = listContains[position].viewers.toString()
    }

}