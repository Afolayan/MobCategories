package com.afolayanseyi.mobcategories.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.data.adapter.MobCategoryAdapter
import com.afolayanseyi.mobcategories.data.model.Result
import com.afolayanseyi.mobcategories.databinding.FragmentProductListBinding
import com.afolayanseyi.mobcategories.ui.ProductListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductListFragment : Fragment() {
    private val productListViewModel: ProductListViewModel by viewModel()
    private lateinit var fragmentProductListBinding: FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductListBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_product_list, container, false)

        fragmentProductListBinding.viewModel = productListViewModel

        if (savedInstanceState == null) productListViewModel.getMobCategories()
        productListViewModel.mobCategoriesLiveData.observe(this, Observer { result ->
            when(result) {
                is Result.Loading -> {
                    showProgress()
                }
                is Result.Success -> {
                    hideProgress()

                    fragmentProductListBinding.recycler.apply {
                        val categoriesList = result.data
                        adapter =
                            MobCategoryAdapter(
                                categoriesList
                            )
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
                is Result.Error -> {
                    hideProgress()
                }
            }

        })

        return fragmentProductListBinding.root
    }

    private fun hideProgress() {
        fragmentProductListBinding.progressBar.visibility = View.GONE
    }

    private fun showProgress() {
        fragmentProductListBinding.progressBar.visibility = View.VISIBLE
    }


}
