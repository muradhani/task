package com.example.data.local.Dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.dto.ProductsResponse
import com.example.domain.models.product.Product

interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(product: List<ProductsResponse>)

    @Query("SELECT * FROM product")
    suspend fun getAllProdcuts():List<Product>
}