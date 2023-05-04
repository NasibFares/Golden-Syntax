import benutzer.Customers
import produkte.Categories
import produkte.products.Products
import produkte.Subcategories
import produkte.products.electronics.Mobiles
import produkte.products.electronics.TVs


fun main() {

    /*val inv = Inventory()
    val pro = Products("Smasung", "Mobiles")
    inv.addItem(pro)
    println("${pro.name} ${pro.category}")
    val mobile = Mobiles("Samsung Galaxy S20", "Mobiles", "Samsung", 320.0, 45, "128GB")
    println("${mobile.name} ${mobile.brand} ${mobile.price} ${mobile.memory}")
    println(inv)
    registerOrlogin(customer)
    */
    val myProduct = Products("Samsung", 230.0, 3.0, Categories.Electronics, Subcategories.Mobiles)
    myProduct.addReview("5")
    println(myProduct.evaluation)
    //val myClothes = Clot("T-Shirt", 14.85, 5.0, Categories.Clothes, Subcategories.TShirts)
    //println(myClothes.evaluation)
    val myTv = TVs("Samsung", 450.0, 2.0, Categories.Electronics, Subcategories.TVs, "HD", 40)
    val kunde: Customers = Customers("Nasib", 45, "Karte")
    kunde.addToCart(myTv)
    val myMobile = Mobiles("Nokia", 450.0, 3.0, Categories.Electronics, Subcategories.Mobiles, "64GB", "Rot")
    kunde.addToCart(myMobile)
    val productsCard: Products
    println("Ihr Warenkorb:")
    for (i in kunde.cart.indices) {
        println(kunde.cart[i].name)
        println(kunde.cart[i].category)
        println(kunde.cart[i].subCategory)
        println(kunde.cart[i].price)
        println(kunde.cart[i].evaluation)
    }


}

/*fun registerOrlogin() {

    var firstname= customer.firstName
    var email=customer.E-Mail
    var lastname=customer.lastName
    println("Herzlich willkommen in unserem Online-Shop 'Golden Syntax':\n1.Registrieren (neuer Benutzer.\n2.Anmelden)")

    var wahl: Int = 0
    if (wahl == 1) {                                   //Registrierung
        println("Geben Sie bitte Ihren Vornamen ein")
        firstname = readln()
        println("Geben Sie bitte Ihren Nachnamen ein")
        lastname=readln()
        println("Geben Sie bitte Ihre E-main Adresse ein:")
        email = readln()
        println("Geben Sie bitte Ihr Alter ein:")
        customer.alter = readln().toInt()
        if (customer.alter < 12) {
            println("Wir entschuldigen uns, Sie dürfen bei uns nicht registrieren.")
        } else {
            customer.usersEmails.add(customer.eMail)
            customer.usersPasswords.add(customer.usersEmails.indexOf(customer.eMail),customer.password)
        }
      println("${customer.usersEmails} ${customer.password}")

    } else{                                             //Anmelden
        do {
            println("Geben Sie bitte Ihre E-mail Adresse ein")
          if ()
        }while ()


        println("Geben Sie bitte Ihr Kennwort ein")
 }
   */

