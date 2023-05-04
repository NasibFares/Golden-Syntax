package produkte.products

import produkte.Categories
import produkte.Subcategories
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
}
