import inventory.Inventory
import inventory.Products
import inventory.electronics.Mobiles
import users.Customers
import users.Users

fun main() {
    val inv = Inventory()
    val pro = Products("Smasung", "Mobiles")
    inv.addItem(pro)
    println("${pro.name} ${pro.category}")
    val mobile = Mobiles("Samsung Galaxy S20", "Mobiles", "Samsung", 320.0, 45, "128GB")
    println("${mobile.name} ${mobile.brand} ${mobile.price} ${mobile.memory}")
    println(inv)
}

fun registerOrlogin(customer: Customers) {
    println("Herzlich Willkommen in unserem Online-Shop 'Golden Syntax':\n1.Registrieren (neuer Benutzer.\n2.Anmelden)")
    var wahl: Int = 0
    if (wahl == 1) {                                   //Registrierung
        println("Geben Sie bitte Ihren Vornamen ein")
        customer.firstName = readln()
        println("Geben Sie bitte Ihren Nachnamen ein")
        readln().also { customer.lastName = it }  //Andere weise um readln() an der Variable zu setzen
        println("Geben Sie bitte Ihre E-main Adresse ein:")
        customer.eMail = readln()
        println("Geben Sie bitte Ihr Alter ein:")
        customer.alter = readln().toInt()
        if (customer.alter < 12) {
            println("Wir entschuldigen uns, Sie dürfen bei uns nicht registrieren.")
        } else {
            //Hier müssen alle persönlichen Informationen zur Userliste hinzugefügt
        }


    } /*else{                                             //Anmelden
        do {
            println("Geben Sie bitte Ihre E-mail Adresse ein")
            //if ()
       // }while ()


        println("Geben Sie bitte Ihr Kennwort ein")
   }
   */
}