package com.d121201031.taskapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TaskDao {
    @Insert(onConflict =  OnConflictStrategy.IGNORE)
    suspend fun insertTask(taskModel: TaskModel):Long

    @Query("Select * from task where isFinished == 0")
    fun getTask(): LiveData<List<TaskModel>>
}