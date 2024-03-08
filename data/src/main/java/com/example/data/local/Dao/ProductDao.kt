package com.example.data.local.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.entities.Product
@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProducts(product: List<Product>)

    @Query("SELECT * FROM product")
    suspend fun getAllProdcuts():List<Product>

    @Query("DELETE FROM product")
    fun deleteAll()
}