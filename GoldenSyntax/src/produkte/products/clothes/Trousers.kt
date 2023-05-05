package produkte.products.clothes

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class Trousers(
    name: String, price: Double, evaluation: Double = 0.0, category: Categories,
    subCategory: Subcategories, val gender:String = listOf("Women","Men","Children").random(),val size: Int,val colour:String
) : Products(name, price, evaluation, category, subCategory) {

}
