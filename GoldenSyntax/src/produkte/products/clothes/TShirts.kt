package produkte.products.clothes

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class TShirts(
    name: String,
    price: Double,
    evaluation: Double = 0.0,
    category: Categories = Categories.Clothes,
    subCategory: Subcategories = Subcategories.TShirts,
    val gender: String,
    val size:String
    ,val color:String
) : Products(name, price, evaluation, category, subCategory) {
}