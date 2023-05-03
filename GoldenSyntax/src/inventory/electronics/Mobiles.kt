package inventory.electronics
import inventory.Products

class Mobiles(
    name: String, category: String,
    val brand: String,
    val price: Double,
    val quantity: Int,
    val memory:String
) : Products(name, category) {
}