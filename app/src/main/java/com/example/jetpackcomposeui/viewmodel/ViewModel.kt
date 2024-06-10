package com.example.jetpackcomposeui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeui.model.ProductItem
import com.example.jetpackcomposeui.network.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(application: Application, private val getUseCase: UseCase) :
    AndroidViewModel(application) {
    private val _products = MutableStateFlow(emptyList<ProductItem>())
    val products: StateFlow<List<ProductItem>> get() = _products

    init {
        getProducts()
    }

    private fun getProducts() {
        viewModelScope.launch {
            try {
                val products = getUseCase()
                _products.value = products
            } catch (_: Exception) {
            }
        }
    }
}