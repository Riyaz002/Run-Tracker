package com.riyaz.runtracker.repository

import com.riyaz.runtracker.db.dao.RunDao
import com.riyaz.runtracker.db.entity.Run
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val runDao: RunDao
) {
    suspend fun insertRun(run: Run) = runDao.insertRun(run)

    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunSortedByDate() = runDao.getAllRunsSortedByDate()

    fun getAllRunSortedByDistanceRun() = runDao.getAllRunsSortedByDistanceRun()

    fun getAllRunSortedByAverageSpeed() = runDao.getAllRunsSortedByAverageSpeed()

    fun getAllRunSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()

    fun getAllRunSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeInMillis()
}