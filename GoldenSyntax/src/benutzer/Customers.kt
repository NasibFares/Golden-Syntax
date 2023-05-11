package benutzer
import produkte.products.Store
data class PaymentOptions(val name: String, var balance: Double)
/*
Die Klasse 'Customers'→ "Die Kunden des Shops" erbt die Eigenschaften 'firsName'→ Vorname der Kunde, 'lastName'→
Nachname der Kunde, 'eMail'→ die e-Mail Adresse der Kunde, 'age'→ Alter der Kunde,'passWord'→ Kennwort der Kunde,
'adminRight'→ Berichtigung der Benutzer (Operator,Kunde) vom der Mutterklasse 'Users', zusätzlich hat sie die Eigenschaften
paymentMethod→ Zahlungsmethode, 'cart'→ Warenkorb der Kunde, 'accountBalance'→ Kontostand der Kunde
 */
class Customers(
    firstName: String,
    lastName: String,
    eMail: String,
    age: Int,
    passWord: String,
    adminRight:Boolean=false,
    var shoppingCart:MutableList<Store> = mutableListOf(),
    val paymentMethod: MutableMap<Int, PaymentOptions> = mutableMapOf(
        1 to PaymentOptions("Lastschrift", 0.0),
        2 to PaymentOptions("PayPal", 0.0),
        3 to PaymentOptions("Kreditkarte", 0.0))

) : Users(firstName, lastName, eMail, age,passWord, adminRight) {



}
/*
    Die Methode 'removeFromCart' ermöglicht dem Kunden, ein Produkt im Warenkorb zu löschen.
    Als Parameter übernimmt diese Methode 'product→ bezieht sich auf eine produkt von der Liste Produkte'
        */

