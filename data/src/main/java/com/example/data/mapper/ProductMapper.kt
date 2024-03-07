package com.example.data.mapper

import com.example.data.dto.ProductsResponseItem
import com.example.domain.mapperInterface.Mapper
import com.example.domain.models.product.Product
import javax.inject.Inject

class ProductMapper @Inject constructor():Mapper<ProductsResponseItem, Product> {
    override fun map(input: ProductsResponseItem): Product {
        return Product(
            input.id,
            input.category,
            input.description,
            input.image,
            input.price,
            input.rating.rate,
            input.title
        )
    }

}