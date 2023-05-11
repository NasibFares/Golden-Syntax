package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Store

class TVs(
    name: String,
    price: Double,
    evaluation: Double = 0.0,
    category: Categories = Categories.Electronics,
    subCategory: Subcategories = Subcategories.TVs,
    val resolution: String,
    val size: Int,
    qty:Int
) : Store(name, price, evaluation, category, subCategory,qty) {

}