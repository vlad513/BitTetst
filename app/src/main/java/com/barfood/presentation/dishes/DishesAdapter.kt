package com.barfood.presentation.dishes

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.barfood.R
import com.barfood.databinding.ItemDishesBinding
import com.textfojin.domain.models.DishesDomain
import java.util.ArrayList

class DishesAdapter(private var callback1: (DishesDomain) -> Unit) :
    RecyclerView.Adapter<DishesAdapter.RepozHolder>() {
    private val repozList = ArrayList<DishesDomain?>()

    class RepozHolder(itemView: View, private var callback1: (DishesDomain) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ItemDishesBinding.bind(itemView)


        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(item: DishesDomain?) = with(binding) {
            image.load(item?.image_url) {
                placeholder(ColorDrawable(Color.TRANSPARENT))
            }
            title.text=item?.name
            cardButton.setOnClickListener {
                callback1.invoke(item!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepozHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dishes, parent, false)
        return RepozHolder(view, callback1)
    }

    override fun onBindViewHolder(holder: RepozHolder, position: Int) {
        holder.bind(repozList[position])
    }

    override fun getItemCount(): Int {
        return repozList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRepoz(repoz: List<DishesDomain?>) {
        repozList.clear()
        repozList.addAll(repoz)
        notifyDataSetChanged()
    }

    fun clearRepos(){
        repozList.clear()
    }
}