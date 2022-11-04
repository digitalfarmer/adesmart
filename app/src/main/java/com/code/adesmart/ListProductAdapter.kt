package com.code.adesmart

import android.view.LayoutInflater
import android.view.ScrollCaptureCallback
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListProductAdapter(val listProduct:ArrayList<Product>):
    RecyclerView.Adapter<ListProductAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var tvName:TextView = itemView.findViewById(R.id.tv_item_name)
        var tvDescription:TextView = itemView.findViewById(R.id.tv_item_description)
        var imgPhoto:ImageView = itemView.findViewById(R.id.img_item_photo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.item_row_product, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        val product = listProduct[position]

        Glide.with(holder.itemView.context)
//            .load(product.photo)
            .load(listProduct[position].photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvName.text= product.name
        holder.tvDescription.text= product.description

        holder.itemView.setOnClickListener {

            onItemClickCallback.onItemClicked(listProduct[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listProduct.size
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Product)

    }

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
}
