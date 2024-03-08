package com.example.data.local.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.local.Dao.ProductDao
import com.example.domain.entities.Product

@Database(entities = [Product::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao():ProductDao
}