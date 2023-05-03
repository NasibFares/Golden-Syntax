package users

open class Customers(eMail: String, adminRight: Boolean, var firstName: String, var lastName: String, var alter: Int) :
    Users(eMail, adminRight) {
}