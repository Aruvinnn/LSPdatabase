package com.example.lspdatabase

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MainActivity : ComponentActivity() {
    private lateinit var recyclerView: RecyclerView
    private var foodList: ArrayList<Food> = ArrayList()
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this) // Ensures the RecyclerView displays items in a list
        foodAdapter = FoodAdapter(foodList)
        recyclerView.adapter = foodAdapter

        val db = FirebaseFirestore.getInstance()

        db.collection("products")
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    val food = document.toObject(Food::class.java)
                    foodList.add(food)
                }
                foodAdapter.notifyDataSetChanged()

                Log.d("Firestore", "Fetched Food Items: ${foodList.size}")
            }
            .addOnFailureListener { exception ->
                Log.e("Firestore", "Error fetching data", exception)
            }

        val loginButton: Button = findViewById(R.id.btnLogin)
        loginButton.setOnClickListener {
            // Navigate to Admin Dashboard
            val intent = Intent(this, AdminActivity::class.java)
            startActivity(intent)
        }
    }

    //        val product1 = hashMapOf(
//            "name" to "Ayam Goreng",
//            "price" to 15000,
//            "stock" to 10,
//            "image_url" to "https://cdn1-production-images-kly.akamaized.net/zd-q4S3lk95fdXB0bDQ7EijRZYw=/1360x766/smart/filters:quality(75):strip_icc():format(webp)/kly-media-production/medias/2958639/original/057463300_1572940011-shutterstock_127677473.jpg"
//        )
//
//        db.collection("products").add(product1)
//            .addOnSuccessListener { documentReference ->
//                Log.d("Firestore", "DocumentSnapshot added with ID: ${documentReference.id}")
//            }
//            .addOnFailureListener { e ->
//                Log.w("Firestore", "Error adding document", e)
//            }
}



