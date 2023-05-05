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
    Als Parameter übernimmt diese Methode 'product→ bezieht sich auf ein Produkt von der Liste Produkte'
     */
    fun addToCart(product: Products) {
        cart.add(product)
    }
    /*
     Die Methode 'removeFromCart' ermöglicht dem Kunden, ein Produkt im Warenkorb zu löschen.
     Als Parameter übernimmt diese Methode 'product→ bezieht sich auf eine produkt von der Liste Produkte'
         */
    fun removeFromCart(product: Products) {
        cart.remove(product)
    }
    /*
     Die Methode 'getCartTotal' berechnet den Gesamtpreis für die Produkte im Warenkorb und gibt den Preis zurück.
             */
    fun getCartTotal(): Double {
        return cart.sumOf { it.price }
    }
}