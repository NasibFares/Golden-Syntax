package functios
import produkte.Categories
import produkte.Subcategories
import produkte.products.Store
import produkte.products.finalProductsList
import kotlin.system.exitProcess

/*
----------------------------------------3. Ein Produkt suchen(Kunde Option)---------------------------------------------
*/
fun customerOptions() {
    var cartIntern: MutableList<Store> = mutableListOf()
    var shoppedQtyList: MutableList<Int> = mutableListOf()
    var option: Int
    var totalPrice = 0.0
    var itemQty = 0


    do {

        var trials = 0
        val maxTrials = 2

        for (i in cartIntern.indices) {
            totalPrice +=  cartIntern[i].price * shoppedQtyList[i]
            itemQty += shoppedQtyList[i]
        }

        do {
            println("**Herzlich Willkommen in unserem Golden-Syntax**")
            println("Warenkorb: Artikelmenge $itemQty , GesamtPreis: $totalPrice\n")
            println("Wählen Sie eine Option aus:")
            println("1. Gesamtübersicht aller Produkte.")
            println("2. Produkt anhand seines Namens suchen.")
            println("3. Produkte nach ihrer Kategorie suchen.")
            println("4. Produkte nach ihrer Unterkategorie suchen.")
            println("5. Produkte zum Warenkorb hinzufügen und kaufen.")
            println("6. Produkt bewerten.")
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
            1 -> try{
                productsSortingMethod()
            }catch(e:Exception){
                println("Sie haben leider ungültige Eingabe eingegeben.")
            }
            2 -> searchProductByName()
            3 -> searchProductByCategory()
            4 -> searchProductBySubCategory()
            5 -> {
                val test: Pair<MutableList<Int>, MutableList<Store>> = addProductToShoppingCartAndBuyIt(cartIntern)
                (cartIntern) = test.second
                shoppedQtyList = test.first
            }

            6 -> try{
                productEvaluation()
            }catch (e:Exception){
                println("Sie haben leider ungültige Eingabe eingegeben.")
            }
            7 -> {
                //TODO: returnProduktFromCartShop
                exitProcess(0)
            }

            else -> println("Ungültige Eingabe")
        }

    } while (option != 7)


}
fun searchProductByName(): List<Store>? {
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
/*
    Die Methode 'addToCart' ermöglicht dem Kunden, die lieblingsprodukte in Warenkorb hinzufügen.
    Als Parameter übernimmt diese Methode 'product→ bezieht sich auf ein Produkt von der Liste Produkte'
     */
fun addProductToShoppingCartAndBuyIt(shoppingCart: MutableList<Store>): Pair<MutableList<Int>, MutableList<Store>> {

    println("Geben Sie bitte die ID des Produkts:")
    //Die ID des Produkts, das zum Warenkorb hinzugefügt wird.
    var addedProductID = readln().toIntOrNull()
    //Eine Liste von Mengen der Produkte, die zum Warenkorb hinzugefügt werden.
    var addedQtys: MutableList<Int> = mutableListOf()
    //Prüfen, ob die ID des Produkts nicht 'null' ist
    if (addedProductID != null) {
        //Wenn nicht 'null', wird das Produkt zum Warenkorb hinzugefügt.
        shoppingCart.add(finalProductsList[addedProductID])
        //Frage an Kunde, wie viele Stücke von diesem Produkt er zum Warenkorb hinzufügen möchte.
        println("Wie viele Stücke möchten Sie hinzufügen?")
        val qty = readln().toIntOrNull()
        //Prüfen, ob die Menge 'null' ist.
        if (qty != null) {
            //Wenn die Menge nicht 'null' ist, wird geprüft, ob die Menge nicht großer als die Menge im Store.
            if (finalProductsList[addedProductID].qty - qty >= 0) {
                //Wenn nicht, wird diese Menge zum Warenkorb hinzugefügt
                addedQtys.add(qty)
                //finalProductsList[addedProductID].qty -= qty
                println("Das Produkt: ${finalProductsList[addedProductID].name} wurde erfolgreich zu Ihrem Warenkorb hinzugefügt.\n" +
                        "Anzahl: $qty Stücke\n " +
                        "Gesamtpreis: ${finalProductsList[addedProductID].price * qty}€\n" +
                        "ID: ${shoppingCart.indexOf(finalProductsList[addedProductID])+1}")
            }else{
                println("Die Menge des Produkt im Store reicht nicht aus.")

            }
        }else{
            println("Sie haben ungültige Menge eingegeben!! ")
        }
    }else{
        println("Ungültige Eingabe, das Produkt existiert nicht. ")
    }
    println("Möchten Sie die Produkte in Ihrem Warenkorb einkaufen? (ja/nein)")
    var answer = readln()
    if (answer != null && answer.all {it.isLetter()} && answer in listOf("ja","nein")) {
        if (answer == "ja") {
            println("Geben Sie die ID des Produkts ein:")
            var productId = readln()  //ich habe 1 eingegeben.
            if (productId != null && !productId.all { it.isLetter() }) {
                // Suche im Warenkorb nach dem Produkt mit der eingegebenen ID
                if(productId.toInt()-1 in shoppingCart.indices){
                    println("Sie haben das Produkt ${shoppingCart[ productId.toInt() - 1].name} ausgewählt")
                    // Wenn das Produkt gefunden wurde, fragen Sie nach der Anzahl, die der Kunde kaufen möchte
                    println("Wie viele Stücke möchten Sie von ${shoppingCart[productId.toInt()].name} kaufen?")
                    val toBuyQty = readln().toIntOrNull()
                    if (toBuyQty != null && toBuyQty > 0 && toBuyQty <= addedQtys.last()) {
                        println(
                            "$toBuyQty Stücke von ${shoppingCart.last().name} wurden erfolgreich im Gesamtwert von " +
                                    "${toBuyQty * shoppingCart.last().price} € gekauft."
                        )
                        // Entferne die gekaufte Menge aus der hinzugefügten Quantitätsliste
                        addedQtys[addedQtys.lastIndex] -= toBuyQty
                    } else {
                        println("Ungültige Eingabe oder die Menge des Produkts im Warenkorb reicht nicht aus!! ")
                        // Don't subtract the invalid quantity from the addedQtys list
                    }

                }else{
                    println("Das gewählte Produkt ist nict in Ihrem Warenkorb!!")
                }
            }else{
                println("Ungültige Eingabe oder das Produkt existiert nicht!!")
            }
        }else{
            exitProcess(0)
        }
    }else{
        exitProcess(0)
    }
    return Pair(addedQtys, shoppingCart)

}

//TODO:
fun returnProduktToShop(qtyBought: MutableList<Int>, myCart: MutableList<Store>) {
   // ich habe es nicht erledigt, die Zeit reicht nicht.
}
fun productEvaluation(){
    println("Wählen Sie bitte eine ID des Produkts aus")
    val productToEvaluate=readln().toInt()
    if(productToEvaluate in finalProductsList.indices){
        println("Sie haben das Produkt: ${finalProductsList[productToEvaluate].name} zum Bewerten gewählt.\n" +
                "Die aktuelle Bewertung dieses Produkt ist: ${finalProductsList[productToEvaluate].evaluation} Sterne ")
        print("Geben Sie bitte Ihre Bewertung ein (1..5): Eingabe:")
        val customerBewertung=readln().toDouble()
        finalProductsList[productToEvaluate].evaluation=(finalProductsList[productToEvaluate].evaluation+customerBewertung)/2
        println("Danke für Ihre Bewertung, nach Ihrer Bewertung ist die Bewertung des Produkts: ${finalProductsList[productToEvaluate].evaluation} Sterne geworden. ")
        Thread.sleep(1200)
    }else{
        println("Das Produkt existiert leider nicht.")
    }
}


