import benutzer.Users
import functios.*


fun main() {
    val me = Users("Nasib", "Fares", "nasib.y.fares@gmail.com", 45, "Nasib1978", true)
    val customer:Users=Users("jack","jack","jack@gmail.com",15,"Jack2023",false)

    userList.add(me)
    userList.add(customer)
    registerLoginLogout()
    if (user.adminRight){
        operatorOption()
    }else{
        kundeOptionen()
    }
    //addNewProduct()
  //deleteProduct()
  //productsSortingMethod()
    //productReorder()




}

