import kotlin.concurrent.thread

fun main() {
    var maxAttempts = 3
    var attempts = 0
    println(
        "Herzlichen Willkommen in unserem [Golden-Syntax] online-shop:\n" +
                "Wählen Sie bitte eine Option aus:\n1.Registrieren\n2.Anmelden"
    )
    var wahl = readln().toInt()

    try {
        if (wahl == 1) {                                    //Anmelden
            println("Geben Sie bitte eine gültige e-Mail Adresse ein")
            val email = readln()
            var check = isValidEmail(email)
            for (i in 1..maxAttempts) {
                while (!check) {
                    println(
                        "Ungültige e-Mail Adresse!!\n" +
                                "Die eMail sollte nur kleine Buchstaben,Zahlen,Punkte enthalten\n" +
                                "Sie haben noch ${maxAttempts - 1} "
                    )
                }
                maxAttempts-=1
                if (check) {
                    println("Geben Sie bitte Ihr Kennwort ein: ")
                    break
                }
            }

        } else if (wahl == 2) {
            // Hier kommt der Code der Registrierung
        } else {
            thread { println("Sie haben ungültige Option gewählt!!") }
        }
    } catch (e: Exception) {
        println("Ungültige Option")
    }
}