package benutzer

import functios.finalProductsList
import produkte.products.Products
val customer=Customers("", "", "", 0, "", false, "")
/*
Die Klasse 'Customers'→ "Die Kunden des Shops" hat die Eigenschaften 'name'→ Name der Kunde, 'age'→ Alter der Kunde,
paymentMethod→ Zahlungsmethode, 'cart'→ Warenkorb der Kunde, 'accountBalance'→ Kontostand der Kunde
 */
open class Customers(
    firstName: String,
    lastName: String,
    eMail: String,
    age: Int,
    passWord: String,
    adminRight:Boolean=false,
    val paymentMethod: String,
      // kann als MutableMap erstellt werden.
) : Users(firstName, lastName, eMail, age,passWord, adminRight) {
    var accountBalance: Double = 0.0

    /*
    Die Methode 'addToCart' ermöglicht dem Kunden, die lieblingsprodukte in Warenkorb hinzufügen.
    Als Parameter übernimmt diese Methode 'product→ bezieht sich auf ein Produkt von der Liste Produkte'
     */
   open fun addProductToCart(myCart:MutableList<Products>):Pair<MutableList<Int>,MutableList<Products>> {
        println("Gib die ID des Produkts:")
      val addedProductID=readln().toIntOrNull()

        var qtyBought:MutableList<Int> = mutableListOf()
        if(addedProductID != null){
            myCart.add(finalProductsList[addedProductID])

          println("Wie viele Stücke möchten Sie?")
            val qty=readln().toIntOrNull()
            if (qty!=null){ //Meine Menge
                if(finalProductsList[addedProductID].qty - qty<0){
                    qtyBought.add(qty)
                    finalProductsList[addedProductID].qty -= qty
                }

            }
        }
        return Pair(qtyBought,myCart)
    }
}   /*
     Die Methode 'removeFromCart' ermöglicht dem Kunden, ein Produkt im Warenkorb zu löschen.
     Als Parameter übernimmt diese Methode 'product→ bezieht sich auf eine produkt von der Liste Produkte'
         */

