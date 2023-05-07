package benutzer

import produkte.products.Products

open class Operators(
    firstName: String,
    lastName: String,
    eMail: String,
    age:Int,
    passWord: String,
    adminRight: Boolean,
) : Users(firstName, lastName, eMail, age,passWord,adminRight) {
}