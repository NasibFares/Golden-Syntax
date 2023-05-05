package produkte.products.clothes

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class TShirts(
    name: String, price: Double, evaluation: Double = 0.0,
    category: Categories,
    subCategory: Subcategories, val gender: String= listOf("Men", "Women","Children").random(),
    val size:String = listOf("S","M","L","Xl","XXl","XXXl").random(),val colour:String
) : Products(name, price, evaluation, category, subCategory) {
}