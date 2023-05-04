package benutzer

import produkte.products.Products

/*
Die Klasse 'Customers'→ "Die Kunden des Shops" hat die Eigenschaften 'name'→ Name der Kunde, 'age'→ Alter der Kunde,
paymentMethod→ Zahlungsmethode, 'cart'→ Warenkorb der Kunde, 'accountBalance'→ Kontostand der Kunde
 */
open class Customers(
    val name: String,
    val age: Int,
    val paymentMethod: String,
    var cart: MutableList<Products> = mutableListOf()
) {
    var accountBalance: Double = 0.0

    /*
    Die Methode 'addToCart' ermöglicht dem Kunden, die lieblingsprodukte in Warenkorb hinzufügen.
    Als Parameter übernimmt die Methode 'product→'
     */
    fun addToCart(product: Products) {
        cart.add(product)
    }

    fun removeFromCart(product: Products) {
        cart.remove(product)
    }

    fun getCartTotal(): Double {
        return cart.sumOf { it.price }
    }
}