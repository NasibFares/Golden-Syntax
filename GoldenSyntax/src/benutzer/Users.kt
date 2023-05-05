package benutzer
/*
Die 'Regex-Klasse' in Kotlin wird verwendet, um ein reguläres Ausdrucksmuster darzustellen, das für den Textabgleich oder
die Validierung verwendet werden kann.
 */
class Users(
    var firstName: String,
    var lastName: String,
    var eMail:String,
    var age:Int,
    val password:String

) {

}


/*
fun isValidEmail(email: String): Boolean {
    return emailPattern.matches(email)
fun isValidPassword(password: String): Boolean {
    return passwordPattern.matches(password)
}
}

 */

