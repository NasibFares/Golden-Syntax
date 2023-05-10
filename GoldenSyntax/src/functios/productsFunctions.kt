package functios

import produkte.Categories
import produkte.Subcategories
import produkte.products.Products
import produkte.products.clothes.Shoes
import produkte.products.clothes.TShirts
import produkte.products.clothes.Trousers
import produkte.products.electronics.Microwaves
import produkte.products.electronics.Mobiles
import produkte.products.electronics.TVs

var finalProductsList: MutableList<Products> = mutableListOf(
    Mobiles(
        "Samsung Galaxy A24 4G", 200.0,
        3.4, Categories.Electronics, Subcategories.Mobiles, "128GB", "Green",
        "Android"
    ),
    Mobiles(
        "Huawei Enjoy 60X", 230.0, 4.1, Categories.Electronics, Subcategories.Mobiles,
        "128GB", "Red", "Android"
    ), Mobiles(
        "Apple iPhone 14 Pro Max",
        1294.38, 4.6, Categories.Electronics, Subcategories.Mobiles, "128GB",
        "Black",
        "IOS"
    ), TVs(
        "Fire TV 2-Series", 175.0, 3.6, Categories.Electronics,
        Subcategories.TVs, "HD", 40
    ), TVs(
        "Sony Bravia", 799.0, 4.0,
        Categories.Electronics, Subcategories.TVs, "4K", 50
    ), TVs(
        "Toshiba", 549.99, 4.0, Categories.Electronics, Subcategories.TVs,
        "4K", 65,50
    ),
    Microwaves(
        "Toshiba", 109.0, 4.4, Categories.Electronics, Subcategories.Microwaves,
        "23L",
        "Black", "Glass", "800",120
    ),
    Microwaves(
        "Sharp", 96.89, 4.4, Categories.Electronics, Subcategories.Microwaves,
        "20l", "Black", "Plastic", "2200"
    ), Microwaves(
        "Bosch",
        153.48,
        4.6,
        Categories.Electronics,
        Subcategories.Microwaves,
        "20L",
        "stainless steel",
        "stainless steel",
        "800"
    ), Trousers(
        "Vans Leggings CHALKBOARD CLASSIC LEGGINGS", 34.99, 4.3, Categories.Clothes,
        Subcategories.Trousers, "Women", 34, "Black"
    ), Trousers(
        "Tazzio Cargohose 16610 Stretch mit Elasthan, Regular Fit", 29.90, 4.3,
        Categories.Clothes, Subcategories.Trousers, "Men", 36, "Braun"
    ),
    Trousers(
        "Next Stoffhose Senior Tapered Trousers (1-tlg)", 19.0, 3.8, Categories.Clothes,
        Subcategories.Trousers, "Children", 24, "Black"
    ),
    TShirts(
        "Classic Basics Kurzarmshirt Shirt (1-tlg)", 9.0, 4.0,
        Categories.Clothes, Subcategories.TShirts, "Women", "M", "Green"
    ),
    TShirts(
        "Tommy Jeans Plus T-Shirt TJM PLUS ", 33.99, 4.1, Categories.Clothes,
        Subcategories.TShirts, "Men", "XL", "Grey"
    ),
    TShirts(
        "Converse Kurzarmshirt", 17.99, 3.8, Categories.Clothes, Subcategories.TShirts,
        "Children", "S", "Red"
    ),
    Shoes(
        "Vans Ward Sneaker", 63.99, 4.5, Categories.Clothes, Subcategories.Shoes,
        36.5, "Women", "Sport", "Black"
    ),
    Shoes(
        "SAGUARO Barfußschuh", 52.99, 4.0, Categories.Clothes, Subcategories.Shoes,
        40.0, "Men", "Summer-Classic", "Black"
    ),
    Shoes(
        "Kappa Sneaker", 25.99, 4.4, Categories.Clothes, Subcategories.Shoes,
        34.0, "Children", "Sport", "White"
    )
)
/*
-------------------------------------------------2.Produkte Abteilung--------------------------------------------------
-----------------------------------------------------------------------------------------------------------------------
*/


