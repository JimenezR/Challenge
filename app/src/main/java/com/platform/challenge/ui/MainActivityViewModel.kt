package com.platform.challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platform.challenge.data.configuration.remote.retrofit.dto.response.toProductUI
import com.platform.challenge.ui.model.ProductUI
import com.platform.domain.core.Result
import com.platform.domain.models.Product
import com.platform.domain.usecase.GetProductUseCase
import com.platform.domain.usecase.ProductUseCase
import com.platform.domain.usecase.SaveProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val saveProductUseCase: SaveProductUseCase,
    private var productUseCase: ProductUseCase,
    private var getProductUseCase: GetProductUseCase
) : ViewModel() {

    private val _productList = MutableLiveData<ArrayList<ProductUI>>()
    val productList: LiveData<ArrayList<ProductUI>> get() = _productList

    private val _noData = MutableLiveData<Unit>()
    val noData: LiveData<Unit> get() = _noData

    fun getProducts() {
        viewModelScope.launch {
            when (val result = productUseCase()) {
                is Result.Success -> {
                    setProducts(result.data)
                    getProductsDB()
                }

                is Result.Error -> {
                    getProductsDB()
                }
            }
        }
    }

    private fun setProducts(productList: List<Product>) {
        viewModelScope.launch {
            saveProductUseCase(productList)
        }
    }

    private fun getProductsDB() {
        viewModelScope.launch {
            when (val result = getProductUseCase()) {
                is Result.Success -> {
                    val products = ArrayList<ProductUI>()
                    result.data.map {
                        products.add(it.toProductUI())
                    }
                    _productList.value = products
                    if (result.data.isNullOrEmpty()) _noData.value = Unit
                }

                is Result.Error -> {
                    _noData.value = Unit
                }
            }
        }
    }


}