package com.afolayanseyi.mobcategories.data.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afolayanseyi.mobcategories.data.ProductClickListener
import com.afolayanseyi.mobcategories.data.model.MobCategory
import com.afolayanseyi.mobcategories.databinding.LayoutCategoriesListBinding


class MobCategoryAdapter(private val categoriesList: List<MobCategory>,
                         private val productClickListener: ProductClickListener) :
    RecyclerView.Adapter<MobCategoryAdapter.CategoryViewHolder>() {

    override fun getItemCount(): Int = categoriesList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBinding = LayoutCategoriesListBinding.inflate(layoutInflater, parent, false)

        return CategoryViewHolder(
            itemBinding
        )
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
        holder.bind(categoriesList[position])
        holder.productClickListener = productClickListener
    }

    class CategoryViewHolder(private val itemBinding: LayoutCategoriesListBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        lateinit var  productClickListener: ProductClickListener

        fun bind(mobCategory: MobCategory) {
            itemBinding.category = mobCategory

            val linearLayoutManager =
                LinearLayoutManager(itemBinding.root.context,
                    LinearLayoutManager.VERTICAL, false)
            itemBinding.productsRecyclerView.layoutManager = linearLayoutManager
            val productAdapter =
                ProductAdapter(
                    mobCategory.products
                ) { product ->
                    android.util.Log.e("CategoryViewHolder", "ProductAdapter")
                    productClickListener.onProductClick(product)
                }
            itemBinding.productsRecyclerView.adapter = productAdapter
        }

    }
}