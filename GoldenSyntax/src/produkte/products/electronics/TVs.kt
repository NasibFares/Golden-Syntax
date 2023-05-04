package produkte.products.electronics

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products

class TVs(name:String,price: Double, evaluation: Double=0.0,
          category: Categories,
          subCategory: Subcategories,val size:Double,val art:List<String> = listOf("HD","UHD","4K")
):Products(name,price,evaluation,category,subCategory) {
}