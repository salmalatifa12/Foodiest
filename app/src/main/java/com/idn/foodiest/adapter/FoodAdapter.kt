package com.idn.foodiest.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.idn.foodiest.DetailActivity
import com.idn.foodiest.databinding.ItemFoodBinding
import com.idn.foodiest.model.Recipes

class FoodAdapter(private val listFood : ArrayList<Recipes>) : RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodAdapter.FoodViewHolder {
        val binding = ItemFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return  FoodViewHolder(binding)
    }

    inner class FoodViewHolder(val itemFoodBinding: ItemFoodBinding) : RecyclerView.ViewHolder(itemFoodBinding.root)


    override fun onBindViewHolder(holder: FoodAdapter.FoodViewHolder, position: Int) {
        with(holder){
            with(listFood[position]){
                Glide.with(holder.itemView.context).load(pictures).into(itemFoodBinding.ivItemRecipe)
                itemFoodBinding.tvItemNameRecipe.text = name
                itemFoodBinding.tvItemMenu.text = category
                itemFoodBinding.tvNumberRecipe.text = number
                val mContext = holder.itemView.context
                holder.itemView.setOnClickListener {
                    val dataSend = Recipes(
                        name = listFood[position].name,
                        category = listFood[position].category,
                        description = listFood[position].description,
                        ingredients = listFood[position].ingredients,
                        instructions = listFood[position].instructions,
                        pictures = listFood[position].pictures,
                        number = listFood[position].number,
                        calories =listFood[position].calories,
                        carbo = listFood[position].carbo,
                        protein = listFood[position].protein
                    )
                    val intentToDetail =Intent(mContext,DetailActivity::class.java)
                    intentToDetail.putExtra(DetailActivity.RECIPE_DATA, dataSend)
                    mContext.startActivity(intentToDetail)
                }
            }
        }
    }

    override fun getItemCount(): Int = listFood.size
}