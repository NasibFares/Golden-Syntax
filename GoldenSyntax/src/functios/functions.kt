package functios

import benutzer.Users
import kotlin.system.exitProcess

var user = Users("", "", "", 0, "", false)
var userList: MutableList<Users> = mutableListOf()

fun main() {

}

/*
-----------------------------------------------Willkommen Screen--------------------------------------------------------
________________________________________________________________________________________________________________________
 */


/*
-------------------------------------------------registerLoginLogout----------------------------------------------------
Allererstes willkommen wir unsere Kunden in unserem Online-Shop.
Dann wird eine Optionsliste angezeigt, um dem Benutzer zu ermöglichen, eine Option auszuwählen.
Entsprechend der ausgewählten Option wird eine Methode ausgeführt.
*/
fun registerLoginLogout(): Int {

    println(
        "Herzlichen Willkommen in unserem [Golden-Syntax] online-shop:\n" +
                "-------------------------------------------------------------"
    )

    var wahl: Int
    var trials = 0
    val maxTrials = 3
    do {
        println("Wählen Sie eine Option aus:")
        println("1. Anmelden")
        println("2. Registrieren")
        println("3. Ausloggen")
        print("Eingabe: ")
        wahl = readlnOrNull()?.toIntOrNull() ?: 0
        trials++
    } while (wahl !in 1..3 && trials < maxTrials)

    if (trials >= maxTrials) {
        println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
        exitProcess(0)
    }

    try {
        when (wahl) {
            1 -> logIn()
            2 -> register()
            3 -> {
                Thread.sleep(1200)
                println("Sie haben sich erfolgreich abgemeldet.")
                exitProcess(0)
            }
            else -> throw Exception("Ungültige Eingabe")
        }

    } catch (e: Exception) {
        println("Ungültige Eingabe: ${e.message}")
    }
    return wahl
}

/*
-------------------------------------------------1.1.Anmeldung---------------------------------------------------------
Die Methode 'logIn' ruft drei Methoden auf:
1-Die Methode 'isUserRegisted':
Diese Methode stellt sich sicher, dass der die e-Mail Adresse des Benutzers schon registriert, wenn 'ja' gibt 'true'
zurück, wenn 'nein' gibt 'false' zurück.
2-Die Methode 'findPasswordByEmail':
Sie sucht das Kennwort des Benutzers aus und gibt es zurück.
3-Die Methode 'checkPasswordMatch':
Diese Methode vergleicht das abgespeicherte Kennwort des Benutzers mit dem vom Benutzer abgegebene Kennwort, sie gibt
das Ergebnis des Vergleichs als Boolean zurück.
In der Methode 'logIn' sollte der Benutzer zuerst die e-Mail Adresse eingeben, wenn diese e-Mail schon registriert ist,
sollte der Benutzer das Kennwort eingeben.
Falls das Kennwort richtig ist, wird sich der Benutzer erfolgreich anmelden.
 */
fun logIn(): Boolean {
    var trials = 0
    val maxTrials = 3
    while (trials < maxTrials) {
        println("Geben Sie bitte Ihre e-Mail Adresse ein:")
        var email = readln()
        if (!isUserRegisted(email)) {    // Falls die E-Mail nicht schon registriert ist.
            println("Sie haben ungültige e-Mail Adresse eingegeben!!")
            trials++
        } else {                         // Falls die E-Mail schon registriert ist.
            val user = checkPasswordMatch(email)
            if (user != null) {
                val adminRight = user.adminRight
                if (adminRight) {
                    println("Sie haben sich erfolgreich als [${user.firstName} ${user.lastName}]:Operator angemeldet.\n")
                    Thread.sleep(1000)
                    operatorOption()
                } else {
                    println("Sie haben sich erfolgreich als [${user.firstName} ${user.lastName}]:Kundin/e angemeldet.\n")
                    Thread.sleep(1000)
                    customerOptions()
                }
                return true
            }
        }
    }

    println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
    return false
}

