package com.example.domain.repoInterface

import com.example.domain.entities.Product
import com.example.domain.models.States.State
import kotlinx.coroutines.flow.Flow

interface ProductsRepoInterface {
    suspend fun getProducts(): Flow<State<List<Product>>>
}