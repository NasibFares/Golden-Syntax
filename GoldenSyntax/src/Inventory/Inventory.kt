package Inventory

class Inventory { val products:MutableList<Products> = mutableListOf<Products>()
    fun addItem(product: Products) {
        products.add(product)
    }



}