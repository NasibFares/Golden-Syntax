package functios

import benutzer.Users
import produkte.Categories
import produkte.Subcategories
import produkte.products.Products
import produkte.products.clothes.TShirts
import produkte.products.clothes.Shoes
import produkte.products.clothes.Trousers
import produkte.products.electronics.Mobiles
import produkte.products.electronics.Microwaves
import produkte.products.electronics.TVs
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
                    println("Sie haben sich erfolgreich als [${user.firstName} ${user.lastName}]:Operator angemeldet.")
                    operatorOption()
                } else {
                    println("Sie haben sich erfolgreich als [${user.firstName} ${user.lastName}]:Kundin/e angemeldet.")
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




/*
Die Methode 'sortedProducts' sortiert die Liste der Produkte anhand der Kategorie und Unterkategorie.
Danach wird die Liste in einer bestimmten Form angezeigt, um eine bessere sichtbar für die Kunden zu verfügen.
*/
fun sortedProducts(sortedProducts: MutableList<Products> = mutableListOf()) {

    //Eine Variable wird erstellt, um die aktuelle Kategorie zu verfolgen.
    var currentCategory: Categories? = null
    // Eine Variable wird erstellt, um die aktuelle Unterkategorie zu verfolgen.
    var currentSubcategory: Subcategories? = null
    // Für jede Produkte in der Liste 'finalProductsList'.
    sortedProducts.forEach { product ->
        // Wenn die Kategorie sich ändert.
        if (product.category != currentCategory) {
            // Gib den Namen der Kategorie in der Konsole.
            println("\nKategorie: ${product.category}")
            // Die aktuelle Kategorie aktualisieren aktuelle Kategorie = Die Kategorie des Produkts.
            currentCategory = product.category
            // Die aktuelle Unterkategorie zurücksetzen.
            currentSubcategory = null
        }
        // Wenn die Unterkategorie der aktuellen Kategorie sich ändert.
        if (product.subCategory != currentSubcategory) {
            // Gib die neue Unterkategorie in der Konsole
            println("\nUnterkategorie: ${product.subCategory}")
            // Hier sind die Einstellungen des Headers für jede Unterkategorie:
            when (product) {
                is Microwaves -> println(
                    "%-3s %-20s %-10s %-20s %-10s %-20s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Color",
                        "Capacity",
                        "Material",
                        "Watt",
                        "Qty"
                    )
                ) // print the header for Microwaves
                is Mobiles -> println(
                    "%-3s %-30s %-10s %-10s %-10s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Color",
                        "Storage",
                        "OperatingSystem",
                        "Qty"
                    )
                ) // print the header for Mobiles
                is TVs -> println(
                    "%-3s %-30s %-10s %-10s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Size",
                        "Resolution",
                        "Qty"
                    )
                ) // print the header for TVs
                is Shoes -> println(
                    "%-3s %-30s %-10s %-10s %-10s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Size",
                        "Gender",
                        "Color",
                        "Qty"
                    )
                )

                else -> println(
                    "%-3s %-60s %-10s %-10s %-10s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Size",
                        "Gender",
                        "Color",
                        "Qty"
                    )
                ) // print the header for other products
            }
            // Die aktuelle Unterkategorie aktualisieren aktuelle Unterkategorie= Die Unterkategorie des Produkts.
            currentSubcategory = product.subCategory
        }
        //Hier sind die Einstellungen für die Abstände zwischen den Spalten, die die Informationen des Produkts enthalten.
        when (product) {
            is TShirts -> println(
                "%-3d %-60s %-10.2f %-10s %-10s %-10s %d".format(
                    finalProductsList.indexOf(product),
                    product.name,
                    product.price,
                    product.size,
                    product.gender,
                    product.color,
                    product.qty
                )
            )

            is Shoes -> println(
                "%-3d %-30s %-10.2f %-10s %-10s %-10s %d".format(
                    finalProductsList.indexOf(product),
                    product.name,
                    product.price,
                    product.size,
                    product.gender,
                    product.color,
                    product.qty
                )
            )

            is Trousers -> println(
                "%-3d %-60s %-10.2f %-10s %-10s %-10s %d".format(
                    finalProductsList.indexOf(
                        product
                    ), product.name, product.price, product.size, product.gender, product.color, product.qty
                )
            )

            is Microwaves -> println(
                "%-3d %-20s %-10.2f %-20s %-10s %-20s %-10d %d".format(
                    finalProductsList.indexOf(
                        product
                    ),
                    product.name,
                    product.price,
                    product.color,
                    product.capacity,
                    product.material,
                    product.watt,
                    product.qty
                )
            )

            is Mobiles -> println(
                "%-3d %-30s %-10.2f".format(
                    finalProductsList.indexOf(product),
                    product.name,
                    product.price,
                    product.color,
                    product.storage,
                    product.operatingSystem,
                    product.qty
                )
            )

            is TVs -> println(
                "%-3d %-30s %-10.2f".format(
                    finalProductsList.indexOf(product),
                    product.name,
                    product.price,
                    product.size,
                    product.resolution
                )
            )
        }
    }
}

/*
In der Methode 'productsSortingMethod' könnte der Benutzer die Weise auswählen, wie die Produkte sortiert werden sollen.
Hiermit sind zwei Möglichkeiten verfügbar:
1. Nach dem Preis des Produkts.
2. Nach dem Namen des Produkts.
Die Methode 'sortedProducts' wird innerhalb dieser Methode aufgerufen.
 */
fun productsSortingMethod() {
    println(
        "Wählen Sie die Art und Weise, wie die Produkte sortiert werden sollen:\n" +
                "1. Nach dem Preis des Produkt\n" +
                "2. Nach dem Namen des Produkts"
    )
    val sortOption = readln().toInt()
    if (sortOption == 1) {
        val sortedProducts =
            finalProductsList.sortedWith(compareBy({ it.category }, { it.subCategory }, { it.price }))
                .toMutableList()
        sortedProducts(sortedProducts)
    } else if (sortOption == 2) {
        val sortedProducts =
            finalProductsList.sortedWith(compareBy({ it.category }, { it.subCategory }, { it.name }))
                .toMutableList()
        sortedProducts(sortedProducts)
    }
}




