package com.example.data.repo

import com.example.data.local.Dao.ProductDao
import com.example.data.mapper.ProductMapper
import com.example.data.remote.ApiService
import com.example.data.utils.ConnectivityRepository
import com.example.domain.entities.Product
import com.example.domain.models.States.State
import com.example.domain.repoInterface.ProductsRepoInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ProductsRepoImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: ProductMapper,
    private val checkConnection: ConnectivityRepository,
    private val productDao: ProductDao
):ProductsRepoInterface{
    override suspend fun getProducts() : Flow<State<List<Product>>> {
       return flow {
           emit(State.Loading)
           try {
               checkConnection.isConnected.collect{
                   if (it){
                       var result = apiService.getProducts()
                       if (result.isSuccessful){
                           var newlist = result.body()!!.map { mapper.map(it) }
                           productDao.deleteAll()
                           productDao.insertProducts(newlist)
                           emit(State.Success(newlist))
                       }
                   }else{
                       var list = productDao.getAllProdcuts()
                       if (list.isNotEmpty()){
                           emit(State.Success(list))
                       }else{
                           emit(State.NoDataCached("no internet Connection"))
                       }
                   }
               }

           }catch (e:Exception){
                emit(State.Error(e.message.toString()))
           }
       }
    }
}