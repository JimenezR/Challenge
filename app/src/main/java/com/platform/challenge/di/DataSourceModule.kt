package com.platform.challenge.di

import com.platform.challenge.data.configuration.local.room.dao.ProductDao
import com.platform.challenge.data.configuration.remote.retrofit.ApiService
import com.platform.challenge.data.datasource.ProductLocalDataSourceImp
import com.platform.challenge.data.datasource.ProductRemoteDataSourceImp
import com.platform.challenge.data.datasource.mapper.ProductEntityToProductMapper
import com.platform.challenge.data.datasource.mapper.ProductToProductEntityMapper
import com.platform.data.product.ProductRepositoryImp
import com.platform.data.product.datasoruce.ProductLocalDataSource
import com.platform.data.product.datasoruce.ProductRemoteDataSource
import com.platform.domain.repositories.ProductRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Provides
    @Singleton
    fun provideProductDataSource(
        productDao: ProductDao,
        productEntityToProductMapper: ProductEntityToProductMapper,
        productToProductEntityMapper: ProductToProductEntityMapper,
    ): ProductLocalDataSource = ProductLocalDataSourceImp(
        productDao,
        productEntityToProductMapper,
        productToProductEntityMapper,
    )

    @Singleton
    @Provides
    fun provideProductsRemoteDataSource(
        apiService: ApiService
    ): ProductRemoteDataSource = ProductRemoteDataSourceImp(
        apiService
    )

    @Provides
    @Singleton
    fun provideProductRepositoryImp(
        productLocalDataSource: ProductLocalDataSource,
        productRemoteDataSource: ProductRemoteDataSource
    ): ProductRepository = ProductRepositoryImp(
        productLocalDataSource,
        productRemoteDataSource
    )

}