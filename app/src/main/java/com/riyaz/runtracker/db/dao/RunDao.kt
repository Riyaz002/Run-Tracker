package com.riyaz.runtracker.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.riyaz.runtracker.db.entity.Run
import kotlinx.coroutines.flow.Flow

@Dao
abstract class RunDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract suspend fun insertRun(run: Run)

    @Delete
    abstract suspend fun deleteRun(run: Run)

    @Query("SELECT * FROM run_table ORDER BY timestamp DESC")
    abstract fun getAllRunsSortedByDate(): Flow<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY timeInMillis DESC")
    abstract fun getAllRunsSortedByTimeInMillis(): Flow<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY distanceInMeters DESC")
    abstract fun getAllRunsSortedByDistanceRun(): Flow<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY averageSpeedInKMH DESC")
    abstract fun getAllRunsSortedByAverageSpeed(): Flow<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY caloriesBurned DESC")
    abstract fun getAllRunsSortedByCaloriesBurned(): Flow<List<Run>>

    @Query("SELECT SUM(timeInMillis) FROM run_table")
    abstract fun getTotalTimeInMillis(): LiveData<Long>

    @Query("SELECT SUM(caloriesBurned) FROM run_table")
    abstract fun getTotalCaloriesBurned(): LiveData<Int>

    @Query("SELECT AVG(averageSpeedInKMH) FROM run_table")
    abstract fun getTotalAverageSpeed(): LiveData<Float>
}