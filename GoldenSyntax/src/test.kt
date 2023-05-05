import benutzer.Customers
import produkte.Categories
import produkte.products.Products
import produkte.Subcategories
import produkte.products.electronics.Mobiles
import produkte.products.electronics.TVs
import kotlin.concurrent.thread


fun main() {
    val maxAttempts = 3
    var attempts = 0
    println(
        "Herzlichen Willkommen in unserem [Golden-Syntax] online-shop:\n" +
                "Wählen Sie bitte eine Option aus:\n1.Registrieren\n2.Anmelden"
    )
    var wahl = readln().toInt()

    try {
        if (wahl == 2) {                                    //Anmelden
            println("Geben Sie bitte eine gültige e-Mail Adresse ein")
            val email = readln()
            val check = isValidEmail(email)
            for (i in 1..maxAttempts) {
                while (!check) {
                    println(
                        "Ungültige e-Mail Adresse!!\n" +
                                "Die eMail sollte nur kleine Buchstaben,Zahlen,Punkte enthalten "
                    )

                    attempts++
                }
                if (check) {
                    println("Geben Sie bitte Ihr Kennwort ein: ")
                    break
                }
            }

        } else if (wahl == 1) {
            // Hier kommt der Code der Registrierung
        } else {
            thread { println("Sie haben ungültige Option gewählt!!") }
        }
    } catch (e: Exception) {
        println("Ungültige Option")
    }
    /* println("Geben Sie bitte Ihren Vornamen ein")
     firstname = readln()
     println("Geben Sie bitte Ihren Nachnamen ein")
     lastname = readln()
     println("Geben Sie bitte Ihre E-main Adresse ein:")
     email = readln()
     println("Geben Sie bitte Ihr Alter ein:")
     customer.alter = readln().toInt()
     if (customer.alter < 12) {
         println("Wir entschuldigen uns, Sie dürfen bei uns nicht registrieren.")
     } else {
         customer.usersEmails.add(customer.eMail)
         customer.usersPasswords.add(customer.usersEmails.indexOf(customer.eMail), customer.password)
     }
     println("${customer.usersEmails} ${customer.password}")

     println("Gib deine E-Mail Adresse ein")
 */
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

