package com.example.task.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.domain.models.product.Product
import com.example.task.R
import com.example.task.adapters.ProductListnter
import com.example.task.adapters.ProductsRvAdapter
import com.example.task.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() ,ProductListnter{

    private val viewModel: ProductsViewModel by viewModels()
    private lateinit var binding:FragmentProductsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.productsRvAdapter = ProductsRvAdapter(emptyList(),this)
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onProductClicked(product: Product) {
        val action = ProductsFragmentDirections.actionProductsFragmentToProductDetailesFragment(product)
        findNavController().navigate(action)
    }


}