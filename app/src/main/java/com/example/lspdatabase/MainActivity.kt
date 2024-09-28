package com.example.lspdatabase

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = FirebaseFirestore.getInstance()

        val product1 = hashMapOf(
            "name" to "Ayam Goreng",
            "price" to 15000,
            "stock" to 10,
            "image_url" to "https://cdn1-production-images-kly.akamaized.net/zd-q4S3lk95fdXB0bDQ7EijRZYw=/1360x766/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/2958639/original/057463300_1572940011-shutterstock_127677473.jpg"
        )

        db.collection("products").add(product1)
            .addOnSuccessListener { documentReference ->
                Log.d("Firestore", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("Firestore", "Error adding document", e)
            }
    }
}