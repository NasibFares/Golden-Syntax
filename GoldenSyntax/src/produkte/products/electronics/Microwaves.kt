package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class Microwaves(
    name: String, price: Double, evaluation: Double = 0.0,
    category: Categories,
    subCategory: Subcategories, val capacity: String, val colour: String, val multfunction: Boolean
) : Products(name, price, evaluation, category, subCategory) {
}