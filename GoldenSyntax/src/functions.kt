import benutzer.Customers
import benutzer.Users
var user=Users("","","",0,"")
var userList: MutableList<Users> = mutableListOf()
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

/*
----------------------------------------------------Registrierung-----------------------------------------------------
 Die Methode 'register' ruft verschiedenen Methoden auf, die zu Registrierung gehören.
 Jede Methode wird ausgeführt, wenn die vorherige Methode vom Benutzer richtig ausgeführt ist.
 z.B wenn der Benutzer sein Name richtig eingegeben hat, wird die Methode checkNachname ausgeführt.
 */
fun register() {

    val users: MutableList<Users> = mutableListOf()

    if (checkFirstName()) {
        if (checkLastName()) {
            if (customerAge()) {
                if (checkEmailInfo(users)) {
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
            user.firstName=firstName
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
            user.lastName=lastName
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
in dieser Methode wird 'age' zuerst als 'String' definiert, um zu prüfen, ob die Eingabe 'age' leer, null, oder aber
Buchstaben ist.
Falls nicht, wird die Eingabe in 'Int' umgewandelt, um zu prüfen, ob sie weniger als 12 ist.
Falls nicht, nimmt die Variable 'ageValid: Boolean' den Wert 'true', dieser Wert wird zurückgegeben.

2-Die Methode 'customerAge':
diese Methode übernimmt den Wert 'ageValid' von der Methode 'isAgeValid' und überprüft, ob er 'false' oder 'true' ist.
Diese Methode verfügt eine While-Schleife, um dem Benutzer zu ermöglichen, die Eingabe wieder einzugeben, wenn sie
falsch ist.
 */
fun isAgeValid(): Int?{
    println("Geben Sie bitte Ihr Alter ein:")
    var age = readln()
    if (age.isNullOrEmpty() || age.all { it.isLetter() }) {
        println("Das Alter darf nicht null oder leer oder Buchstaben sein.")
        return null
    } else if (age.toInt() < 12) {
        println("Wir entschuldigung uns, als unter 12 dürfen Sie nicht registrieren!!")
        return null
    } else {
        return age.toInt()
    }
}

fun customerAge(): Boolean {
    var trials = 0
    val maxTrials = 3

    while (trials < maxTrials) {
        val age=isAgeValid()
        if (age==null) {
            trials++
            if (trials < maxTrials) {
                println("Wiederholen Sie bitte die Eingabe")
            }
        } else {
            user.age=age
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

fun isEmailRegisted(users: List<Users>, email: String): Boolean {
    for (user in users) {
        if (user.eMail == email) {
            return true
        }
    }
    return false
}

fun checkEmailInfo(
    users: MutableList<Users>,
): Boolean {
    var trials = 0
    var maxTrials = 3
    var email: String = ""

    while (trials < maxTrials) {
        println("Geben Sie bitte eine gültige e-Mail Adresse ein: ")
        email = readln()
        val checkValidity = isValidEmail(email)
        val checkExistence = isEmailRegisted(users, email)
        if (checkExistence || !checkValidity) {
            println("Ungültige e-Mail Adresse")
            trials++
        } else if (!checkExistence && checkValidity) {
            println("Ihre e-Mail Adresse ist $email")
            user.eMail=email
            userList.add(user)
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
        println("Geben Sie ein gültigen Kennwort [nicht mehr als 8 Character] ein:")
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



