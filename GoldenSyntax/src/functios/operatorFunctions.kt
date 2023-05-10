package functios

import produkte.Categories
import kotlin.system.exitProcess

fun operatorOption() {
    var task: Int
    do {
        var trials = 0
        val maxTrials = 2
        do {
            println("Wählen Sie eine Aufgabe aus:")
            println("1. Ein Produkt hinzufügen.")
            println("2. Ein Produkt löschen.")
            println("3. Produkte nachbestellen.")
            println("4. Abmelden")
            print("Eingabe: ")
            task = readlnOrNull()?.toIntOrNull() ?: 0
            trials++
        } while ((task != 1 && task != 2 && task != 3 && task != 4) && (trials < maxTrials))

        if (trials >= maxTrials) {
            println("Sie haben die maximale Anzahl an Versuchen überschritten!!")
            exitProcess(0)
        }
        when (task) {
            1 -> addNewProduct()
            2 -> deleteProduct()
            3 -> productReorder()
            4 -> exitProcess(0)
            else -> println("Ungültige Eingabe")
        }
    } while (task != 4)
}
/*
-----------------------------------------2. Produkt löschen(Operator Aufgabe)-------------------------------------------
*/
fun deleteProduct() {
    sortedProducts()
    /*
    --------------------------------2.1. Eine Kategorie muss ausgewählt werden-----------------------------------
     */
    println("Zu welcher Kategorie gehört das Produkt:")
    Categories.values().forEachIndexed { index, category ->
        println("${index + 1}. ${category.name}")
    }
    val categoryIndex = readlnOrNull()?.toIntOrNull()?.minus(1) ?: return
    val category = Categories.values().getOrNull(categoryIndex) ?: return
    /*
    --------------------------------2.2. Eine Unterkategorie muss ausgewählt werden-----------------------------------
     */
    println("Zu welcher Unterkategorie gehört das Produkt:")
    category.subcategories.forEachIndexed { index, subcategory ->
        println("${index + 1}. ${subcategory.name}")
    }
    val subcategoryIndex = readlnOrNull()?.toIntOrNull()?.minus(1) ?: return
    val subcategory = category.subcategories.getOrNull(subcategoryIndex) ?: return


    val matchingProducts = finalProductsList.filter { it.category == category && it.subCategory == subcategory }
    if (matchingProducts.isEmpty()) {
        println("No products found matching category $category and subcategory $subcategory.")
        return
    }
    println("Please choose a product to delete:")
    for ((index, product) in matchingProducts.withIndex()) {
        println("${index + 1}. ${product.name}")
    }
    val userInput = readlnOrNull()?.toIntOrNull()
    if (userInput == null || userInput !in 1..matchingProducts.size) {
        println("Invalid input.")
        return
    }
    val productToDelete = matchingProducts[userInput - 1]
    finalProductsList.remove(productToDelete)
    println("Das Produkt '${productToDelete.name}' wurde erfolgreich gelöscht.")
}
/*
--------------------------------------3. Produkt nachbestellen(Operator Aufgabe)----------------------------------------
*/

fun productReorder() {
    //Die Methode „sortedProducts“ wird aufgerufen, um einen Überblick über das Lager zu erhalten.
    sortedProducts()
    /*
    --------------------------------3.1. Eine Kategorie muss ausgewählt werden-----------------------------------
     */
    //Die Wahl der Kategorie des Produkts, das nachbestellt werden soll.
    println("Zu welcher Kategorie gehört das Produkt:")
    //Die Kategorien werden angezeigt.
    Categories.values().forEachIndexed { index, category ->
        println("${index + 1}. ${category.name}")
    }
    val categoryIndex = readlnOrNull()?.toIntOrNull()?.minus(1) ?: return
    val category = Categories.values().getOrNull(categoryIndex) ?: return
    /*
    --------------------------------3.2. Eine Unterkategorie muss ausgewählt werden-------------------------------
     */
    //Die Wahl der Unterkategorie des Produkts, das nachbestellt werden soll.
    println("Zu welcher Unterkategorie gehört das Produkt:")
    //Die Unterkategorien werden angezeigt.
    category.subcategories.forEachIndexed { index, subcategory ->
        println("${index + 1}. ${subcategory.name}")
    }
    val subcategoryIndex = readlnOrNull()?.toIntOrNull()?.minus(1) ?: return
    val subcategory = category.subcategories.getOrNull(subcategoryIndex) ?: return

    //Anhand der ausgewählten Kategorie und Unterkategorien wird die Produktliste gefiltert.
    val matchingProducts = finalProductsList.filter { it.category == category && it.subCategory == subcategory }
    if (matchingProducts.isEmpty()) {
        println("Keine Produkte befinden sich unter Kategorie: $category und Unterkategorie $subcategory.")
        return
    }
    println("Wählen Sie bitte das Produkt, das nachbestellt werden soll:")
    for ((index, product) in matchingProducts.withIndex()) {
        println("${index + 1}. ${product.name}. ${product.qty}")
    }
    val userInput = readlnOrNull()?.toIntOrNull()
    if (userInput == null || userInput !in 1..matchingProducts.size) {
        println("Invalid input.")
        return
    }
    val reorderedProduct = matchingProducts[userInput - 1]
    println("Geben Sie die zu bestellende Menge ein:")
    val orderQty = readln().toInt()
    val bestand = reorderedProduct.qty + orderQty
    reorderedProduct.qty = bestand
    println("Der Bestand des Produkts: ${reorderedProduct.name}. wurde sich um $orderQty erhöht. Neuer Bestand: $bestand")
}
