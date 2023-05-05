package benutzer

import produkte.products.Products

open class Operators(
    firstName: String,
    lastName: String,
    eMail: String,
    passWord: String,
    adminRight: Boolean,
) : Users(firstName, lastName, eMail, passWord) {
}