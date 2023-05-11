import benutzer.Customers
import benutzer.PaymentOptions
import benutzer.Users
import functios.*
import produkte.products.finalProductsList

val operator = Users("Nasib", "Fares", "operator@gmail.com", 45, "test", true)
val normalCustomer = Users("jack", "jack", "customer@gmail.com", 15, "test", false)
val customer = Customers(
    "", "", "", 13, "", false, finalProductsList,

    mutableMapOf(
        1 to PaymentOptions("Lastschrift", 100.0),
        2 to PaymentOptions("PayPal", 50.0),
        3 to PaymentOptions("Kreditkarte", 200.0)
    )
)

fun main() {

    userList.add(operator)
    userList.add(normalCustomer)

    registerLoginLogout()

    if (user.adminRight) {
        operatorOption()

    } else {
        customerOptions()
    }


}

