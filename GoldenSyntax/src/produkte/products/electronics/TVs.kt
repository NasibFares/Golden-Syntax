package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class TVs(
    name: String,
    price: Double,
    evaluation: Double = 0.0,
    category: Categories = Categories.Electronics,
    subCategory: Subcategories = Subcategories.TVs,
    val resolution: String,
    val size: Int,
    qty:Int
) : Products(name, price, evaluation, category, subCategory,qty) {

}