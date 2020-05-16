package com.phoenix.phoenixliteracy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListAdapter(private val listBooklet: ArrayList<Booklet>) : RecyclerView.Adapter<ListAdapter.ListViewHolder>() {
    interface OnItemClickCallback {
        fun onItemClicked(data: Booklet)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.row_view, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val booklet = listBooklet[position]
        Glide.with(holder.itemView.context)
            .load(booklet.photo)
            .apply(RequestOptions().override(350, 550))
            .into(holder.imgPhoto)
        holder.tvName.text = booklet.title
        holder.tvDetail.text = booklet.detail
        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listBooklet[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listBooklet.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDetail: TextView = itemView.findViewById(R.id.tv_item_detail)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}