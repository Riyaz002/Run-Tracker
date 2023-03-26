package com.riyaz.runtracker.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.riyaz.runtracker.db.dao.RunDao
import com.riyaz.runtracker.db.entity.Run

@Database(entities = [Run::class], version = 1)
abstract class RunDatabase: RoomDatabase() {
    abstract fun getRunDao(): RunDao

    companion object{
        @Volatile var instance: RunDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): RunDatabase {
            return if(instance==null){
                return Room.databaseBuilder(context,RunDatabase::class.java, "Run database").build().also { instance = it }
            } else instance!!
        }
    }
}