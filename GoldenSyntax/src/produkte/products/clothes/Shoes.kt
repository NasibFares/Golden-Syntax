package produkte.products.clothes

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class Shoes(
    name: String, price: Double, evaluation: Double = 0.0,
    category: Categories,
    subCategory: Subcategories, val size: Double, val gender:String,val art: String= listOf("Sport", "Summer-Classic", "Winter-Classic").random(),
    val colour:String
) : Products(name, price, evaluation, category, subCategory) {
}