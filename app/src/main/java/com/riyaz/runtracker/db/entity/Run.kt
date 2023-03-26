package com.riyaz.runtracker.db.entity

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.riyaz.runtracker.util.TypeConverter

@TypeConverters(TypeConverter::class)
@Entity(tableName = "run_table")
data class Run(
    var bitmap: Bitmap? = null,
    var timestamp: Long? = null,
    var averageSpeedInKMH: Float = 0F,
    var timeInMillis: Long? = 0,
    var distanceInMeters: Long = 0,
    var caloriesBurned: Int = 0
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null
}