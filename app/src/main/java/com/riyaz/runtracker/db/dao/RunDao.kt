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

    @Query("SELECT * FROM run_table")
    abstract fun getAllRuns(): Flow<List<Run>>
}