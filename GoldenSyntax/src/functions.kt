import benutzer.Customers
import benutzer.Users

fun main() {

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

            register()

        } else if (wahl == 3) {
            //Hier kommt der Code der Abmeldung.
        } else {
            throw Exception("Ungültige Eingabe1")
        }

    } catch (e: Exception) {
        println("Ungültige Eingabe2")

    }
}

fun register() {
    var customer = Customers("", "", "", "", 0, "")
    var userList = Users("", "", "", "")
    val maxAttempts = 2
    var attempts = 0
    var firstName: String? = ""
    var lastName: String? = ""
    while (attempts < maxAttempts) {
        println("Geben Sie bitte Ihren Vornamen ein")              //Eingabe des Vornamens des Benutzers
        firstName = readln()
        //Falls die Eingabe leer oder null oder nicht Buchstaben ist
        if (firstName.isNullOrEmpty() || !firstName.all { it.isLetter() }) {
            println("Eingabe darf nicht leer oder null oder Zahlen sein.")
            attempts++

        } else {
            println("Ihr Vorname lautet: [$firstName]")
            customer.firstName = firstName
            break
        }
    }
    if (firstName.isNullOrEmpty() || !firstName.all { it.isLetter() }) {
        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
    }

    while (attempts < maxAttempts) {
        println("Geben Sie bitte Ihren Nachnamen ein")//Nachname des Benutzers
        lastName = readln()
        if (lastName.isNullOrEmpty() || !lastName.all { it.isLetter() }) {
            println("Eingabe darf nicht leer oder null oder Zahlen sein.")
            attempts++
        } else {
            println("Ihr Nachname lautet: [$firstName]")
            customer.lastName = lastName
            break
        }
    }
    if (lastName.isNullOrEmpty() || !lastName.all { it.isLetter() }) {
        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
    }

    println("Geben Sie bitte Ihre E-Mail Adresse ein:")//E-Mail-Adresse des Benutzers
    val email = readln()
    checkRegisterInfo(email, userList, customer)
    customer.eMail = email
    println("Geben Sie bitte Ihr Alter ein:")//Das Alter des Benutzers
    val age = readln().toIntOrNull() ?: 0
    customer.age = age
    if (customer.age < 12) {
        println("Wir entschuldigen uns, Sie dürfen bei uns nicht registrieren.")
    } else {

        userList.usersList.add(customer)
    }
}

fun checkRegisterInfo(
    eMail: String,
    userList: Users,
    customer: Customers
) { //Überprüfen, ob die E-Mail gültig und nicht schon Verwendet
    val checkValidity = isValidEmail(eMail)

    if (!userList.usersList.any { it.eMail == eMail } && checkValidity) {//E-Mail ist nicht in der Liste und ist gültig.
        userList.usersList.add(customer)

    }
    while (userList.usersList.any { it.eMail == eMail }) {
        println("Die E-Mail Adresse existiert schon in der Datenbank.!!")
        break
    }
    while (!checkValidity) {
        println("Die E-Mail Adresse ist nicht gültig.")
        break
    }
}

fun isValidEmail(email: String): Boolean {
    val emailPattern = Regex("^[a-z\\d.]+@[a-z\\d]+\\.[a-z]{2,}\$")
    return emailPattern.matches(email)
}

