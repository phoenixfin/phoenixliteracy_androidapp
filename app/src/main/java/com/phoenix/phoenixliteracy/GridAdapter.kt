package com.phoenix.phoenixliteracy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView as RV
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class GridAdapter(private val listBooklet: ArrayList<Booklet>) : RV.Adapter<GridAdapter.GridViewHolder>() {
    interface OnItemClickCallback {
        fun onItemClicked(data: Booklet)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): GridViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.grid_view, viewGroup, false
        )
        return GridViewHolder(view)
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
            .load(listBooklet[position].photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(
                listBooklet[holder.adapterPosition]
            )
        }
    }

    override fun getItemCount(): Int {
        return listBooklet.size
    }

    inner class GridViewHolder(itemView: View) : RV.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }
}