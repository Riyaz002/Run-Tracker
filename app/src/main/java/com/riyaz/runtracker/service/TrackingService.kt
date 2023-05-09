package com.riyaz.runtracker.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.NotificationManager.IMPORTANCE_LOW
import android.app.PendingIntent
import android.content.Intent
import androidx.lifecycle.LifecycleService
import com.riyaz.runtracker.R
import com.riyaz.runtracker.ui.MainActivity
import com.riyaz.runtracker.util.Constants.DESTROY_ACTION
import com.riyaz.runtracker.util.Constants.NAVIGATE_TO_TRACKING_FRAGMENT_ACTION
import com.riyaz.runtracker.util.Constants.NOTIFICATION_CHANNEL_ID
import com.riyaz.runtracker.util.Constants.NOTIFICATION_ID
import com.riyaz.runtracker.util.Constants.Notification_CHANNEL_NAME
import com.riyaz.runtracker.util.Constants.PAUSE_ACTION
import com.riyaz.runtracker.util.Constants.START_OR_RESUME_ACTION
import timber.log.Timber

class TrackingService: LifecycleService() {
    var hasStarted = false
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            START_OR_RESUME_ACTION -> {
                if(!hasStarted) startForegroundService()
                else Timber.tag("tracking service").e(intent.action)
            }
            PAUSE_ACTION -> {

                Timber.tag("tracking service").e(intent.action)
            }
            DESTROY_ACTION -> {
                Timber.tag("tracking service").e(intent.action)
            }
        }
        return super.onStartCommand(intent, flags, startId)
    }

    fun startForegroundService(){
        createNotificationChannel(getSystemService(NotificationManager::class.java))
        val notification = Notification.Builder(this@TrackingService, NOTIFICATION_CHANNEL_ID)
            .setContentTitle("Run Tracker")
            .setContentText("00:00:00")
            .setAutoCancel(false)
            .setOngoing(true)
            .setSmallIcon(R.drawable.ic_directions_run_black_24dp)
            .setContentIntent(
                PendingIntent.getActivity(
                    this@TrackingService,
                    0,
                    Intent(this@TrackingService, MainActivity::class.java)
                        .also { it.action = NAVIGATE_TO_TRACKING_FRAGMENT_ACTION },
                    PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
                )
            )
            .build()
        startForeground(NOTIFICATION_ID, notification)
    }

    fun createNotificationChannel(notificationManager: NotificationManager){
        val channel = NotificationChannel(
            NOTIFICATION_CHANNEL_ID,
            Notification_CHANNEL_NAME,
            IMPORTANCE_LOW
        )
        notificationManager.createNotificationChannel(channel)
    }
}