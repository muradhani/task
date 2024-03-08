package com.example.task.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.States.State
import com.example.domain.entities.Product
import com.example.domain.useCases.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {
    private val _products = MutableLiveData<State<List<Product?>>>()
    val products: LiveData<State<List<Product?>>> = _products
  init {
      viewModelScope.launch(Dispatchers.IO) {
          getProductsUseCase().collect {
              withContext(Dispatchers.Main) {
                  _products.postValue(it)
              }
          }
      }
  }

}