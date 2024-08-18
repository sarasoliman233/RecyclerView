package com.basicsandroid.recyclerviewproject.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.basicsandroid.recyclerviewproject.Modal.Food
import com.basicsandroid.recyclerviewproject.R

class FoodAdapter :RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {
    private var foodList:ArrayList<Food> = arrayListOf()
    private lateinit var context: Context
    inner class FoodViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        var foodNameView:TextView?=null
        var foodImageView:ImageView?=null
        var foodOldPrice:TextView?=null
        var foodRecentPrice:TextView?=null
        var addToCart:Button?=null

        init {
            foodNameView=itemView.findViewById(R.id.foodname)
            foodImageView=itemView.findViewById(R.id.image)
            foodRecentPrice=itemView.findViewById(R.id.rprice)
            foodOldPrice=itemView.findViewById(R.id.oprice)
            addToCart=itemView.findViewById(R.id.addToCart)

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        context=parent.context
        val layoutInflater=context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val view =layoutInflater.inflate(R.layout.food_row,parent,false)
        return FoodViewHolder(view)
    }

    override fun getItemCount(): Int =foodList.size

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.foodNameView?.text=foodList[position].name
        holder.foodImageView?.setImageResource(foodList[position].image)
        holder.foodRecentPrice?.text="Price : ${foodList[position].recentPrice}"
        holder.foodOldPrice?.text="Old price : ${foodList[position].oldPrice}"
        holder.addToCart?.setOnClickListener{
            Toast.makeText(context,foodList[position].name,Toast.LENGTH_LONG).show()

        }


    }

    fun setDataSource(foodList: List<Food>) {
        this.foodList.clear()
        this.foodList.addAll(foodList)
        notifyDataSetChanged()

    }
}