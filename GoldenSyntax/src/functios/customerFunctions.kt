package functios
import benutzer.Customers
import produkte.Categories
import produkte.Subcategories
import produkte.products.Products
import kotlin.system.exitProcess

/*
----------------------------------------3. Ein Produkt suchen(Kunde Option)---------------------------------------------
*/
fun customerOptions() {
    var option: Int
    do {
        var trials = 0
        val maxTrials = 2
        do {
            println("**Herzlich Willkommen in unserem Golden-Syntax**")
            println("Wählen Sie eine Option aus:")
            println("1. Gesamtübersicht aller Produkte.")
            println("2. Produkt anhand seines Namens suchen.")
            println("3. Produkte nach ihrer Kategorie suchen.")
            println("4. Produkte nach ihrer Unterkategorie suchen.")
            println("5. Produkte zum Warenkorb hinzufügen")
            println("6. Produkt einkaufen.")
            println("7. Abmelden")
            print("Eingabe: ")
            option = readlnOrNull()?.toIntOrNull() ?: 0
            trials++
        } while ((option !in listOf(1, 2, 3, 4, 5, 6, 7)) && (trials < maxTrials))

        if (trials >= maxTrials) {
            println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
            exitProcess(0)
        }
        when (option) {
            1 -> sortedProducts(finalProductsList)
            2 -> searchProductByName()
            3 -> searchProductByCategory()
            4 -> searchProductBySubCategory()
            5 -> Customers().addProductToCart()
            6 -> buyProduct()
            7 -> exitProcess(0)
            else -> println("Ungültige Eingabe")
        }
    } while (option != 7)
}

fun searchProductByName(): List<Products>? {
    print("Geben Sie bitte die ersten Buchstaben des Produkts ein: ")
    val name = readln().lowercase()
    val matchingProducts = finalProductsList.filter {
        it.name.lowercase().contains(name)
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
    println("Wählen Sie die gewünschte Unterkategorie aus: ")
    Subcategories.values().forEachIndexed { index, subcategory -> println("${index + 1}. ${subcategory.name}") }
    val subCategoryIndex = readlnOrNull()?.toIntOrNull()?.minus(1) ?: return
    val subCategory = Subcategories.values().getOrNull(subCategoryIndex) ?: return
    val productsBySubcategory = finalProductsList.filter { it.subCategory == subCategory }.toMutableList()
    sortedProducts(productsBySubcategory)
    println("\n")
    Thread.sleep(1200)

}

fun searchProductByCategory() {
    println("Wählen Sie die gewünschte Kategorie aus: ")
    Categories.values().forEachIndexed { index, category -> println("${index + 1}. ${category.name}") }
    val categoryIndex = readlnOrNull()?.toIntOrNull()?.minus(1) ?: return
    val category = Categories.values().getOrNull(categoryIndex) ?: return
    val productsByCategory = finalProductsList.filter { it.category == category }.toMutableList()
    sortedProducts(productsByCategory)
    println("\n")
    Thread.sleep(1200)
}

fun buyProduct() {

}




