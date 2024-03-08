package com.example.task.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.domain.models.States.State
import com.example.domain.entities.Product
import com.example.task.adapters.ProductListnter
import com.example.task.adapters.ProductsRvAdapter
import com.example.task.databinding.FragmentProductsBinding
import com.example.task.viewModels.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsFragment : Fragment() ,ProductListnter{

    private val viewModel: ProductsViewModel by viewModels()
    private lateinit var binding:FragmentProductsBinding
    private lateinit var adapter : ProductsRvAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        adapter = ProductsRvAdapter(emptyList(),this)
        binding.productsRvAdapter = adapter
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeProducts()
    }

    private fun observeProducts() {
        viewModel.products.observe(viewLifecycleOwner, Observer {
            if (it is State.Success){
                adapter.setData(it.toData()!!)
            }
        })
    }

    override fun onProductClicked(product: Product) {
        val action = ProductsFragmentDirections.actionProductsFragmentToProductDetailesFragment(product)
        findNavController().navigate(action)
    }


}