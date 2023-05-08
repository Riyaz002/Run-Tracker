package com.riyaz.runtracker.service

import android.content.Intent
import android.util.Log
import androidx.lifecycle.LifecycleService
import com.riyaz.runtracker.Constansts.DESTROY_ACTION
import com.riyaz.runtracker.Constansts.PAUSE_ACTION
import com.riyaz.runtracker.Constansts.START_OR_RESUME_ACTION
import timber.log.Timber

class TrackingService: LifecycleService() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        when(intent?.action){
            START_OR_RESUME_ACTION -> {
                Timber.tag("tracking service").e(intent.action)
            }
            PAUSE_ACTION -> {
                Timber.tag("tracking service").e(intent.action)
            }
            DESTROY_ACTION -> {
                Timber.tag("tracking service").e(intent.action)
            }
        }
        return START_STICKY
    }
}