/*
---------------------------------------1. Produkt hinzufügen(Operator Aufgabe)------------------------------------------
*/
fun addNewProduct() {
    /*
       Szenario
       -----------------------1.1. Einen Namen des Produkts muss eingegeben werden----------------------------------
 */
    var name: String = "product"
    var nameTrials = 0
    var nameMaxTrials = 2
    while (nameTrials < nameMaxTrials) {
        print("Geben Sie bitte den Namen des Produkts ein: ")
        name = readln()
        if (name.isNullOrEmpty() || name.toIntOrNull() != null) {
            nameTrials++
            if (nameTrials == nameMaxTrials) {
                println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                return
            } else {
                println("Ungültige Eingabe, versuchen Sie es erneut.")
            }
        } else {
            break
        }

    }


    /*
   ----------------------------1.2. Einen Preis des Produkts muss eingegeben werden-------------------------------
     */
    var priceTemp: String
    var price = 0.0
    var priceTrials = 0
    var priceMaxTrials = 2
    while (priceTrials < priceMaxTrials) {
        print("Geben Sie bitte den Preis des Produkts ein: ")
        priceTemp = readln()
        if (priceTemp.isNullOrEmpty() || priceTemp.all { it.isLetter() }) {
            priceTrials++
            if (priceTrials == priceMaxTrials) {
                println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                return
            } else {
                println("Ungültige Eingabe, versuchen Sie es erneut.")
            }
        } else {
            price = priceTemp.toDouble()
            break
        }

    }
    /*
----------------------------------1.3. Eine Kategorie muss ausgewählt werden-------------------------------------------
    */

    // Die Kategorien der Produkte sollen aufgelistet werden.
    Categories.values().forEachIndexed { index, category ->
        println("${index + 1}. ${category.name}")
    }

    println("Wählen Sie eine Kategorie aus, um das Produkt hinzuzufügen:")
    val categoryIndex = readlnOrNull()?.toIntOrNull()?.minus(1) ?: return
    val category = Categories.values().getOrNull(categoryIndex) ?: return
    /*
--------------------------------1.4. Eine Unterkategorie muss ausgewählt werden----------------------------------------
     */
    println("Die Unterkategorie des Produkts:")
    //
    category.subcategories.forEachIndexed { index, subcategory ->
        println("${index + 1}. ${subcategory.name}")
    }
    val subcategoryIndex = readlnOrNull()?.toIntOrNull()?.minus(1) ?: return
    val subcategory = category.subcategories.getOrNull(subcategoryIndex) ?: return

    // Ein passendes Produkt anhand der Unterkategorie erstellen.
    var product = when (subcategory) {

        Subcategories.Shoes -> {
            var sizeTrials = 0
            var maxTrials = 2
            var size = ""
            var gender = ""
            var color = ""
            var qtyTemp: String
            var qty = 0
            while (sizeTrials < maxTrials) {
                print("Geben Sie bitte die Große der Schuhe ein: ")
                size = readln()
                if (size.isNullOrEmpty() || size.all { it.isLetter() } || size.toDouble() < 16.0) {
                    sizeTrials++
                    if (sizeTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var genderTrials = 0
            while (genderTrials < maxTrials) {
                print("Schuhe für (Damen, Herren, Kinder): ")
                gender = readln()
                if (gender.isNullOrEmpty() || !gender.all { it.isLetter() } || gender !in listOf(
                        "Damen",
                        "Herren",
                        "Kinder"
                    )
                ) {
                    genderTrials++
                    if (genderTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var colorTrials = 0
            while (colorTrials < maxTrials) {
                print("Geben Sie bitte die Farbe der Schuhe ein: ")
                color = readln()
                if (color.isNullOrEmpty() || !color.all { it.isLetter() }) {
                    colorTrials++
                    if (colorTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var qtyTrials = 0
            while (qtyTrials < maxTrials) {
                print("Geben Sie bitte die Anzahl der Schuhe ein: ")
                qtyTemp = readln()
                if (qtyTemp.isNullOrEmpty() || qtyTemp.all { it.isLetter() } || qtyTemp.toInt() == 0) {
                    qtyTrials++
                    if (qtyTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    qty = qtyTemp.toInt()
                    break
                }
            }
            Shoes(
                name,
                price,
                category = category,
                subCategory = subcategory,
                size = size.toDouble(),
                gender = gender,
                color = color,
                qty = qty
            )

        }

        Subcategories.Trousers -> {
            var sizeTrials = 0
            var maxTrials = 2
            var size = ""
            var gender = ""
            var color = ""
            var qtyTemp: String
            var qty = 0
            while (sizeTrials < maxTrials) {
                print("Geben Sie bitte die Große der Hose ein: ")
                size = readln()
                if (size.isNullOrEmpty() || size.all { it.isLetter() } || size.toDouble() < 16.0) {
                    sizeTrials++
                    if (sizeTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var genderTrials = 0
            while (genderTrials < maxTrials) {
                print("Hosen für (Damen, Herren, Kinder): ")
                gender = readln()
                if (gender.isNullOrEmpty() || !gender.all { it.isLetter() } || gender !in listOf(
                        "Damen",
                        "Herren",
                        "Kinder"
                    )
                ) {
                    genderTrials++
                    if (genderTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var colorTrials = 0
            while (colorTrials < maxTrials) {
                print("Geben Sie bitte die Farbe der Hose ein: ")
                color = readln()
                if (color.isNullOrEmpty() || !color.all { it.isLetter() }) {
                    colorTrials++
                    if (colorTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var qtyTrials = 0
            while (qtyTrials < maxTrials) {
                print("Geben Sie bitte die Anzahl der Hosen ein: ")
                qtyTemp = readln()
                if (qtyTemp.isNullOrEmpty() || qtyTemp.all { it.isLetter() } || qtyTemp.toInt() == 0) {
                    qtyTrials++
                    if (qtyTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    qty = qtyTemp.toInt()
                    break
                }
            }
            Trousers(
                name,
                price,
                category = category,
                subCategory = subcategory,
                size = size.toInt(),
                gender = gender,
                color = color,
                qty = qty
            )

        }

        Subcategories.TShirts -> {
            var sizeTrials = 0
            var maxTrials = 2
            var size = ""
            var gender = ""
            var color = ""
            var qtyTemp: String
            var qty = 0
            while (sizeTrials < maxTrials) {
                print("Geben Sie bitte die Große der T-shirt ein (\"XS\",\"S\",\"M\",\"L\",\"XL\",\"XXL\"): ")
                size = readln()
                if (size.isNullOrEmpty() || !size.all { it.isLetter() } || size !in listOf(
                        "XS",
                        "S",
                        "M",
                        "L",
                        "XL",
                        "XXL"
                    )) {
                    sizeTrials++
                    if (sizeTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var genderTrials = 0
            while (genderTrials < maxTrials) {
                print("T-shirt für (Damen, Herren, Kinder): ")
                gender = readln()
                if (gender.isNullOrEmpty() || !gender.all { it.isLetter() } || gender !in listOf(
                        "Damen",
                        "Herren",
                        "Kinder"
                    )
                ) {
                    genderTrials++
                    if (genderTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var colorTrials = 0
            while (colorTrials < maxTrials) {
                print("Geben Sie bitte die Farbe der T-shirt ein: ")
                color = readln()
                if (color.isNullOrEmpty() || !color.all { it.isLetter() }) {
                    colorTrials++
                    if (colorTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var qtyTrials = 0
            while (qtyTrials < maxTrials) {
                print("Geben Sie bitte die Anzahl der T-shirts ein: ")
                qtyTemp = readln()
                if (qtyTemp.isNullOrEmpty() || qtyTemp.all { it.isLetter() } || qtyTemp.toInt() == 0) {
                    qtyTrials++
                    if (qtyTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    qty = qtyTemp.toInt()
                    break
                }
            }
            TShirts(
                name,
                price,
                category = category,
                subCategory = subcategory,
                size = size,
                gender = gender,
                color = color,
                qty = qty
            )

        }

        Subcategories.Microwaves -> {

            var maxTrials = 2
            var capacity = ""
            var watt = ""
            var material = ""
            var color = ""
            var qtyTemp: String
            var qty = 0
            var colorTrials = 0
            while (colorTrials < maxTrials) {
                print("Geben Sie bitte die Farbe der Mikrowelle ein: ")
                color = readln()
                if (color.isNullOrEmpty() || !color.all { it.isLetter() }) {
                    colorTrials++
                    if (colorTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var capacityTrials = 0
            while (capacityTrials < maxTrials) {
                print("Geben Sie bitte die Kapazität der Mikrowelle ein : ")
                capacity = readln()
                if (capacity.isNullOrEmpty()) {
                    capacityTrials++
                    if (capacityTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var materialTrials = 0
            while (materialTrials < maxTrials) {
                print("Geben Sie bitte das Material der Mikrowelle ein : ")
                material = readln()
                if (material.isNullOrEmpty() || !material.all { it.isLetter() }) {
                    materialTrials++
                    if (materialTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var wattTrials = 0
            while (wattTrials < maxTrials) {
                print("Geben Sie bitte die Leistung(Watt) der Mikrowelle ein : ")
                watt = readln()
                if (watt.isNullOrEmpty()) {
                    wattTrials++
                    if (wattTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var qtyTrials = 0
            while (qtyTrials < maxTrials) {
                print("Geben Sie bitte die Anzahl der Mikrowellen ein: ")
                qtyTemp = readln()
                if (qtyTemp.isNullOrEmpty() || qtyTemp.all { it.isLetter() } || qtyTemp.toInt() == 0) {
                    qtyTrials++
                    if (qtyTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    qty = qtyTemp.toInt()
                    break
                }
            }
            Microwaves(
                name, price, category = category, subCategory = subcategory, capacity = capacity, color = color,
                material = material, watt = watt,qty=qty
            )
        }

        Subcategories.Mobiles -> {
            var color = ""
            var colorTrials = 0
            var maxTrials = 2
            var storage = ""
            var os = ""
            while (colorTrials < maxTrials) {
                print("Geben Sie bitte die Farbe des Handys ein: ")
                color = readln()
                if (color.isNullOrEmpty() || !color.all { it.isLetter() }) {
                    colorTrials++
                    if (colorTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var storageTrials = 0
            while (storageTrials < maxTrials) {
                print("Geben Sie bitte die Aufbewahrung des Handys ein: ")
                storage = readln()
                if (storage.isNullOrEmpty()) {
                    storageTrials++
                    if (storageTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var osTrials = 0
            while (storageTrials < maxTrials) {
                print("Geben Sie bitte das Betriebssystem des Handys ein (Android,IOS): ")
                os = readln()
                if (os.isNullOrEmpty()||(os !in listOf("Android,IOS"))) {
                    osTrials++
                    if (osTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            var qtyTrials = 0
            var qtyTemp: String
            var qty = 0
            while (qtyTrials < maxTrials) {
                print("Geben Sie bitte die Anzahl der Mikrowellen ein: ")
                qtyTemp = readln()
                if (qtyTemp.isNullOrEmpty() || qtyTemp.all { it.isLetter() } || qtyTemp.toInt() == 0) {
                    qtyTrials++
                    if (qtyTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    qty = qtyTemp.toInt()
                    break
                }
            }
            Mobiles(name, price, storage = storage, color = color, operatingSystem = os, qty = qty)

        }

        Subcategories.TVs -> {
            var sizeTrials = 0
            var maxTrials = 2
            var sizeTemp: String
            var size = 0
            while (sizeTrials < maxTrials) {
                print("Geben Sie bitte die Große des Bildschirms ein: ")
                sizeTemp = readln()
                if (sizeTemp.isNullOrEmpty() || sizeTemp.all { it.isLetter() }) {
                    sizeTrials++
                    if (sizeTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    size = sizeTemp.toInt()
                    break
                }
            }
            var qtyTrials = 0
            var qtyTemp: String
            var qty = 0
            while (qtyTrials < maxTrials) {
                print("Geben Sie bitte die Anzahl der Mikrowellen ein: ")
                qtyTemp = readln()
                if (qtyTemp.isNullOrEmpty() || qtyTemp.all { it.isLetter() } || qtyTemp.toInt() == 0) {
                    qtyTrials++
                    if (qtyTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    qty = qtyTemp.toInt()
                    break
                }
            }
            var resolutionTrials = 0
            var resolution = ""
            while (resolutionTrials < maxTrials) {
                println("Geben Sie bitte die Auflösung des Bildschirms ein:")
                resolution = readln()
                if (resolution.isNullOrEmpty() || resolution !in listOf("HD", "UHD", "4K")) {
                    if (resolutionTrials == maxTrials) {
                        println("Sie haben die maximale Anzahl an Versuchen überschritten.")
                        return
                    } else {
                        println("Ungültige Eingabe, versuchen Sie es erneut.")
                    }
                } else {
                    break
                }
            }
            TVs(
                name,
                price,
                category = category,
                subCategory = subcategory,
                resolution = resolution,
                size = size,
                qty = qty
            )
        }

    }

    finalProductsList.add(product)

    println("Das Produkt wurde erfolgreich hinzugefügt!\n")
}
/*
Die Methode 'sortedProducts' sortiert die Liste der Produkte anhand der Kategorie und Unterkategorie.
Danach wird die Liste in einer bestimmten Form angezeigt, um eine bessere sichtbar für die Kunden zu verfügen.
*/
fun sortedProducts(sortedProducts: MutableList<Products> = mutableListOf()) {

    //Eine Variable wird erstellt, um die aktuelle Kategorie zu verfolgen.
    var currentCategory: Categories? = null
    // Eine Variable wird erstellt, um die aktuelle Unterkategorie zu verfolgen.
    var currentSubcategory: Subcategories? = null
    // Für jede Produkte in der Liste 'finalProductsList'.
    sortedProducts.forEach { product ->
        // Wenn die Kategorie sich ändert.
        if (product.category != currentCategory) {
            // Gib den Namen der Kategorie in der Konsole.
            println("\nKategorie: ${product.category}")
            // Die aktuelle Kategorie aktualisieren aktuelle Kategorie = Die Kategorie des Produkts.
            currentCategory = product.category
            // Die aktuelle Unterkategorie zurücksetzen.
            currentSubcategory = null
        }
        // Wenn die Unterkategorie der aktuellen Kategorie sich ändert.
        if (product.subCategory != currentSubcategory) {
            // Gib die neue Unterkategorie in der Konsole
            println("\nUnterkategorie: ${product.subCategory}")
            // Hier sind die Einstellungen des Headers für jede Unterkategorie:
            when (product) {
                is Microwaves -> println(
                    "%-3s %-20s %-10s %-20s %-10s %-20s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Color",
                        "Capacity",
                        "Material",
                        "Watt",
                        "Qty"
                    )
                ) // print the header for Microwaves
                is Mobiles -> println(
                    "%-3s %-30s %-10s %-10s %-10s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Color",
                        "Storage",
                        "OperatingSystem",
                        "Qty"
                    )
                ) // print the header for Mobiles
                is TVs -> println(
                    "%-3s %-30s %-10s %-10s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Size",
                        "Resolution",
                        "Qty"
                    )
                ) // print the header for TVs
                is Shoes -> println(
                    "%-3s %-30s %-10s %-10s %-10s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Size",
                        "Gender",
                        "Color",
                        "Qty"
                    )
                )

                else -> println(
                    "%-3s %-60s %-10s %-10s %-10s %-10s %s".format(
                        "ID",
                        "Name",
                        "Price",
                        "Size",
                        "Gender",
                        "Color",
                        "Qty"
                    )
                ) // print the header for other products
            }
            // Die aktuelle Unterkategorie aktualisieren aktuelle Unterkategorie= Die Unterkategorie des Produkts.
            currentSubcategory = product.subCategory
        }
        //Hier sind die Einstellungen für die Abstände zwischen den Spalten, die die Informationen des Produkts enthalten.
        when (product) {
            is TShirts -> println(
                "%-3d %-60s %-10.2f %-10s %-10s %-10s %d".format(
                    finalProductsList.indexOf(product),
                    product.name,
                    product.price,
                    product.size,
                    product.gender,
                    product.color,
                    product.qty
                )
            )

            is Shoes -> println(
                "%-3d %-30s %-10.2f %-10s %-10s %-10s %d".format(
                    finalProductsList.indexOf(product),
                    product.name,
                    product.price,
                    product.size,
                    product.gender,
                    product.color,
                    product.qty
                )
            )

            is Trousers -> println(
                "%-3d %-60s %-10.2f %-10s %-10s %-10s %d".format(
                    finalProductsList.indexOf(
                        product
                    ), product.name, product.price, product.size, product.gender, product.color, product.qty
                )
            )

            is Microwaves -> println(
                "%-3d %-20s %-10.2f %-20s %-10s %-20s %-10s %s".format(
                    finalProductsList.indexOf(
                        product
                    ),
                    product.name,
                    product.price,
                    product.color,
                    product.capacity,
                    product.material,
                    product.watt,
                    product.qty
                )
            )

            is Mobiles -> println(
                "%-3d %-30s %-10.2f".format(
                    finalProductsList.indexOf(product),
                    product.name,
                    product.price,
                    product.color,
                    product.storage,
                    product.operatingSystem,
                    product.qty
                )
            )

            is TVs -> println(
                "%-3d %-30s %-10.2f".format(
                    finalProductsList.indexOf(product),
                    product.name,
                    product.price,
                    product.size,
                    product.resolution
                )
            )
        }
    }
}

/*
In der Methode 'productsSortingMethod' könnte der Benutzer die Weise auswählen, wie die Produkte sortiert werden sollen.
Hiermit sind zwei Möglichkeiten verfügbar:
1. Nach dem Preis des Produkts.
2. Nach dem Namen des Produkts.
Die Methode 'sortedProducts' wird innerhalb dieser Methode aufgerufen.
 */
fun productsSortingMethod() {
    println(
        "Wählen Sie die Art und Weise, wie die Produkte sortiert werden sollen:\n" +
                "1. Nach dem Preis des Produkt\n" +
                "2. Nach dem Namen des Produkts"
    )
    val sortOption = readln().toInt()
    if (sortOption == 1) {
        val sortedProducts =
            finalProductsList.sortedWith(compareBy({ it.category }, { it.subCategory }, { it.price }))
                .toMutableList()
        sortedProducts(sortedProducts)
    } else if (sortOption == 2) {
        val sortedProducts =
            finalProductsList.sortedWith(compareBy({ it.category }, { it.subCategory }, { it.name }))
                .toMutableList()
        sortedProducts(sortedProducts)
    }
}
/*
fun buyProduct(product: Products, isDirectPurchase: Boolean = true) {

    if (isDirectPurchase) {
        if (accountBalance >= product.price) {
            accountBalance -= product.price
            // Perform purchase logic here
            println("You have purchased ${product.name} for ${product.price}. Your new account balance is $accountBalance.")
        } else {
            println("Insufficient funds. Please add money to your account.")
        }
    } else {
        cart.add(product)
        println("${product.name} has been added to your cart.")
    }
}
*/