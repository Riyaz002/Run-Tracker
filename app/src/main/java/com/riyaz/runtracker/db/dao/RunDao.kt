package com.riyaz.runtracker.db.dao

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
    abstract fun getAllRunsSortedByTimestamp(): Flow<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY distanceInMeters DESC")
    abstract fun getAllRunsSortedByDistanceRun(): Flow<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY averageSpeedInKMH DESC")
    abstract fun getAllRunsSortedByAverageSpeed(): Flow<List<Run>>

    @Query("SELECT * FROM run_table ORDER BY caloriesBurned DESC")
    abstract fun getAllRunsSortedByCaloriesBurned(): Flow<List<Run>>
}