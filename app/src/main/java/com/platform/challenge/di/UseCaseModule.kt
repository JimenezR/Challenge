package com.platform.challenge.di

import com.platform.domain.repositories.ProductRepository
import com.platform.domain.usecase.GetProductUseCase
import com.platform.domain.usecase.ProductUseCase
import com.platform.domain.usecase.SaveProductUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class UseCaseModule {

    @Singleton
    @Provides
    fun provideSetProductUseCase(
        productRepository: ProductRepository
    ): SaveProductUseCase = SaveProductUseCase(productRepository)

    @Singleton
    @Provides
    fun provideProductsUseCase(
        productRepository: ProductRepository
    ): ProductUseCase {
        return ProductUseCase(productRepository)
    }

    @Singleton
    @Provides
    fun provideGetProductUseCase(
        productRepository: ProductRepository
    ): GetProductUseCase {
        return GetProductUseCase(productRepository)
    }

}