fun isUserRegisted(email: String): Boolean {
    for (user in userList) {
        if (user.eMail == email) {
            return true
        }
    }
    return false
}

fun checkPasswordMatch(email: String): Users? {
    var trials = 0
    val maxTrials = 3
    while (trials < maxTrials) {
        println("Geben Sie bitte Ihr Kennwort ein:")
        val password = readln()
        for (user in userList) {
            if (user.eMail == email && user.passWord == password) {
                return user
            }
        }
        println("Sie haben ungültiges Kennwort eingegeben!!")
        trials++
    }
    println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
    return null
}

fun findPasswordByEmail(email: String): String? {
    for (user in userList) {
        if (user.eMail == email) {
            return user.passWord
        }
    }
    return null
}

/*
-------------------------------------------------1.2.Registrierung------------------------------------------------------
 Die Methode 'register' ruft verschiedenen Methoden auf, die zu Registrierung gehören.
 Jede Methode wird ausgeführt, wenn die vorherige Methode vom Benutzer richtig ausgeführt ist.
 z.B wenn der Benutzer sein Name richtig eingegeben hat, wird die Methode checkNachname ausgeführt.
 */
fun register() {

    if (checkFirstName()) {
        if (checkLastName()) {
            if (customerAge()) {
                if (checkEmailInfo()) {
                    if (checkPassword()) {
                        println("Sie haben erfolgreich registriert:")
                        println("1.Vorname:${user.firstName}")
                        println("2.Nachname:${user.lastName}")
                        println("3.e-Mail:${user.eMail}")
                        println("4.Alter:${user.age}")

                    }
                }
            }
        }
    }
    Thread.sleep(1200)
    customerOptions()
}


/*
--------------------------------------------------Vorname/Nachname---------------------------------------------------
 */

fun checkFirstName(): Boolean {
    var trials = 0
    var maxTrials = 3
    while (trials < maxTrials) {
        println("Geben Sie bitte Ihren Vorname ein:")
        var firstName = readln()
        if (firstName.isNullOrEmpty() || !firstName.all { it.isLetter() }) {
            println("Der Vorname darf nicht null,leer oder Zahlen sein!!")
            trials++
        } else {
            println("Ihr Vorname ist:$firstName")
            user.firstName = firstName
            userList.add(user)

            return true
        }
    }
    println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
    return false
}

fun checkLastName(): Boolean {
    var trials = 0
    var maxTrials = 3
    while (trials < maxTrials) {
        println("Geben Sie bitte Ihren Nachnamen ein:")
        var lastName = readln()
        if (lastName.isNullOrEmpty() || !lastName.all { it.isLetter() }) {
            println("Der Nachname darf nicht null,leer oder Zahlen sein!!")
            trials++
        } else {
            println("Ihr Nachname ist:$lastName")
            user.lastName = lastName
            userList.add(user)
            return true
        }
    }

    println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
    return false
}


/*
-------------------------------------------------------Alter--------------------------------------------------------
In dieser Abteilung werden zwei Methoden gebaut.
1-Die Methode 'isAgeValid':
In dieser Methode wird 'age' zuerst als 'String' definiert, um zu prüfen, ob die Eingabe 'age' leer, null, oder aber
Buchstaben ist.
Falls nicht, gibt die Methode 'null' zurück, dann wird die Eingabe in 'Int' umgewandelt, um zu prüfen, ob sie
weniger als 12 ist.
Falls ja, gibt die Methode 'null' zurück.
Falls nicht, gibt die Methode 'age' als Integer zurück.

2-Die Methode 'customerAge':
diese Methode übernimmt den Wert 'age' von der Methode 'isAgeValid' und überprüft, ob 'age' 'null' ist.
Diese Methode verfügt eine While-Schleife, um dem Benutzer zu ermöglichen, die Eingabe wieder einzugeben, wenn sie
'null' ist.
 */
