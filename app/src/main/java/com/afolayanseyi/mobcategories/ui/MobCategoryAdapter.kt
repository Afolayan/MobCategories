package com.afolayanseyi.mobcategories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.data.model.MobCategory


class MobCategoryAdapter(private val categoriesList: List<MobCategory>) :
    RecyclerView.Adapter<MobCategoryAdapter.CategoryViewHolder>() {

    override fun getItemCount(): Int = categoriesList.size

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_categories_list, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CategoryViewHolder,
        position: Int
    ) {
        holder.bind(categoriesList[position])
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val sectionName: TextView =
            itemView.findViewById(R.id.category_item_text_view)
        private val itemRecyclerView: RecyclerView =
            itemView.findViewById(R.id.products_recycler_view)

        fun bind(mobCategory: MobCategory) {
            sectionName.text = mobCategory.name
            val linearLayoutManager =
                LinearLayoutManager(itemView.context, LinearLayoutManager.VERTICAL, false)
            itemRecyclerView.layoutManager = linearLayoutManager
            val productAdapter = ProductAdapter(mobCategory.products)
            itemRecyclerView.adapter = productAdapter
        }

    }
}