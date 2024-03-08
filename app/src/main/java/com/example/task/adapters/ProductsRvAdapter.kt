package com.example.task.adapters

import com.example.domain.entities.Product
import com.example.task.R
import com.example.task.base.BaseRecyclerViewAdapterAdapter
import com.example.task.databinding.ProductRvItemBinding

class ProductsRvAdapter (
    private val list : List<Product>,
    private val productListnter:ProductListnter
): BaseRecyclerViewAdapterAdapter<ProductRvItemBinding, Product>(list) {
    override fun bind(binding: ProductRvItemBinding, item: Product) {
        binding.product = item
        binding.btnSeeProduct.setOnClickListener {
            productListnter.onProductClicked(item)
        }
//        binding.root.setOnClickListener{
//            productListnter.onProductClicked(item)
//        }
    }

    override fun getLayoutId(): Int {
        return R.layout.product_rv_item
    }
}
interface ProductListnter {
    fun onProductClicked(product: Product)
}