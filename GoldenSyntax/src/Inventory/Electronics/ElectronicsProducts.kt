package Inventory.Electronics

import Inventory.Products

class ElectronicsProducts(
    name: String, category: String,
    var brand: String,
    var price: Double,
    val quantity: Int
) : Products(name, category) {
}