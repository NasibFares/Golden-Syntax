package Inventory.Clothes

import Inventory.Products

class ClothingProducts(
    name: String, category: String,
    val size: String,
    val gender: String,
    val brand: String,
    val price: Double,
    val quantity: Int
) : Products(name, category) {
}