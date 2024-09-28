package com.example.lspdatabase

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class FoodAdapter(private val foodList: List<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val foodName: TextView = itemView.findViewById(R.id.foodName)
        val foodPrice: TextView = itemView.findViewById(R.id.foodPrice)
        val foodStock: TextView = itemView.findViewById(R.id.foodStock)
        val foodImage: ImageView = itemView.findViewById(R.id.foodImage)
        val btnMinus: Button = itemView.findViewById(R.id.btnMinus)
        val btnPlus: Button = itemView.findViewById(R.id.btnPlus)
        val tvQuantity: TextView = itemView.findViewById(R.id.tvQuantity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.food_item, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.foodName.text = food.name
        holder.foodPrice.text = "Harga: ${food.price}"
        holder.foodStock.text = "Stok: ${food.stock}"
        holder.tvQuantity.text = food.quantity.toString()

        // Load image with Glide
        Glide.with(holder.itemView.context)
            .load(food.image_url)
            .into(holder.foodImage)

        // Set up button click listeners
        holder.btnMinus.setOnClickListener {
            if (food.quantity > 0) {
                food.quantity -= 1
                holder.tvQuantity.text = food.quantity.toString()
            }
        }

        holder.btnPlus.setOnClickListener {
            if (food.quantity < food.stock) { // Ensure the quantity doesn't exceed stock
                food.quantity += 1
                holder.tvQuantity.text = food.quantity.toString()
            }
        }
    }

    override fun getItemCount(): Int {
        return foodList.size
    }
}