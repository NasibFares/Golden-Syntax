package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class TVs(
    name: String, price: Double, evaluation: Double = 0.0,
    category: Categories,
    subCategory: Subcategories, val resolution: String = listOf("HD", "UHD", "4K").random(), val size: Int
) : Products(name, price, evaluation, category, subCategory) {

}