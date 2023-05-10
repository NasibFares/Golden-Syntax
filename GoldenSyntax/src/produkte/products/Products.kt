package produkte.products

import produkte.Categories
import produkte.Subcategories

/*
Die Klasse 'Products' hat die Eigenschaften "name→ Name des Produkts", "price→ Preis des Produkts",
"evaluation→ Rezension des Produkts", "category→ Kategorie des Produkts", "subcategory→ Unterkategorie des Produkts"
 */
open class Products(
    val name: String,
    val price: Double,
    var evaluation:Double = 0.0,
    var category: Categories,
    val subCategory: Subcategories,
    var qty:Int=0
) {}


