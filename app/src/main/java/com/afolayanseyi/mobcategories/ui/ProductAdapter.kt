package com.afolayanseyi.mobcategories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afolayanseyi.mobcategories.data.model.Product
import com.afolayanseyi.mobcategories.databinding.LayoutSingleProductItemBinding


class ProductAdapter(private val productsList: List<Product>) :
    RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = LayoutSingleProductItemBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return productsList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = productsList[position]
        holder.apply {
            bind(createOnClickListener(product), product)
        }

    }

    private fun createOnClickListener(product: Product): View.OnClickListener {
        return View.OnClickListener {
            //switch navigation here
        }
    }

    class ViewHolder(private val itemBinding: LayoutSingleProductItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(listener: View.OnClickListener, product: Product) {
            itemBinding.clickListener = listener
            itemBinding.product = product
        }
    }
}
