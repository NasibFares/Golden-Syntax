package produkte.products

import produkte.Categories
import produkte.Subcategories
import produkte.products.electronics.Microwaves
import produkte.products.electronics.Mobiles
import produkte.products.electronics.TVs

/*
Die Klasse 'Products' hat die Eigenschaften "name→ Name des Produkts", "price→ Preis des Produkts",
"evaluation→ Rezension des Produkts", "category→ Kategorie des Produkts", "subcategory→ Unterkategorie des Produkts"
 */
open class Products(
    val name: String, val price: Double, var evaluation: Double = 0.0,
    val category: Categories,
    val subCategory: Subcategories
) {

    var reviews = mutableListOf<String>()
    fun addReview(review: String) {
        reviews.add(review)
        evaluation = reviews.map { it.toDouble() }.average()
    }

    val ourProducts: MutableList<Products> = mutableListOf(
        Mobiles(
            "Samsung Galaxy A24 4G", 200.0,
            3.4, Categories.Electronics, Subcategories.Mobiles, "128GB", "Green", "Android"
        ),
        Mobiles(
            "Huawei Enjoy 60X", 230.0, 4.1, Categories.Electronics, Subcategories.Mobiles,
            "128GB", "Red", "Android"
        ), Mobiles(
            "Apple iPhone 14 Pro Max",
            1294.38, 4.6, Categories.Electronics, Subcategories.Mobiles, "128GB", "Black",
            "IOS"
        ), TVs(
            "Fire TV 2-Series", 175.0, 3.6, Categories.Electronics,
            Subcategories.TVs, "HD", 40
        ), TVs(
            "Sony Bravia", 799.0, 4.0,
            Categories.Electronics, Subcategories.TVs, "4K", 50
        ), TVs("Toshiba", 549.99, 4.0, Categories.Electronics, Subcategories.TVs, "4K", 65),
        Microwaves(
            "Toshiba", 109.0, 4.4, Categories.Electronics, Subcategories.Microwaves, "23L",
            "Black", "Glass", 800
        ),
        Microwaves(
            "Sharp", 96.89, 4.4, Categories.Electronics, Subcategories.Microwaves, "20l", "Black", "Plastic", 2200
        )
    )
}
