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
                material = material, watt = watt
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
                print("Geben Sie bitte das Betriebssystem des Handys ein: ")
                storage = readln()
                if (storage.isNullOrEmpty()) {
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
