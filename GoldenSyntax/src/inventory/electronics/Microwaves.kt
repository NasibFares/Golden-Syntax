package inventory.electronics

import inventory.Products

class Microwaves(
    name: String, category: String,
    val brand: String,
    val size:Int,
    val price: Double,
    val quantity: Int,
    val memory: String
) : Products(name, category) {
}