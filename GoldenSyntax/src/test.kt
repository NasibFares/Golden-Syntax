import produkte.Categories
import produkte.Products
import produkte.Subcategories


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
    val myClothes = Products("T-Shirt", 14.85, 5.0, Categories.Clothes, Subcategories.TShirts)
    println(myClothes.evaluation)
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