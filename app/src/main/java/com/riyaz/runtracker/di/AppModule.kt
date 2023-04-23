package com.riyaz.runtracker.di

import android.content.Context
import androidx.room.Room
import com.riyaz.runtracker.db.RunDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Singleton
    @Provides
    fun providesRunDatabase(
        @ApplicationContext context: Context
    ): RunDatabase  = Room.databaseBuilder(context, RunDatabase::class.java, "Run Database").build()

    @Singleton
    @Provides
    fun getRunDoa(
        db: RunDatabase
    ) = db.getRunDao()
}