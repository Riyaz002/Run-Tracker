package com.riyaz.runtracker.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.riyaz.runtracker.db.dao.RunDao
import com.riyaz.runtracker.db.entity.Run
import com.riyaz.runtracker.util.TypeConverter

@TypeConverters(TypeConverter::class)
@Database(entities = [Run::class], version = 1)
abstract class RunDatabase: RoomDatabase() {
    abstract fun getRunDao(): RunDao
}