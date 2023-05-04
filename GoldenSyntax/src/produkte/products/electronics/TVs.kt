package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class TVs(
    name: String, price: Double, evaluation: Double = 0.0,
    category: Categories,
    subCategory: Subcategories
) : Products(name, price, evaluation, category, subCategory) {
    constructor(name: String, price: Double, evaluation: Double, category: Categories, subCategory: Subcategories, d: Double, s: String) : this(
        name,
        price,
        evaluation,
        category,
        subCategory
    )

    val display: String = listOf("HD", "UHD", "4K").random()
    val size: Double=0.0
}