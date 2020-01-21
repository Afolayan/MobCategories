package com.afolayanseyi.mobcategories.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.afolayanseyi.mobcategories.R
import com.afolayanseyi.mobcategories.data.ProductClickListener
import com.afolayanseyi.mobcategories.data.adapter.MobCategoryAdapter
import com.afolayanseyi.mobcategories.data.model.Product
import com.afolayanseyi.mobcategories.data.model.Result
import com.afolayanseyi.mobcategories.databinding.FragmentProductListBinding
import com.afolayanseyi.mobcategories.ui.ProductListViewModel
import com.afolayanseyi.mobcategories.utils.PRODUCT_ARGS_EXTRA
import com.google.android.material.snackbar.Snackbar
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProductListFragment : Fragment(), ProductClickListener {
    private val productListViewModel: ProductListViewModel by viewModel()
    private lateinit var fragmentProductListBinding: FragmentProductListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentProductListBinding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_product_list, container, false)

        fragmentProductListBinding.viewModel = productListViewModel

        productListViewModel.mobCategoriesLiveData.observe(this, Observer { result ->
            when (result) {
                is Result.Loading -> {
                    showProgress()
                }
                is Result.Success -> {
                    hideProgress()

                    fragmentProductListBinding.recycler.apply {
                        val categoriesList = result.data
                        adapter =
                            MobCategoryAdapter(
                                categoriesList, this@ProductListFragment
                            )
                        layoutManager = LinearLayoutManager(requireContext())
                    }
                }
                is Result.Error -> {
                    hideProgress()
                    showErrorMessage(result.exception)
                }
            }

        })

        return fragmentProductListBinding.root
    }

    private fun showErrorMessage(exception: Exception) {

        val message = if (exception.message.isNullOrEmpty()) {
            getString(R.string.error_message)
        } else {
            exception.message!!
        }

        val snackBar =
            Snackbar.make(fragmentProductListBinding.recycler, message, Snackbar.LENGTH_LONG)
        snackBar.setAction(getString(R.string.retry_text)) {
            productListViewModel.getMobCategories()
        }
        snackBar.show()
    }


    private fun hideProgress() {
        fragmentProductListBinding.progressBar.visibility = View.GONE
    }

    private fun showProgress() {
        fragmentProductListBinding.progressBar.visibility = View.VISIBLE
    }

    override fun onProductClick(product: Product) {

        val bundle = Bundle().apply {
            putParcelable(PRODUCT_ARGS_EXTRA, product)
        }

        findNavController().navigate(
            R.id.action_productListFragment_to_productDetailFragment,
            bundle
        )
    }


}
