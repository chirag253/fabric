package com.parveendala.productscanner.ui.discover

import androidx.lifecycle.ViewModel
import com.parveendala.productscanner.ui.discover.data.repo.ProductRepoImpl

class DiscoverViewModel : ViewModel() {
    private val productRepo = ProductRepoImpl()
    fun getProduct(productId: String) = productRepo.getProduct(productId)
}