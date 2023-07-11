package com.barfood.presentation.categories

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.barfood.R
import com.barfood.databinding.FragmentCategoriesBinding
import com.barfood.presentation.dishes.DishesFragment
import com.textfojin.domain.models.CategoriesDomain

import org.koin.androidx.viewmodel.ext.android.viewModel


class CategoriesFragment : Fragment() {

    private val vm by viewModel<CategoriesViewModel>()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        CategoriesAdapter { callback(it) }
    }
    lateinit var binding: FragmentCategoriesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoriesBinding.inflate(layoutInflater)
        return binding.root
    }



    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.criticsRcView.adapter = adapter

            vm.getCategories()


        vm._categoriesLiveData.observe(viewLifecycleOwner) {
            binding.button2.visibility = View.GONE
            adapter.addRepoz(it.categories)
        }
        vm._failureLiveData.observe(viewLifecycleOwner) {
            binding.button2.visibility = View.VISIBLE
            adapter.clearRepoz()


        }
        binding.button2.setOnClickListener {
            vm.getCategories()
        }

    }
    private fun callback(it: CategoriesDomain) {
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.hostMenuFragment, DishesFragment())
            commit()
        }
    }
}