import benutzer.Customers
import benutzer.Users
import kotlin.concurrent.thread

fun main() {
val user=Users("","","","")
    registerOrLogin()
    println(user.usersList)

}

