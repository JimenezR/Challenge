package com.platform.challenge.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.platform.challenge.data.configuration.remote.retrofit.dto.response.toProductUI
import com.platform.challenge.ui.model.ProductUI
import com.platform.domain.core.Result
import com.platform.domain.models.Product
import com.platform.domain.usecase.ProductUseCase
import com.platform.domain.usecase.SaveProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor(
    private val saveProductUseCase: SaveProductUseCase,
    var productUseCase: ProductUseCase
) : ViewModel() {

    private val _productList = MutableLiveData<ArrayList<ProductUI>>()
    val productList: LiveData<ArrayList<ProductUI>> get() = _productList

    val isVisible = MutableLiveData<Boolean>()


    fun setIsVisible(visible: Boolean) {
        isVisible.value = visible
    }

    fun getProducts() {
        viewModelScope.launch {
            when (val result = productUseCase()) {
                is Result.Success -> {
                    val products = ArrayList<ProductUI>()
                    setProducts(result.data)
                    result.data.map {
                        products.add(it.toProductUI())
                    }
                    _productList.value = products
                }

                is Result.Error -> {
                    //TODO: Handle error
                }
            }
        }
    }

    private fun setProducts(productList: List<Product>) {
        viewModelScope.launch {
            saveProductUseCase(productList)
        }
    }

}