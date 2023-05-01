package com.riyaz.runtracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riyaz.runtracker.R
import com.riyaz.runtracker.db.dao.RunDao
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject lateinit var dao: RunDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}