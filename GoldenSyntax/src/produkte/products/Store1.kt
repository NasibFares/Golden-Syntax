package produkte.products

import benutzer.Customers

class Store1(
    val name: String,
    val minAge: Int,
    val products: MutableList<Store> = mutableListOf<Store>(),
    var customers: MutableList<Customers> = mutableListOf()
) {
    fun addProduct(product: Store) {
        products.add(product)
    }

    fun removeProduct(product: Store) {
        products.remove(product)
    }

    fun reorderProduct(product: Store, quantity: Int) {
        // Code zum Nachbestellen von Produkten
    }

    fun addCustomer(customer: Customers) {
        customers.add(customer)
    }

    fun removeCustomer(customer: Customers) {
        customers.remove(customer)
    }
}