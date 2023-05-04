package produkte.products.clothes

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class TShirts(
    name: String, price: Double, evaluation: Double = 0.0,
    category: Categories,
    subCategory: Subcategories, val gender: List<String> = listOf("Men", "Women","Children"),
    val size:List<String> = listOf("S","M","L","Xl","XXl","XXXl")
) : Products(name, price, evaluation, category, subCategory) {
}