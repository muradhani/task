package com.example.data.repo

import com.example.data.local.Dao.ProductDao
import com.example.data.mapper.ProductMapper
import com.example.data.remote.ApiService
import com.example.domain.models.product.Product
import com.example.domain.models.States.State
import com.example.domain.repoInterface.ProductsRepoInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ProductMapper
):ProductsRepoInterface{
    override suspend fun getProducts() : Flow<State<List<Product>>> {
       return flow {
           emit(State.Loading)
           try {
                var result = apiService.getProducts()
               if (result.isSuccessful){
                   var newlist = result.body()!!.map { mapper.map(it) }
                    emit(State.Success(newlist))
               }
           }catch (e:Exception){
                emit(State.Error(e.message.toString()))
           }
       }
    }
}