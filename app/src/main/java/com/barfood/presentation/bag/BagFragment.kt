package com.barfood.presentation.bag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barfood.databinding.FragmentBagBinding
import com.textfojin.domain.models.DishesDialogModelDomain
import org.koin.androidx.viewmodel.ext.android.viewModel


class BagFragment : Fragment() {
    private val vm by viewModel<BagViewModel>()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        BagAdapter({ callbac1(it) }, { callbac2(it) })
    }
    lateinit var binding: FragmentBagBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentBagBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            bagRcView.adapter = adapter
        }

        vm.getDishes()

        vm._deleteLiveData.observe(viewLifecycleOwner) {
            vm.getDishes()
        }
        vm._updateLiveData.observe(viewLifecycleOwner) {
            vm.getDishes()
        }
        vm._dishesLiveData.observe(viewLifecycleOwner) { it ->
            adapter.addRepoz(it)
            var sum = 0
            it.forEach { item ->
                sum += item.price!! * item.count!!
            }
            binding.button.text = "Оплатить ${sum} ₽"
        }


    }

    private fun callbac1(it: DishesDialogModelDomain) {
        vm.deleteDishes(it)
    }

    private fun callbac2(it: DishesDialogModelDomain) {
        vm.updateDishes(it)
    }
}
