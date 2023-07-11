package com.barfood.presentation.menu

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.barfood.R
import com.barfood.databinding.FragmentMenuBinding
import com.barfood.presentation.bag.BagFragment
import com.barfood.presentation.categories.CategoriesFragment


class MenuFragment : Fragment() {

lateinit var binding: FragmentMenuBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setCurrentFragment(CategoriesFragment())
        binding.BottomNavigationBar.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.main -> {
                    setCurrentFragment(CategoriesFragment())

                }
                R.id.basket -> {
                    setCurrentFragment(BagFragment())

                }
                R.id.account -> {

                }
                R.id.search -> {

                }
            }
            true
        }
        val callback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {

            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(callback)
    }

    private fun setCurrentFragment(fragment: Fragment) =
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.hostMenuFragment, fragment)
            commit()
        }
}