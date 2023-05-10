import benutzer.Customers
import benutzer.Users
import functios.*

val operator = Users("Nasib", "Fares", "operator@gmail.com", 45, "test", true)
val normalCustomer=Users("jack","jack","customer@gmail.com",15,"test",false)
val customer= Customers("","","",13,"",false, finalProductsList,"",0.0)
fun main() {

    userList.add(operator)
    userList.add(normalCustomer)
  registerLoginLogout()


    if (user.adminRight){
        operatorOption()
    }else{
        customerOptions()
    }


    //addNewProduct()
  //deleteProduct()

    //productReorder()




}

