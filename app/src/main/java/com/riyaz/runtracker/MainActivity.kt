package com.riyaz.runtracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.riyaz.runtracker.db.RunDatabase

class MainActivity : AppCompatActivity() {
    val database by lazy {
        RunDatabase.getDatabase(applicationContext)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}