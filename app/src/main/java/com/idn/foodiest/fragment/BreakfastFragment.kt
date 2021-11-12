package com.idn.foodiest.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.idn.foodiest.adapter.FoodAdapter
import com.idn.foodiest.databinding.FragmentBreakfastBinding
import com.idn.foodiest.model.DataRecipes
import com.idn.foodiest.model.Recipes


class BreakfastFragment : Fragment() {

    private lateinit var breakfastBinding: FragmentBreakfastBinding
    private val  list : ArrayList<Recipes> = arrayListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        breakfastBinding = FragmentBreakfastBinding.inflate(inflater, container, false)
        return breakfastBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        list.addAll(DataRecipes.dataBreakfast)
        breakfastBinding.rvBreakfast.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(context, 2)
            val foodAdapter = FoodAdapter(list)
            adapter = foodAdapter
        }
    }

}