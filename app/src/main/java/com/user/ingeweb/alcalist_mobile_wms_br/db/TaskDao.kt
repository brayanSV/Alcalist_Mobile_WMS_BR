package com.user.ingeweb.alcalist_mobile_wms_br.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.user.ingeweb.alcalist_mobile_wms_br.model.Task

@Dao
abstract class TaskDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(item: Task)

    @Query("select * from task where task.TaskIdejec = :taskId")
    abstract fun loadTaskId(taskId: Long): LiveData<Task>

    @Query("select * from task")
    abstract fun load(): LiveData<List<Task>>
}