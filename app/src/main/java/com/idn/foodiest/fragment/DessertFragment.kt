package com.idn.foodiest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.idn.foodiest.R
import com.idn.foodiest.adapter.FoodAdapter
import com.idn.foodiest.databinding.FragmentDessertBinding
import com.idn.foodiest.model.DataRecipes
import com.idn.foodiest.model.Recipes

class DessertFragment : Fragment() {
    private lateinit var dessertBinding: FragmentDessertBinding
    private var list : ArrayList<Recipes> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        dessertBinding = FragmentDessertBinding.inflate(inflater, container, false)

        return dessertBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataDessert)
        dessertBinding.rvDssert.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter

        }
    }

}