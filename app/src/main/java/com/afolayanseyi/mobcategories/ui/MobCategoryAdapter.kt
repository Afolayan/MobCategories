package com.afolayanseyi.mobcategories.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.data.model.MobCategory

class MobCategoryAdapter(val categoriesList: List<MobCategory>) : RecyclerView.Adapter<MobCategoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_category_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return categoriesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.categoryName.text = categoriesList[position].name
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var categoryName: TextView = itemView.findViewById(R.id.category_name)
    }
}
