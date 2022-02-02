package com.atacanugurlu.spotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.atacanugurlu.spotify.databinding.ActivityMainBinding
import com.atacanugurlu.spotify.ui.internal.home.HomeFragment
import com.atacanugurlu.spotify.ui.internal.library.LibraryFragment
import com.atacanugurlu.spotify.ui.internal.search.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()
        initializeApp()

    }

    private fun initializeApp() {
        initializeBinding()
        initializeBottomNavigation()
    }

    private fun initializeBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        bindVariables()
    }

    private fun bindVariables() {
        bottomNavigation = binding.bottomNavigation
    }

    private fun initializeBottomNavigation() {
        bottomNavigation.setOnItemSelectedListener { item ->
            var fragment: Fragment = HomeFragment()
            when (item.itemId) {
                R.id.home -> {
                    if (fragment != HomeFragment()) {
                        fragment = HomeFragment()
                        loadFragment(fragment)
                    }
                    true
                }
                R.id.search -> {
                    if (fragment != SearchFragment()) {
                        fragment = SearchFragment()
                        loadFragment(fragment)
                    }
                    true
                }
                R.id.your_library -> {
                    if (fragment != LibraryFragment()) {
                        fragment = LibraryFragment()
                        loadFragment(fragment)
                    }
                    true
                }
                else -> false
            }
        }
        setBottomVisibility()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.navHostFragment, fragment)
            .commit()
    }

    private fun setBottomVisibility() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        val navController: NavController = navHostFragment.navController

        changeVisibilityOnNavigation(navController)
    }

    private fun changeVisibilityOnNavigation(navController: NavController) {
        navController.addOnDestinationChangedListener { _, navDestination: NavDestination, _ ->
            if (navDestination.id == R.id.homeFragment ||
                navDestination.id == R.id.searchFragment ||
                navDestination.id == R.id.libraryFragment
            ) {
                binding.bottomNavigation.visibility = View.VISIBLE
            } else {
                binding.bottomNavigation.visibility = View.GONE
            }
        }
    }

}