package com.parveendala.productscanner.ui.discover.data.repo

import com.parveendala.productscanner.R
import com.parveendala.productscanner.ui.discover.data.model.Product
import com.parveendala.productscanner.ui.discover.data.model.Specification


interface ProductRepo {
    fun getProduct(productId: String): Product?
}

class ProductRepoImpl : ProductRepo {
    override fun getProduct(productId: String) = buildDummyProduct(productId)
}

private fun buildDummyProduct(productId: String): Product? {
    return Product(
        "AIR71826TUI",
        "Galaxy Home Decor 304 cm (10 ft) Polyester Window Curtain (Pack Of 2)",
        "Galaxy Home Decor",
        "4.5",
        "15,264 ratings",
        "\$1,781.99",
        "\$3,125.99",
        "43% OFF",
        R.drawable.product_1,
        "The string curtain fly screen is decorated with sparkling crystal beads, which will add an amazing look when reflecting the bright sunlight or light. Dense weaving strands make a nice looking meanwhile protect your privacy, you can choose two pieces or more to let it look more concentrated.",
        listOf("Floral Yellow", "Light Blue", "Black", "White", "Dark Red", "Orange", "Dark Grey"),
        listOf("10 ft", "08 ft", "06 ft", "04 ft", "02 ft"),
        listOf(
            Specification("Model Name", "GHD-NETPATCH-10FT"),
            Specification("Material", "Polyester"),
            Specification("Transparency", "Semi Transparent"),
            Specification("Closure Type", "Eyelet"),
            Specification("Designed For", "Door, Long Door and Window"),
            Specification("Fabric Care", "Normal Machine Wash"),
            Specification("Sales Package", "2 Curtains Per Package"),
            Specification("Weight", "300 g (per single Curtain) - Weight of the product may vary depending on size."),
            Specification("Care Instructions", "Wipe gently with a dry cloth to remove any dried-on dirt and dust.")
        ),
    )
}