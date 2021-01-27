package space.digitallab.testappforarview.adapters

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
import space.digitallab.testappforarview.database.DB


class OffLineAdapter (private val context: Context,
                      private val listContains: List<DB>): RecyclerView.Adapter<OffLineAdapter.ContentHolder>() {

    class ContentHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.image
        val name: TextView = itemView.name
        val chanelCount: TextView = itemView.chanel_count
        val viewersCount: TextView = itemView.viewers_count


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ContentHolder(itemView)
    }

    override fun getItemCount() = listContains.size

    override fun onBindViewHolder(holder: ContentHolder, position: Int) {


        Picasso.get().load(R.drawable.ic_launcher_background).into(holder.image)
        holder.name.text = listContains[position].name
        holder.chanelCount.text = listContains[position].chanel
        holder.viewersCount.text = listContains[position].viawers
    }
}