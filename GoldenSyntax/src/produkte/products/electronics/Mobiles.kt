package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Store

open class Mobiles(
    name: String,
    price: Double,
    evaluation: Double = 0.0,
    category: Categories = Categories.Electronics,
    subCategory: Subcategories = Subcategories.Mobiles,
    val storage: String,
    val color: String,
    val operatingSystem: String,
    qty:Int
) : Store(name, price, evaluation, category, subCategory,qty) {
}