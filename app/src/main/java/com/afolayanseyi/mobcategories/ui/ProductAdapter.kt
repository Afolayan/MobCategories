package com.afolayanseyi.mobcategories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.data.model.Product


class ProductAdapter(private val productsList: List<Product>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(productsList[position])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var categoryName: TextView = itemView.findViewById(R.id.name)

        fun bind(product: Product) {
            categoryName.text = product.name
        }
    }
}
