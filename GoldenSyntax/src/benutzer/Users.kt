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


}




