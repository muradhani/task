package com.example.data.local.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.Dao.ProductDao
import com.example.domain.models.product.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao():ProductDao
}