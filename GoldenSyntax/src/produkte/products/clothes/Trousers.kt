package produkte.products.clothes

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class Trousers(
    name: String,
    price: Double,
    evaluation: Double = 0.0,
    category: Categories = Categories.Clothes,
    subCategory: Subcategories = Subcategories.Trousers,
    val gender:String,
    val size: Int,
    val color:String,
    qty:Int=0
) : Products(name, price, evaluation, category, subCategory,qty) {

}
