package com.riyaz.runtracker.ui

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.riyaz.runtracker.R
import com.riyaz.runtracker.databinding.ActivityMainBinding
import com.riyaz.runtracker.util.Constants
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setSupportActionBar(binding.toolbar)
    }

    private fun setNavigationBarVisibility(show: Boolean) {
        binding.bottomNavigation.visibility = if(show) View.VISIBLE else View.GONE
    }

    override fun onStart() {
        super.onStart()
        binding.bottomNavigation.setupWithNavController(this.findNavController(R.id.nav_host_fragment))
        this.findNavController(R.id.nav_host_fragment).addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.runFragment,
                R.id.statisticsFragment,
                R.id.settingsFragment -> setNavigationBarVisibility(true)
                else -> setNavigationBarVisibility(false)
            }
        }
        navigateToTrackingFragmentIfNeeded(intent)
    }

    fun navigateToTrackingFragmentIfNeeded(intent: Intent?){
        if(intent?.action == Constants.NAVIGATE_TO_TRACKING_FRAGMENT_ACTION){
            this.findNavController(R.id.nav_host_fragment).navigate(R.id.action_global_to_trackingFragment)
        }
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        navigateToTrackingFragmentIfNeeded(intent)
    }
}