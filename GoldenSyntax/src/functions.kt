import benutzer.Customers

fun main() {

}
fun register(customer:Customers){

    println("Geben Sie bitte Ihren Vornamen ein")//Vorname des Benutzers
    customer.firstName= readln()

    println("Geben Sie bitte Ihren Nachnamen ein")//Nachname des Benutzers
    val lastname = readln()

    println("Geben Sie bitte Ihre E-main Adresse ein:")//E-Mail-Adresse des Benutzers
    val email = readln()
    println("Geben Sie bitte Ihr Alter ein:")
    customer.age = readln().toInt()
    if (customer.age < 12) {
        println("Wir entschuldigen uns, Sie dürfen bei uns nicht registrieren.")
    } else {
        customer.usersEmails.add(customer.eMail)
        customer.usersPasswords.add(customer.usersEmails.indexOf(customer.eMail), customer.password)
    }
    println("${customer.usersEmails} ${customer.password}")

    println("Gib deine E-Mail Adresse ein")

}
fun registerOrLogin() {
    /*
Allererstes
 */
    println(
        "Herzlichen Willkommen in unserem [Golden-Syntax] online-shop:"

    )
    var wahl: Int
    val maxAttempts = 3
    var attempts = 0
    var check: Boolean
    do {
        println("Wählen Sie eine Option:")
        println("1. Anmelden")
        println("2. Registrieren")
        println("3. Ausloggen")
        print("Eingabe: ")
        wahl = readlnOrNull()?.toIntOrNull() ?: 0
    } while (wahl != 1 && wahl != 2 && wahl != 3)
    try {
        if (wahl == 1) {
            while (attempts < maxAttempts) {
                println("Geben Sie bitte Ihre E-Mail Adresse ein:")
                var email = readln()
                check = isValidEmail(email)
                if (!check) {
                    println(
                        "Ungültige E-Mail Adresse!!" +
                                "Hinweise: Kleine Buchstaben,Zahlen,Punkte.\n" +
                                "Sie haben noch ${maxAttempts - attempts - 1} Versuche.\n" +
                                "-----------------------------------------"
                    )

                    attempts++
                }

                if (check) {
                    println("Geben Sie bitte Ihr Kennwort ein:")
                    var password = readln()
                    break

                }
            }
        } else if (wahl == 2) {
            //Hier kommt der Code der Registrierung.
        } else if (wahl == 3) {
            //Hier kommt der Code der Abmeldung.
        } else {
            throw Exception("Ungültige Eingabe1")
        }

    } catch (e: Exception) {
        println("Ungültige Eingabe2")

    }
}

