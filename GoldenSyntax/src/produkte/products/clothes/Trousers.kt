package produkte.products.clothes

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class Trousers(
    name: String, price: Double, evaluation: Double = 0.0, category: Categories,
    subCategory: Subcategories, val size: Int
) : Products(name, price, evaluation, category, subCategory) {

}
