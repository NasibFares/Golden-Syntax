package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Store

class Microwaves(
    name: String,
    price: Double,
    evaluation: Double = 0.0,
    category: Categories = Categories.Electronics,
    subCategory: Subcategories = Subcategories.Microwaves,
    val capacity: String,
    val color: String,
    val material:String,
    val watt: String,
    qty:Int
) : Store(name, price, evaluation, category, subCategory,qty) {
}