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

            register()  //Die Methode register wird aufgerufen.

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
    var ageTemp: String?
    var age: Int? = 0
    while (attempts < maxAttempts) {
        //Eingabe des Vornamens des Benutzers
        println("Geben Sie bitte Ihren Vornamen ein")
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
    attempts = 0
    while (attempts < maxAttempts) {
        //Eingabe des Nachnamens des Benutzers.
        println("Geben Sie bitte Ihren Nachnamen ein:")
        lastName = readln()
        //Falls die Eingabe leer oder null oder nicht Buchstaben ist.
        if (lastName.isNullOrEmpty() || !lastName.all { it.isLetter() }) {
            println("Eingabe darf nicht leer oder null oder Zahlen sein.")
            attempts++
            //Sonst
        } else {
            println("Ihr Nachname lautet: [$lastName]")
            customer.lastName = lastName
            break
        }
    }
    if (lastName.isNullOrEmpty() || !lastName.all { it.isLetter() }) {
        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
    }
    attempts = 0
    while (attempts < maxAttempts) {
        //Eingabe des Alters des Benutzers
        println("Geben Sie bitte Ihr Alter ein:")
        ageTemp = readln()
        if (ageTemp.all { it.isLetter() } || ageTemp.isNullOrEmpty()) {
            println("Diese Eingabe darf nicht leer oder null oder Buchstaben sein!!")
        } else if (!ageTemp.all { it.isLetter() }) {
            age = ageTemp.toInt()
            //Falls der Benutzer unter 12 Jahre alt ist:
            if (age < 12) {
                println("Wir entschuldigen uns, Sie dürfen bei uns nicht registrieren.")
                //Sonst
            } else {
                customer.age = age
            }
        } else {
            println("Ihr Alter ist:$age ")
            break
        }
    }
    attempts++
    if (attempts == maxAttempts) {
        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
    }

    //Eingabe der E-Mail-Adresse des Benutzers
    println("Geben Sie bitte Ihre E-Mail Adresse ein:")
    val email = readln()
    //Die Methode 'checkRegisterInfo' wird aufgerufen:
    checkEmailInfo(email, userList, customer)
    customer.eMail = email


    userList.usersList.add(customer)

}

/*
Die Methode 'isValidEmail' Überprüft, ob die E-Mail-Adresse gültig.
Als Parameter übernimmt dei Methode die Variable 'email'
 */
fun isValidEmail(email: String): Boolean {
    val emailPattern = Regex("^[a-z\\d.]+@[a-z\\d]+\\.[a-z]{2,}\$")
    return emailPattern.matches(email)
}

/*
Die Methode 'checkEmailInfo', ruft die Methode, 'isValidEmail' auf und überprüft zusätzlich, ob die E-Mail
 schon registriert oder nicht.
 */
fun checkEmailInfo(
    eMail: String,
    userList: Users,
    customer: Customers
) {

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


fun istValidPassword(password: String): Boolean {
    val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    return passwordPattern.matches(password)
}
/*
In dieser Abteilung werden zwei Methoden gebaut.
1-Die Methode 'isAgeValid':
in dieser Methode wird 'age' zuerst als 'String' definiert, um zu prüfen, ob die Eingabe 'age' leer,null,oder aber
Buchstaben ist.
Falls nicht, wird die Eingabe in 'Int' umgewandelt, um zu prüfen, ob sie weniger als 12 ist.
Falls nicht, nimmt die Variable 'ageValid: Boolean' den Wert 'true', dieser Wert wird zurückgegeben.
2-Die Methode 'customerAge':
diese Methode übernimmt den Wert 'ageValid' von der Methode 'isAgeValid' und überprüft, ob er 'false' oder 'true' ist.
Diese Methode verfügt eine While-Schleife, um dem Benutzer zu ermöglichen, die Eingabe wieder einzugeben, wenn sie
falsch ist.
 */
fun isAgeValid(): Boolean {
    var ageValid: Boolean

    var customer = Customers("", "", "", "", 0, "")
    println("Geben Sie bitte Ihr Alter ein:")
    var age = readln()
    if (age.isNullOrEmpty() || age.all { it.isLetter() }) {
        ageValid = false
        println("Das Alter darf nicht null oder leer oder Buchstaben sein.")
    } else if (age.toInt() < 12) {
        ageValid = false
        println("Wir entschuldigung uns, als unter 12 dürfen Sie nicht registrieren!!")
    } else {
        ageValid = true
        customer.age = age.toInt()

    }
    return ageValid
}
fun customerAge() {
    var trials = 0
    val maxTrials = 2
    while (trials < maxTrials) {
        if (!isAgeValid()) {
            trials++
            if (trials < maxTrials) {
                println("Wiederholen Sie bitte die Eingabe")
            }
        } else {
            break
        }
    }
    if (trials == maxTrials) {
        println("Sie haben die Anzahl der Versuche überschritten!!!!")
    }
}



