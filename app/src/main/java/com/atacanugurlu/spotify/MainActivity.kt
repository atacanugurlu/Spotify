package com.atacanugurlu.spotify

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import com.atacanugurlu.spotify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

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
    }

    private fun initializeBottomNavigation() {
        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    // Respond to navigation item 1 click
                    true
                }
                R.id.search -> {
                    // Respond to navigation item 2 click
                    true
                }
                R.id.your_library -> {
                    // Respond to navigation item 2 click
                    true
                }
                else -> false
            }
        }
        setBottomNavigationVisibility()
    }

    private fun setBottomNavigationVisibility() {
        val navHostFragment : NavHostFragment=
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        val navController : NavController = navHostFragment.navController

        changeVisibilityOnNavigation(navController)
    }

    private fun changeVisibilityOnNavigation(navController: NavController) {
        navController.addOnDestinationChangedListener { _, navDestination: NavDestination, _ ->
            if (navDestination.id == R.id.homeFragment ||
                navDestination.id == R.id.searchFragment ||
                navDestination.id == R.id.libraryFragment)
                {
                binding.bottomNavigation.visibility = View.VISIBLE
                }
            else
            {
                binding.bottomNavigation.visibility = View.GONE
            }
        }
    }

}