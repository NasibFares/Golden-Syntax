package benutzer

import functios.finalProductsList
import produkte.products.Products
/*
Die Klasse 'Customers'→ "Die Kunden des Shops" hat die Eigenschaften 'name'→ Name der Kunde, 'age'→ Alter der Kunde,
paymentMethod→ Zahlungsmethode, 'cart'→ Warenkorb der Kunde, 'accountBalance'→ Kontostand der Kunde
 */
class Customers(
    firstName: String,
    lastName: String,
    eMail: String,
    age: Int,
    passWord: String,
    adminRight:Boolean=false,
    var shoppingCart:MutableList<Products> = mutableListOf() ,
    val paymentMethod: String,
    var accountBalance: Double = 0.0
) : Users(firstName, lastName, eMail, age,passWord, adminRight) {

    /*
    Die Methode 'addToCart' ermöglicht dem Kunden, die lieblingsprodukte in Warenkorb hinzufügen.
    Als Parameter übernimmt diese Methode 'product→ bezieht sich auf ein Produkt von der Liste Produkte'
     */
    open fun addProductToCart(shoppingCart: MutableList<Products>): Pair<MutableList<Int>, MutableList<Products>> {
        println("Geben Sie bitte die ID des Produkts:")
        val addedProductID = readln().toIntOrNull()
        var addedQtys: MutableList<Int> = mutableListOf()
        if (addedProductID != null) {
            shoppingCart.add(finalProductsList[addedProductID])
            println("Wie viele Stücke möchten Sie?")
            val qty = readln().toIntOrNull()
            if (qty != null) { //Meine Menge
                if (finalProductsList[addedProductID].qty - qty >= 0) {
                    addedQtys.add(qty)
                    finalProductsList[addedProductID].qty -= qty
                    println("${finalProductsList[addedProductID].name}wurde erfolgreich $qty mal im gesamt wehrt von ${finalProductsList[addedProductID].price * qty} € zu deinem Wahrenkorb hinzufügt.")
                }
            }
        }
        return Pair(addedQtys, shoppingCart)
    }

    //TODO:
    fun returnProduktToShop(qtyBought: MutableList<Int>, myCart: MutableList<Products>) {
        //for(i in )
    }
}
/*
    Die Methode 'removeFromCart' ermöglicht dem Kunden, ein Produkt im Warenkorb zu löschen.
    Als Parameter übernimmt diese Methode 'product→ bezieht sich auf eine produkt von der Liste Produkte'
        */

