package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

open class Mobiles(
    name: String, price: Double, evaluation: Double = 0.0,
    category: Categories,
    subCategory: Subcategories, val memory: Int, val colour: String
) : Products(name, price, evaluation, category, subCategory) {
}