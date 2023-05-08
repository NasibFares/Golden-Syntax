package produkte
/*
In meinem Projekt habe ich Kategorien und Unterkategorien, deswegen habe ich für 'enum class' entschieden.
Enum-Klassen werden hierzu verwendet, um zusammengehörige Konstanten zu gruppieren,
wodurch mein Code übersichtlicher und leichter lesbar wird.
Kategorie: Clothes => Unterkategorien * TShirts * Trousers * Shoes
Kategorie: Electronics => Unterkategorien * Mobiles * Microwaves * TVs
 */
enum class Categories(val subcategories: List<Subcategories>) {
    Clothes(listOf(Subcategories.TShirts, Subcategories.Trousers, Subcategories.Shoes)),
    Electronics(listOf(Subcategories.Mobiles,Subcategories.Microwaves,Subcategories.TVs))

}

