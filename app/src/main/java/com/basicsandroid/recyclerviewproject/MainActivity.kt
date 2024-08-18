package com.basicsandroid.recyclerviewproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.basicsandroid.recyclerviewproject.Adapter.FoodAdapter
import com.basicsandroid.recyclerviewproject.Modal.Food
import com.basicsandroid.recyclerviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
          setupRV()
    }

    private fun setupRV() {
        val foodList= listOf(
            Food("Burger",230.00,300.0,R.drawable.burger),
            Food("Popcorn",280.0,330.0,R.drawable.popcorn),
            Food("Burger",230.00,300.0,R.drawable.burger),
            Food("Popcorn",280.0,330.0,R.drawable.popcorn)
            )

        val layoutManager=LinearLayoutManager(this)
        binding.rv.layoutManager=layoutManager

        val adapter=FoodAdapter()
        adapter.setDataSource(foodList)
        binding.rv.adapter=adapter

    }

}