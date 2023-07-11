package com.barfood.presentation.categories

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.barfood.R
import com.barfood.databinding.ItemCategorisBinding
import com.textfojin.domain.models.CategoriesDomain
import java.util.ArrayList


class CategoriesAdapter(private var callback1: (CategoriesDomain) -> Unit) :
    RecyclerView.Adapter<CategoriesAdapter.RepozHolder>() {
    private val repozList = ArrayList<CategoriesDomain?>()

    class RepozHolder(itemView: View, private var callback1: (CategoriesDomain) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ItemCategorisBinding.bind(itemView)


        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(item: CategoriesDomain?) = with(binding) {
            image.load(item?.image_url) {
                placeholder(ColorDrawable(Color.TRANSPARENT))
            }
            textView.text = item?.name
            cardButton.setOnClickListener {
                callback1.invoke(item!!)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepozHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_categoris, parent, false)
        return RepozHolder(view, callback1)
    }

    override fun onBindViewHolder(holder: RepozHolder, position: Int) {
        holder.bind(repozList[position])
    }

    override fun getItemCount(): Int {
        return repozList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRepoz(repoz: List<CategoriesDomain?>) {
        repozList.clear()
        repozList.addAll(repoz)
        notifyDataSetChanged()
    }
    fun clearRepoz(){
        repozList.clear()
    }
}