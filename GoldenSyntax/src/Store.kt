import produkte.products.Products
import benutzer.Customers
class Store(val name: String, val minAge: Int, var products: MutableList<Products> = mutableListOf(), var customers: MutableList<Customers> = mutableListOf()) {
    fun addProduct(product: Products) {
        products.add(product)
    }

    fun removeProduct(product: Products) {
        products.remove(product)
    }

    fun reorderProduct(product: Products, quantity: Int) {
        // Code zum Nachbestellen von Produkten
    }

    fun addCustomer(customer: Customers) {
        customers.add(customer)
    }

    fun removeCustomer(customer: Customers) {
        customers.remove(customer)
    }
}