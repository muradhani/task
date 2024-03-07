package com.example.task.fragments

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.States.State
import com.example.domain.models.product.Product
import com.example.domain.useCases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
): ViewModel() {
    private val _products = MutableStateFlow<State<List<Product>>>(State.Loading)
    val products : StateFlow<State<List<Product>>> = _products
   init {
       viewModelScope.launch(Dispatchers.IO) {
           getProductsUseCase().collect{
               withContext(Dispatchers.Main){
                    if (it is State.Success){
                        _products.value = it
                    }
               }
           }
       }
   }
}