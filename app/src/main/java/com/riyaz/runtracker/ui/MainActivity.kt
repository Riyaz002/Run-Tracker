package com.riyaz.runtracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.riyaz.runtracker.R
import com.riyaz.runtracker.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        //setSupportActionBar(binding.toolbar)

    }

    override fun onStart() {
        super.onStart()
        binding.bottomNavigation.setupWithNavController(this.findNavController(R.id.nav_host_fragment))
    }
}