package com.example.task.di

import android.content.Context
import com.example.data.mapper.ProductMapper
import com.example.data.remote.ApiService
import com.example.data.repo.ProductsRepoImpl
import com.example.domain.repoInterface.ProductsRepoInterface
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideProductRepository(apiService: ApiService,mapper: ProductMapper):ProductsRepoInterface{
        return ProductsRepoImpl(apiService,mapper)
    }

    @Provides
    fun provideProductMapper():ProductMapper{
        return ProductMapper()
    }


    @Provides
    fun provideApiservice(retrofit: Retrofit):ApiService{
        return retrofit.create(ApiService::class.java)
    }
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient):Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://fakestoreapi.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun okhttp(): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()
    }
}