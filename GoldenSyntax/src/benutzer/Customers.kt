package benutzer
import produkte.products.Products
class Customers(val name: String, val age: Int, val paymentMethod: String, var cart: MutableList<Products> = mutableListOf()) {
    var accountBalance: Double = 0.0

    fun addToCart(product: Products) {
        cart.add(product)
    }

    fun removeFromCart(product: Products) {
        cart.remove(product)
    }

    fun getCartTotal(): Double {
        return cart.map { it.price }.sum()
    }
}