package produkte.products

import produkte.Categories
import produkte.Subcategories
import produkte.products.clothes.Shoes
import produkte.products.clothes.TShirts
import produkte.products.clothes.Trousers
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

    private var reviews = mutableListOf<String>() //z.B reviews=[2,4.4,5,]
    fun addReview(review: String) {
        reviews.add(review)
        evaluation = reviews.map { it.toDouble() }.average()
    }

    val ourProducts: MutableList<Products> = mutableListOf(
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
            "4K", 65
        ),
        Microwaves(
            "Toshiba", 109.0, 4.4, Categories.Electronics, Subcategories.Microwaves,
            "23L",
            "Black", "Glass", 800
        ),
        Microwaves(
            "Sharp", 96.89, 4.4, Categories.Electronics, Subcategories.Microwaves,
            "20l", "Black", "Plastic", 2200
        ), Microwaves(
            "Bosch",
            153.48,
            4.6,
            Categories.Electronics,
            Subcategories.Microwaves,
            "20L",
            "stainless steel",
            "stainless steel",
            800
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
}
