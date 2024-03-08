package com.example.domain.useCases

import com.example.domain.models.States.State
import com.example.domain.entities.Product
import com.example.domain.repoInterface.ProductsRepoInterface
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repo : ProductsRepoInterface
) {
    suspend operator fun invoke(): Flow<State<List<Product>>> {
        return flow {
            repo.getProducts().collect{
                emit(it)
            }
        }
    }
}