package com.barfood.presentation.bag

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.barfood.R
import com.barfood.databinding.ItemBagBinding
import com.textfojin.domain.models.DishesDialogModelDomain
import java.util.*

class BagAdapter(private var callback1: (DishesDialogModelDomain) -> Unit, private var callback2: (DishesDialogModelDomain) -> Unit) :
    RecyclerView.Adapter<BagAdapter.RepozHolder>() {
    private val repozList = ArrayList<DishesDialogModelDomain?>()

    class RepozHolder(itemView: View, private var callback1: (DishesDialogModelDomain) -> Unit, private var callback2: (DishesDialogModelDomain) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ItemBagBinding.bind(itemView)


        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(item: DishesDialogModelDomain?) = with(binding) {
            image.load(item?.image_url) {
                placeholder(ColorDrawable(Color.TRANSPARENT))
            }
            title.text=item?.name
            sum.text="${item?.price} ₽ · ${item?.weight}г"
            binding.txtNumbers.text = item?.count.toString()
            binding.imgMinus.setOnClickListener {
                callback1.invoke(DishesDialogModelDomain(item!!.id,item.name,item.price,item.weight,item.description,item.image_url, item.count?.minus(1)))
            }
            binding.imgPlus.setOnClickListener {
                callback2.invoke(DishesDialogModelDomain(item!!.id,item.name,item.price,item.weight,item.description,item.image_url, item.count?.plus(1)))
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepozHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_bag, parent, false)
        return RepozHolder(view, callback1,callback2)
    }

    override fun onBindViewHolder(holder: RepozHolder, position: Int) {
        holder.bind(repozList[position])
    }

    override fun getItemCount(): Int {
        return repozList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addRepoz(repoz: List<DishesDialogModelDomain>) {
        repozList.clear()
        repozList.addAll(repoz)
        notifyDataSetChanged()
    }
}