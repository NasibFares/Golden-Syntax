class Login (var usenName:String, private var passWord:String){
    private val passwordPattern= "^(?=.*[0-9])(?=.*[a-zA-Z])(?=.*[@#\$%^&+=])(?=\\S+\$).{8,}\$".toRegex()

    fun passwordValidation(){
        do {
            print("Enter your password: ")
            passWord = readlnOrNull() ?: ""
        } while (!passWord.matches(passwordPattern))
    }

}

