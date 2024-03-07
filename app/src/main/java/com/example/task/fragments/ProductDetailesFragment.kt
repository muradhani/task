package com.example.task.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.task.R
import com.example.task.databinding.FragmentProductDetailesBinding
import com.example.task.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailesFragment : Fragment() {

    private val viewModel: ProductDetailesViewModel by viewModels()
    private lateinit var binding : FragmentProductDetailesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductDetailesBinding.inflate(inflater)
        binding.lifecycleOwner = this
        return binding.root
    }

}