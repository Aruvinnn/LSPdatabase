package com.example.lspdatabase

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity

class AdminActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        // Back button functionality
        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish() // Go back to the previous activity
        }

        // Manage Products and Stock Levels Click
        findViewById<LinearLayout>(R.id.manageProductsSection).setOnClickListener {
//            // Navigate to the Manage Products Activity
//            startActivity(Intent(this, ManageProductsActivity::class.java))
        }

        // Manage Orders and Customer Orders Click
        findViewById<LinearLayout>(R.id.manageOrdersSection).setOnClickListener {
//            // Navigate to the Manage Orders Activity
//            startActivity(Intent(this, ManageOrdersActivity::class.java))
        }
    }
}