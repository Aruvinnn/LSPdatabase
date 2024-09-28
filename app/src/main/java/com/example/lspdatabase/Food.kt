package com.example.lspdatabase

data class Food(
    val name: String = "",
    val price: Int = 0,
    val stock: Int = 0,
    val image_url: String = "",
    var quantity: Int = 0  // Menyimpan jumlah yang akan dibeli
)