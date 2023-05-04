package produkte

enum class Categories(val category: Int,val subcategories: List<Subcategories>) {
    Clothes(1, listOf(Subcategories.TShirts, Subcategories.Trousers, Subcategories.Jackets)),
    Electronics(2, listOf(Subcategories.Mobiles,Subcategories.Microwaves,Subcategories.TVs))

}

