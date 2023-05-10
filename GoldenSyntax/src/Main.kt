import benutzer.Users
import functios.*


fun main() {
    val me = Users("Nasib", "Fares", "operator@gmail.com", 45, "Operator2023", true)
    val customer:Users=Users("jack","jack","jack@gmail.com",15,"Jack2023",false)

    userList.add(me)
    userList.add(customer)
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

