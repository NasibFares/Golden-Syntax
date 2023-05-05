import benutzer.Customers
import produkte.Categories
import produkte.products.Products
import produkte.Subcategories
import produkte.products.electronics.Mobiles
import produkte.products.electronics.TVs


fun main() {



println("Gib deine E-Mail Adresse ein")
    val email=readln()
     isValidEmail(email)
    val check=isValidEmail(email)
    println(check)
}
fun isValidEmail(email: String): Boolean {
    val emailPattern = Regex("^[a-z\\d.]+@[a-z\\d]+\\.[a-z]{2,}\$")
    return emailPattern.matches(email)
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

