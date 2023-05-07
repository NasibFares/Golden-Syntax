package benutzer

/*
Die 'Regex-Klasse' in Kotlin wird verwendet, um ein reguläres Ausdrucksmuster darzustellen, das für den Textabgleich oder
die Validierung verwendet werden kann.
 */
open class Users(
    var firstName: String,
    var lastName: String,
    var eMail: String,
    var age: Int,
    val passWord: String,
    val adminRight: Boolean

) {


    var usersList: MutableList<Users> = mutableListOf()


}


/*
fun isValidEmail(email: String): Boolean {
    return emailPattern.matches(email)
fun isValidPassword(password: String): Boolean {
    return passwordPattern.matches(password)
}
}

 */