fun isAgeValid(): Int? {
    println("Geben Sie bitte Ihr Alter ein:")
    var age = readln()
    if (age.isNullOrEmpty() || age.all { it.isLetter() }) {
        println("Das Alter darf nicht null oder leer oder Buchstaben sein.")
        return null
    } else {
        val ageInt = age.toIntOrNull()
        if (ageInt == null) {
            println("Das Alter muss eine Zahl sein.")
            return null
        } else if (ageInt < 12) {
            println("Wir entschuldigen uns, aber als unter 12 dürfen Sie nicht registrieren!")
            return null
        } else {
            return ageInt
        }
    }
}

fun customerAge(): Boolean {
    var trials = 0
    val maxTrials = 3

    while (trials < maxTrials) {
        val age = isAgeValid()
        if (age == null) {
            trials++
            if (trials < maxTrials) {
                println("Wiederholen Sie bitte die Eingabe")
            }
        } else {
            user.age = age
            userList.add(user)
            return true
        }
    }
    println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
    return false
}

/*
-----------------------------------------------------e-Mail-------------------------------------------------------
In dieser Abteilung werden drei Methoden gebaut:
1-Die Methode 'isValidEmail':
Diese Methode hat die Parameter 'email→String' und überprüft, ob die vom Benutzer eingegebene E-Mail das Muster
der E-Mail entspricht oder nicht.
'matches' wird verwendet, um der Vergleich zwischen 'email' und 'Muster' auszuführen, sie gibt zurück 'false' oder 'true'.

2-Die Methode 'isEmailRegisted':
Diese Methode hat die Parameters 'user→ List<Users>', 'email→ String'
Sie überprüft, ob die vom Benutzer eingegebene E-Mail schon registriert oder nicht.
Sie gibt zurück 'false' wenn nicht und 'true' wenn ja.

3-Die Methode 'checkEmailInfo':
Sie ruft die Methode, 'isValidEmail' auf und überprüft zusätzlich, ob die E-Mail schon registriert oder nicht.
 */
fun isValidEmail(email: String): Boolean {
    val emailPattern = Regex("^[a-z\\d.]+@[a-z\\d]+\\.[a-z]{2,}\$")
    return emailPattern.matches(email)
}

fun isEmailRegisted(email: String): Boolean {
    for (user in userList) {
        if (user.eMail == email) {
            return true
        }
    }
    return false
}

fun checkEmailInfo(): Boolean {
    var trials = 0
    var maxTrials = 3
    var email: String = ""

    while (trials < maxTrials) {
        println("Geben Sie bitte eine gültige e-Mail Adresse ein: ")
        email = readln()
        val checkValidity = isValidEmail(email)
        val checkExistence = isEmailRegisted(email)
        if (checkExistence || !checkValidity) {
            println("Ungültige e-Mail Adresse oder sie ist schon registriert!!")
            trials++
        } else if (!checkExistence && checkValidity) {
            user.eMail = email
            userList.add(user)
            println("Ihre e-Mail Adresse ist $email")
            return true
        }
    }

    println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
    return false
}

/*
-----------------------------------------------------Kennwort-------------------------------------------------------
*/
fun istValidPassword(password: String): Boolean {
    val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,}$")
    return passwordPattern.matches(password)
}

fun checkPassword(): Boolean {
    var trials = 0
    var maxTrials = 3
    while (trials < maxTrials) {
        println(
            "Geben Sie bitte ein gültiges Kennwort ein:\n" +
                    "Das Kennwort muss:\n" +
                    "* mind.8 Zeichen sein.\n" +
                    "* mind.1 kleinen Buchstabe enthalten.\n" +
                    "* mind.1 großen Buchstabe enthalten.\n" +
                    "* mind.1 Zahl enthalten\n" +
                    "* keine Symbole enthalten"
        )
        var passWord = readln()
        var checkValidity = istValidPassword(passWord)
        if (!checkValidity) {
            println("Ihr Kennwort entspricht nicht die Bedienungen ")
            trials++
        } else {
            println("Ihr Kennwort wurde erfolgreich abgespeichert")
            return true
        }
    }

    println("Sie haben die maximale Anzahl an Versuchen überschritten!! ")
    return false

}









