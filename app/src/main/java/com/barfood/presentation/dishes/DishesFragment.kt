package com.barfood.presentation.dishes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.navigation.fragment.findNavController
import com.barfood.R

import com.barfood.databinding.FragmentDishesBinding
import com.barfood.presentation.categories.CategoriesFragment

import com.barfood.presentation.menu.MenuFragmentDirections
import com.google.android.material.tabs.TabLayout

import com.textfojin.domain.models.DishesDomain
import org.koin.androidx.viewmodel.ext.android.viewModel


class DishesFragment : Fragment() {
    private val vm by viewModel<DishesViewModel>()
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        DishesAdapter { callback(it) }
    }
    lateinit var binding: FragmentDishesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentDishesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.dishesRcView.adapter = adapter

        binding.toolbar.setNavigationOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().apply {
                replace(R.id.hostMenuFragment, CategoriesFragment())
                commit()
            }
        }
        vm.getDishes(binding.tabLayout.selectedTabPosition)

        vm._dishesLiveData.observe(viewLifecycleOwner) {
            binding.button2.visibility = View.GONE
            adapter.addRepoz(it.dishes)

        }
        vm._failureLiveData.observe(viewLifecycleOwner) {
            adapter.clearRepos()
            binding.button2.visibility = View.VISIBLE

        }
        binding.button2.setOnClickListener {
            vm.getDishes(binding.tabLayout.selectedTabPosition)
        }
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {

                vm.getDishes(binding.tabLayout.selectedTabPosition)

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
    }


    private fun callback(it: DishesDomain) {
        findNavController().navigate(
            MenuFragmentDirections.actionMenuFragmentToDishesDialogFragment(
                it
            )
        )
    }
}