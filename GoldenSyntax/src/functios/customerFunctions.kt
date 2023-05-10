package functios

import produkte.products.Products
import kotlin.system.exitProcess

/*
----------------------------------------3. Ein Produkt suchen(Kunde Option)---------------------------------------------
*/
fun kundeOptionen() {
    var option: Int
    do {
        var trials = 0
        val maxTrials = 2
        do {
            println("Wählen Sie eine Option aus:")
            println("1. Produkt anhand seines Namens suchen")
            println("2. Produkte nach ihrer Kategorie und Unterkategorie")
            println("3. Produkte bestellen.")
            println("4. Produkt einkaufen.")
            println("5. Abmelden")
            print("Eingabe: ")
            option = readlnOrNull()?.toIntOrNull() ?: 0
            trials++
        } while ((option !in listOf(1,2,3,4,5,6)) && (trials < maxTrials))

        if (trials >= maxTrials) {
            println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
            exitProcess(0)
        }
        when (option) {
            1 -> searchProductByName()
            2 -> searchProductBySubCategory()
            3 -> searchProductByCategory()
            4-> addProductToCart()
            5-> buyProduct()
            6-> exitProcess(0)
            else -> println("Ungültige Eingabe")
        }
    } while (option != 6)
}

fun searchProductByName(): List<Products>? {
    print("Geben Sie bitte die ersten Buchstaben des Produkts ein: ")
    val name = readln().toLowerCase()
    val matchingProducts = finalProductsList.filter {
        it.name.toLowerCase().contains(name)
    }
    if (matchingProducts.isNotEmpty()) {
        println("Gefundene Produkte:")
        matchingProducts.forEach { product ->
            println("Name: ${product.name}. Bestand: ${product.qty} ID: ${finalProductsList.indexOf(product)}")
        }
        return matchingProducts
    } else {
        println("Kein Produkt gefunden.")
        return null
    }
}

fun searchProductBySubCategory() {

}

fun searchProductByCategory() {

}
fun buyProduct(){

}
fun addProductToCart(){

}
fun moveProductToCart(){

}

