package com.barfood.presentation.dishes_dialog

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import coil.load
import com.barfood.databinding.FragmentDishesDialogBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


class DishesDialogFragment : DialogFragment() {
    private val vm by viewModel<DishesDialogViewModel>()
    private val args: DishesDialogFragmentArgs by navArgs()
    lateinit var binding: FragmentDishesDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDishesDialogBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            image.load(args.dishes.image_url) {
                placeholder(ColorDrawable(Color.TRANSPARENT))
            }
            title.text = args.dishes.name
            sum.text = "${args.dishes.price} ₽ · ${args.dishes.weight}г"
            description.text = args.dishes.description
            binding.buttonAddBag.setOnClickListener {
                vm.addDishes(args.dishes)
                dialog?.dismiss()
            }
            binding.imageButton.setOnClickListener{
                dialog?.dismiss()
            }
        }
    }

}