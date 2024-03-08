package com.example.task.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.task.databinding.FragmentProductDetailesBinding
import com.example.task.viewModels.ProductDetailesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailesFragment : Fragment() {

    private val viewModel: ProductDetailesViewModel by viewModels()
    private lateinit var binding : FragmentProductDetailesBinding
    private val args:ProductDetailesFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        binding.product = args.product
        return binding.root
    }


}